
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

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

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
    override fun toString(): String

    @Serializer(mapconstellation::class)
    companion object : KSerializer<mapconstellation> {
        fun getItem(id: Int): mapconstellation
        fun allItems(): List<mapconstellation>
        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: mapconstellation)

        override fun deserialize(input: Decoder): mapconstellation

        fun serializer(): KSerializer<mapconstellation>
    }
}

