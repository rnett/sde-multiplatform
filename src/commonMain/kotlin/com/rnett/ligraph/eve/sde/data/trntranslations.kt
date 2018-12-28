package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

expect class trntranslation {
    val tcID: Int
    val keyID: Int
    val languageID: String
    val text: String

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int

    @Serializer(trntranslation::class)
    companion object : KSerializer<trntranslation> {
        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: trntranslation)

        override fun deserialize(input: Decoder): trntranslation

        fun serializer(): KSerializer<trntranslation>
    }
}

