package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

expect class maplandmark {
    val landmarkID: Int
    val landmarkName: String
    val description: String
    val locationID: Int
    val x: Double
    val y: Double
    val z: Double
    val iconID: Int

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
    override fun toString(): String

    @Serializer(maplandmark::class)
    companion object : KSerializer<maplandmark> {
        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: maplandmark)

        override fun deserialize(input: Decoder): maplandmark

        fun serializer(): KSerializer<maplandmark>
    }
}

