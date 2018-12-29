
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

@Serializable(with = mapconstellation.Companion::class)
expect class mapconstellation {
    val regionID: Int
    val constellationID: Int
    val constellationName: String
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

    val region: mapregion
    val mapsolarsystems_rk: List<mapsolarsystem>
    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
    override fun toString(): String

    @Serializer(mapconstellation::class)
    companion object : KSerializer<mapconstellation> {
        fun getItem(id: Int): mapconstellation
        fun allItems(): List<mapconstellation>

        fun getRegion(item: mapconstellation): mapregion

        fun getMapsolarsystems_rk(item: mapconstellation): List<mapsolarsystem>

        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: mapconstellation)

        override fun deserialize(input: Decoder): mapconstellation

        fun serializer(): KSerializer<mapconstellation>
    }
}

operator fun mapconstellation.Companion.get(id: Int) = getItem(id)
operator fun mapconstellation.Companion.invoke() = allItems()


