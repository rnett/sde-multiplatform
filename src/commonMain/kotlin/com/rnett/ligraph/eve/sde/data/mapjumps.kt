package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

expect class mapjump {
    val stargateID: Int
    val destinationID: Int

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int

    @Serializer(mapjump::class)
    companion object : KSerializer<mapjump> {
        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: mapjump)

        override fun deserialize(input: Decoder): mapjump

        fun serializer(): KSerializer<mapjump>
    }
}

