package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

expect class trntranslationlanguage {
    val numericLanguageID: Int
    val languageID: String
    val languageName: String

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
    override fun toString(): String

    @Serializer(trntranslationlanguage::class)
    companion object : KSerializer<trntranslationlanguage> {
        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: trntranslationlanguage)

        override fun deserialize(input: Decoder): trntranslationlanguage

        fun serializer(): KSerializer<trntranslationlanguage>
    }
}

