
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

@Serializable(with = mapregion.Companion::class)
expect class mapregion {
    val regionID: Int
    val regionName: String
    val x: Double
    val y: Double
    val z: Double
    val xMin: Double
    val xMax: Double
    val yMin: Double
    val yMax: Double
    val zMin: Double
    val zMax: Double
    val factionID: Int
    val radius: Double

    val mapconstellatia: List<mapconstellation>
    val mapsolarsystems_rk: List<mapsolarsystem>
    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
    override fun toString(): String

    @Serializer(mapregion::class)
    companion object : KSerializer<mapregion> {
        fun getItem(id: Int): mapregion
        fun allItems(): List<mapregion>


        fun getMapconstellatia(item: mapregion): List<mapconstellation>
        fun getMapsolarsystems_rk(item: mapregion): List<mapsolarsystem>

        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: mapregion)

        override fun deserialize(input: Decoder): mapregion

        fun serializer(): KSerializer<mapregion>
    }
}
operator fun mapregion.Companion.get(id: Int) = getItem(id)
operator fun mapregion.Companion.invoke() = allItems()


