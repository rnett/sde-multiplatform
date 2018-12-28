package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

expect class invposition {
    val itemID: Int
    val x: Double
    val y: Double
    val z: Double
    val yaw: Float
    val pitch: Float
    val roll: Float

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int

    @Serializer(invposition::class)
    companion object : KSerializer<invposition> {
        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: invposition)

        override fun deserialize(input: Decoder): invposition

        fun serializer(): KSerializer<invposition>
    }
}

