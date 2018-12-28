package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

expect class mapuniverse {
    val universeID: Int
    val universeName: String
    val x: Double
    val y: Double
    val z: Double
    val xMin: Double
    val xMax: Double
    val yMin: Double
    val yMax: Double
    val zMin: Double
    val zMax: Double
    val radius: Double

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
    override fun toString(): String

    @Serializer(mapuniverse::class)
    companion object : KSerializer<mapuniverse> {
        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: mapuniverse)

        override fun deserialize(input: Decoder): mapuniverse

        fun serializer(): KSerializer<mapuniverse>
    }
}

