package com.rnett.ligraph.eve.sde

import com.github.salomonbrys.kotson.get
import com.google.gson.JsonParser
import com.kizitonwose.time.minutes
import com.rnett.core.Cache
import com.rnett.core.ManualCache
import com.rnett.ligraph.eve.sde.data.invtype
import com.rnett.ligraph.eve.sde.data.invtypes
import io.ktor.client.HttpClient
import io.ktor.client.engine.apache.Apache
import io.ktor.client.request.post
import kotlinx.coroutines.runBlocking
import java.net.URLEncoder
import kotlin.math.ceil

fun Map<invtype, Number>.toItemList() = ItemList(this.mapValues { it.value.toLong() })
fun Map<invtype, Number>.toMutableItemList() = MutableItemList(this.mapValues { it.value.toLong() })

fun Collection<Pair<invtype, Number>>.toItemList() = ItemList(this.map { Pair(it.first, it.second.toLong()) })
fun Collection<Pair<invtype, Number>>.toMutableItemList() =
    MutableItemList(this.map { Pair(it.first, it.second.toLong()) })

fun Sequence<Pair<invtype, Number>>.toItemList() = ItemList(this.map { Pair(it.first, it.second.toLong()) }.toList())
fun Sequence<Pair<invtype, Number>>.toMutableItemList() =
    MutableItemList(this.map { Pair(it.first, it.second.toLong()) }.toList())

fun Collection<Map.Entry<invtype, Number>>.entriesToItemList() = ItemList(this.map { Pair(it.key, it.value.toLong()) })
fun Collection<Map.Entry<invtype, Number>>.entriesToMutableItemList() =
    MutableItemList(this.map { Pair(it.key, it.value.toLong()) })

fun Sequence<Map.Entry<invtype, Number>>.entriesToItemList() =
    ItemList(this.map { Pair(it.key, it.value.toLong()) }.toList())

fun Sequence<Map.Entry<invtype, Number>>.entriesToMutableItemList() =
    MutableItemList(this.map { Pair(it.key, it.value.toLong()) }.toList())

class ItemList(val map: Map<invtype, Long> = mapOf<invtype, Long>()) : Map<invtype, Long> {
    constructor(items: List<Pair<invtype, Long>>) : this(items.groupBy { it.first }.mapValues {
        it.value.reduce { p1, p2 ->
            Pair(
                p1.first,
                p1.second + p2.second
            )
        }.second
    }.toMap())

    override val entries: Set<Map.Entry<invtype, Long>>
        get() = map.entries
    override val keys: Set<invtype>
        get() = map.keys
    override val size: Int
        get() = map.size
    override val values: Collection<Long>
        get() = map.values

    override fun containsKey(key: invtype): Boolean = map.containsKey(key)

    override fun containsValue(value: Long): Boolean = map.containsValue(value)

    override fun get(key: invtype): Long = map.get(key) ?: 0

    override fun isEmpty(): Boolean = map.isEmpty()

    fun toMutableItemList(): MutableItemList = MutableItemList(map)

    operator fun plus(list: Map<invtype, Long>): ItemList {
        val mil = list.toMutableItemList()
        mil.addAll(this)
        return mil.toItemList()
    }

    operator fun plus(list: List<Pair<invtype, Long>>): ItemList {
        val mil = list.toMutableItemList()
        mil.addAll(this)
        return mil.toItemList()
    }

    operator fun minus(list: Map<invtype, Long>): ItemList = plus(list.mapValues { it.value * -1 })
    operator fun minus(list: List<Pair<invtype, Long>>): ItemList = plus(list.map { Pair(it.first, it.second * -1) })

    operator fun times(mult: Number): ItemList =
        this.mapValues { ceil(it.value * mult.toDouble()).toLong() }.toItemList()

    operator fun div(mult: Number): ItemList = this.mapValues { ceil(it.value / mult.toDouble()).toLong() }.toItemList()
}

class MutableItemList(map: Map<invtype, Long> = mapOf()) : MutableMap<invtype, Long> {
    constructor(items: List<Pair<invtype, Long>>) : this(items.groupBy { it.first }.mapValues {
        it.value.reduce { p1, p2 ->
            Pair(
                p1.first,
                p1.second + p2.second
            )
        }.second
    }.toMap())

    val map = map.toMutableMap()

    override val size: Int
        get() = map.size

    override fun containsKey(key: invtype): Boolean = map.containsKey(key)

    override fun containsValue(value: Long): Boolean = map.containsValue(value)

    override fun get(key: invtype): Long = map[key] ?: 0

    override fun isEmpty(): Boolean = map.isEmpty()

    override val entries: MutableSet<MutableMap.MutableEntry<invtype, Long>>
        get() = map.entries
    override val keys: MutableSet<invtype>
        get() = map.keys
    override val values: MutableCollection<Long>
        get() = map.values

    override fun clear() = map.clear()

    override fun put(key: invtype, value: Long): Long = map.put(key, value) ?: 0

    fun add(key: invtype, value: Long): Long {
        return if (map.containsKey(key))
            map.put(key, map[key]!! + value) ?: 0
        else
            map.put(key, value) ?: 0
    }

    fun removeNegatives() {
        val bads = map.filter { it.value <= 0 }
        bads.forEach { map.remove(it.key) }
    }

    override fun putAll(from: Map<out invtype, Long>) {
        from.forEach { put(it.key, it.value) }
    }

    fun putAll(from: List<Pair<out invtype, Long>>) {
        from.toItemList().forEach { put(it.key, it.value) }
    }

    fun addAll(from: Map<out invtype, Long>) {
        from.forEach { add(it.key, it.value) }
    }

    fun addAll(from: List<Pair<out invtype, Long>>) {
        from.forEach { add(it.first, it.second) }
    }

    override fun remove(key: invtype): Long? = map.remove(key)

    operator fun set(key: invtype, value: Long) = put(key, value)

    operator fun plus(list: Map<invtype, Long>): MutableItemList {
        val mil = list.toMutableItemList()
        mil.addAll(this)
        return mil
    }

    operator fun plus(list: List<Pair<invtype, Long>>): MutableItemList {
        val mil = list.toMutableItemList()
        mil.addAll(this)
        return mil
    }

    operator fun minus(list: Map<invtype, Long>): MutableItemList = plus(list.mapValues { it.value * -1 })
    operator fun minus(list: List<Pair<invtype, Long>>): MutableItemList =
        plus(list.map { Pair(it.first, it.second * -1) })

    operator fun times(mult: Number): MutableItemList =
        this.mapValues { ceil(it.value * mult.toDouble()).toLong() }.toMutableItemList()

    operator fun div(mult: Number): MutableItemList =
        this.mapValues { ceil(it.value / mult.toDouble()).toLong() }.toMutableItemList()

    fun toItemList(): ItemList = ItemList(map)
}

fun MutableItemList.parse(raw: String) {
    this.clear()

    var lines = raw.split("\n").filter { !it.isBlank() }

    if (lines.isEmpty())
        lines = listOf(raw)

    lines.forEach {
        when {
            it.contains(Regex("x[0-9]")) -> // $type x$amount or $typex$amount
                try {
                    this[invtypes.fromName(it.substringBeforeLast("x").trim())!!] = it.substringAfterLast("x").toLong()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            it.contains(Regex("[ \t][0-9]")) -> // $type $amount$type x$amount
                try {
                    this[invtypes.fromName(it.replace("\t", " ").substringBeforeLast(" ").trim())!!] =
                            it.replace("\t", " ").substringAfterLast(" ").toLong()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            !it.isBlank() -> // $type
                try {
                    this[invtypes.fromName(it.trim())!!] = 1
                } catch (e: Exception) {
                    e.printStackTrace()
                }
        }
    }
}

data class Price(val buy: Double, val sell: Double) {
    operator fun plus(p: Price): Price {
        return Price(buy + p.buy, sell + p.sell)
    }

    operator fun minus(p: Price): Price {
        return Price(buy - p.buy, sell - p.sell)
    }

    operator fun times(amount: Double): Price {
        return Price(buy * amount, sell * amount)
    }

    operator fun div(amount: Double): Price {
        return Price(buy / amount, sell / amount)
    }

    operator fun times(amount: Int): Price {
        return Price(buy * amount, sell * amount)
    }

    operator fun div(amount: Int): Price {
        return Price(buy / amount, sell / amount)
    }

    operator fun times(amount: Long): Price {
        return Price(buy * amount, sell * amount)
    }

    operator fun div(amount: Long): Price {
        return Price(buy / amount, sell / amount)
    }
}

fun <E : Collection<Price>> E.sell() = this.map { it.sell }
fun <E : Collection<Price>> E.buy() = this.map { it.sell }

fun <T, E : Map<T, Price>> E.sell() = this.mapValues { it.value.sell }
fun <T, E : Map<T, Price>> E.buy() = this.mapValues { it.value.buy }

val priceCache = ManualCache<invtype, Price>(30.minutes)

fun getPrices(types: List<invtype>): Map<invtype, Price> {
    val neededPrices: MutableList<invtype> = mutableListOf()

    // check cache
    types.forEach {
        if (!priceCache.containsKey(it))
            neededPrices += it
    }

    // update cache
    if (neededPrices.size > 0) {
        val client = HttpClient()

        val url = "https://evepraisal.com/appraisal.json?market=jita&raw_textarea=${URLEncoder.encode(neededPrices
            .joinToString("\n") { it.typeName }, "utf-8"
        )}${"&persist=no"}"

        val text: String = runBlocking {
            client.post<String>(url) {
                headers["User-Agent"] = "Ligraph/jnett96@gmail.com.  Calls are cached."
            }
        }

        val json = JsonParser().parse(text).asJsonObject

        val newPricesIDs = json["appraisal"]["items"].asJsonArray.map {
            Pair(
                it["typeID"].asInt,
                Price(
                    it["prices"]["buy"]["max"].asDouble,
                    it["prices"]["sell"]["min"].asDouble
                )
            )
        }.toMap()

        val newPrices = neededPrices.map { Pair(it, newPricesIDs[it.typeID]!!) }.toMap()
        newPrices.entries.forEach {
            priceCache[it.key] = it.value
        }
    }
    return types.map { Pair(it, priceCache[it]!!) }.toMap()
}

data class Appraisal(val prices: Map<invtype, Price>, val amounts: ItemList) {
    val totalPrices: Map<invtype, Price> = prices.mapValues { it.value * amounts[it.key] }
    val totalPrice: Price = totalPrices.values.reduce { a, b -> a + b }
}

fun ItemList.appraise() = Appraisal(getPrices(), this)

fun ItemList.getPrices() = getPrices(this.keys.toList())
fun Collection<invtype>.getPrices() = getPrices(this.toList())

val evepraisalCache = Cache<ItemList, String>(10.minutes) {
    val client = HttpClient(Apache)

    val url = "https://evepraisal.com/appraisal.json?market=jita&raw_textarea=${URLEncoder.encode(it.entries
        .joinToString("\n") { it.key.typeName + "%09" + it.value.toString() }, "utf-8"
    )}"

    val text: String = runBlocking {
        client.post<String>(url) {
            headers["User-Agent"] = "Ligraph/jnett96@gmail.com.  Calls are cached."
        }
    }
    JsonParser().parse(text).asJsonObject["appraisal"]["id"].asString
}

fun ItemList.evePraisal(): String = evepraisalCache[this]
