package com.rnett.ligraph.eve.sde

import com.rnett.core.Cache
import com.rnett.ligraph.eve.sde.data.*
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

val typeCache: Cache<Int, invtype?> = Cache {
    val type = transaction { invtype.findById(it) }

    if (type != null)
        nameCache.put(type.typeName, type)

    type
}

fun invtypes.fromID(typeID: Int): invtype? = typeCache[typeID]

val nameCache = Cache<String, invtype?> {
    val type = transaction { invtype.find { invtypes.typeName eq it }.firstOrNull() }

    if (type != null)
        typeCache.put(type.typeID, type)

    type
}

fun invtypes.fromName(typeName: String): invtype? = nameCache[typeName]

fun invtype.imageURL(width: Int) = "https://imageserver.eveonline.com/Type/${typeID}_$width.png"

fun invtype.renderURL(width: Int) = "https://imageserver.eveonline.com/Render/${typeID}_$width.png"

//TODO moongo

val invtype.isMineral: Boolean
    get() = this.groupID == 18

val oreCache: MutableMap<invtype, Boolean> = mutableMapOf()

val invtype.isOre: Boolean
    get() = oreCache.computeIfAbsent(this@isOre) { transaction { this@isOre.group.categoryID == 25 } }


class Ore(val type: invtype) {

    val materials: ItemList

    val Tritanium: Long
    val Pyerite: Long
    val Mexallon: Long
    val Isogen: Long
    val Nocxium: Long
    val Zydrine: Long
    val Megacyte: Long
    val Morphite: Long

    init {
        if (!type.isOre)
            throw IllegalArgumentException("type must be an ore type!")

        materials = transaction {
            invtypematerials.select { invtypematerials.typeID eq type.typeID }.map {
                Pair(invtype[it[invtypematerials.materialTypeID]], it[invtypematerials.quantity])
            }.toItemList()
        }

        Tritanium = materials.filterKeys { it.typeName == "Tritanium" }.values.firstOrNull() ?: 0

        Pyerite = materials.filterKeys { it.typeName == "Pyerite" }.values.firstOrNull() ?: 0

        Mexallon = materials.filterKeys { it.typeName == "Mexallon" }.values.firstOrNull() ?: 0

        Isogen = materials.filterKeys { it.typeName == "Isogen" }.values.firstOrNull() ?: 0

        Nocxium = materials.filterKeys { it.typeName == "Nocxium" }.values.firstOrNull() ?: 0

        Zydrine = materials.filterKeys { it.typeName == "Zydrine" }.values.firstOrNull() ?: 0

        Megacyte = materials.filterKeys { it.typeName == "Megacyte" }.values.firstOrNull() ?: 0

        Morphite = materials.filterKeys { it.typeName == "Morphite" }.values.firstOrNull() ?: 0
    }

    operator fun get(typeName: String): Long =
        materials.filterKeys { it.typeName == "typeName" }.values.firstOrNull() ?: 0


    operator fun get(type: invtype): Long = materials[type]

}

//TODO store these in a file
val oreTypes: List<invtype> = transaction { invcategory[25].invgroups_rk.flatMap { it.invtypes_rk }.toList() }

val minerals: List<invtype> = transaction { invgroup[18].invtypes_rk.toList() }

val compressedOreTypes: List<invtype> = transaction { oreTypes.filter { it.typeName.contains("Compressed", true) } }

//val ores: List<com.rnett.ligraph.eve.sde.Ore> = transaction{ com.rnett.eve.ligraph.sde.invcategories.findFromPKs(25)!!.invcategory_invgroups_category.flatMap { it.invgroup_invtypes_group }.toList() }.map{com.rnett.ligraph.eve.sde.Ore(it)}

val compressedOres: List<Ore> =
    transaction { oreTypes.filter { it.typeName.contains("Compressed", true) } }.map { Ore(it) }

val solarSystemCache = Cache<Int, mapsolarsystem> {
    transaction { mapsolarsystem[it] }
}

fun mapsolarsystems.fromID(solarSystemID: Int) = solarSystemCache[solarSystemID]

val constellationCache = Cache<Int, mapconstellation> {
    transaction { mapconstellation[it] }
}

fun mapconstellations.fromID(constellationID: Int) = constellationCache[constellationID]

val regionCache = Cache<Int, mapregion> {
    transaction { mapregion[it] }
}

fun mapregions.fromID(regionID: Int) = regionCache[regionID]