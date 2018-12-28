package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

expect class eveunit {
    val unitID: Int
    val unitName: String
    val displayName: String
    val description: String

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int

    @Serializer(eveunit::class)
    companion object : KSerializer<eveunit> {
        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: eveunit)

        override fun deserialize(input: Decoder): eveunit

        fun serializer(): KSerializer<eveunit>
    }
}
