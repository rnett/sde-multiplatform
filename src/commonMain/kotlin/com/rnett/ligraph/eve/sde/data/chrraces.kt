package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

expect class chrrace {
    val raceID: Int
    val raceName: String
    val description: String
    val iconID: Int
    val shortDescription: String

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
    override fun toString(): String

    @Serializer(chrrace::class)
    companion object : KSerializer<chrrace> {
        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: chrrace)

        override fun deserialize(input: Decoder): chrrace

        fun serializer(): KSerializer<chrrace>
    }
}

