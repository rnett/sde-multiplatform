
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

@Serializable(with = chrfaction.Companion::class)
expect class chrfaction {
    val factionID: Int
    val factionName: String
    val description: String
    val raceIDs: Int
    val solarSystemID: Int
    val corporationID: Int
    val sizeFactor: Double
    val stationCount: Int
    val stationSystemCount: Int
    val militiaCorporationID: Int
    val iconID: Int

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
    override fun toString(): String

    @Serializer(chrfaction::class)
    companion object : KSerializer<chrfaction> {
        fun getItem(id: Int): chrfaction
        fun allItems(): List<chrfaction>


        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: chrfaction)

        override fun deserialize(input: Decoder): chrfaction

        fun serializer(): KSerializer<chrfaction>
    }
}

operator fun chrfaction.Companion.get(id: Int) = getItem(id)
operator fun chrfaction.Companion.invoke() = allItems()


