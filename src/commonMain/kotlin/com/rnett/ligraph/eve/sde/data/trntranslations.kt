
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

@Serializable(with = trntranslation.Companion::class)
expect class trntranslation {
    val tcID: Int
    val keyID: Int
    val languageID: String
    val text: String

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int

    @Serializer(trntranslation::class)
    companion object : KSerializer<trntranslation> {
        fun getItem(id: Int): trntranslation
        fun allItems(): List<trntranslation>


        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: trntranslation)

        override fun deserialize(input: Decoder): trntranslation

        fun serializer(): KSerializer<trntranslation>
    }
}

operator fun trntranslation.Companion.get(id: Int) = getItem(id)
operator fun trntranslation.Companion.invoke() = allItems()


