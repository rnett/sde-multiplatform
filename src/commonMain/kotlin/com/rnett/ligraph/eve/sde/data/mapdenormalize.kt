
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

@Serializable(with = mapdenormalize.Companion::class)
expect class mapdenormalize {
    val itemID: Int
    val typeID: Int
    val groupID: Int
    val solarSystemID: Int
    val constellationID: Int
    val regionID: Int
    val orbitID: Int
    val x: Double
    val y: Double
    val z: Double
    val radius: Double
    val itemName: String
    val security: Double
    val celestialIndex: Int
    val orbitIndex: Int

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
    override fun toString(): String

    @Serializer(mapdenormalize::class)
    companion object : KSerializer<mapdenormalize> {
        fun getItem(id: Int): mapdenormalize
        fun allItems(): List<mapdenormalize>


        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: mapdenormalize)

        override fun deserialize(input: Decoder): mapdenormalize

        fun serializer(): KSerializer<mapdenormalize>
    }
}

operator fun mapdenormalize.Companion.get(id: Int) = getItem(id)
operator fun mapdenormalize.Companion.invoke() = allItems()


