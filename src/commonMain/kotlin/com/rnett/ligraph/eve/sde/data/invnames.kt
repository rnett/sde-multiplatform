package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

expect class invname {
    val itemID: Int
    val itemName: String

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
    override fun toString(): String

    @Serializer(invname::class)
    companion object : KSerializer<invname> {
        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: invname)

        override fun deserialize(input: Decoder): invname

        fun serializer(): KSerializer<invname>
    }
}

