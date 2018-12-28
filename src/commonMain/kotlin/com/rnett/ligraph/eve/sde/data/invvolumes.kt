package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

expect class invvolume {
    val typeID: Int
    val volume: Int

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int

    @Serializer(invvolume::class)
    companion object : KSerializer<invvolume> {
        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: invvolume)

        override fun deserialize(input: Decoder): invvolume

        fun serializer(): KSerializer<invvolume>
    }
}

