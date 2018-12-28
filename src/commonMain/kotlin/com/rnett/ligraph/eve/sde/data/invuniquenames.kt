package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

expect class invuniquename {
    val itemID: Int
    val itemName: String
    val groupID: Int

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
    override fun toString(): String

    @Serializer(invuniquename::class)
    companion object : KSerializer<invuniquename> {
        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: invuniquename)

        override fun deserialize(input: Decoder): invuniquename

        fun serializer(): KSerializer<invuniquename>
    }
}

