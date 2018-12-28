package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

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

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
    override fun toString(): String

    @Serializer(mapregion::class)
    companion object : KSerializer<mapregion> {
        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: mapregion)

        override fun deserialize(input: Decoder): mapregion

        fun serializer(): KSerializer<mapregion>
    }
}

