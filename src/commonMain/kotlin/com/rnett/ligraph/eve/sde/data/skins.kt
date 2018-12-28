package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

expect class skin {
    val skinID: Int
    val internalName: String
    val skinMaterialID: Int

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
    override fun toString(): String

    @Serializer(skin::class)
    companion object : KSerializer<skin> {
        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: skin)

        override fun deserialize(input: Decoder): skin

        fun serializer(): KSerializer<skin>
    }
}

