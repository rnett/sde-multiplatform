
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

expect class dgmattributetype {
    val attributeID: Int
    val attributeName: String
    val description: String
    val iconID: Int
    val defaultValue: Double
    val published: Boolean
    val displayName: String
    val unitID: Int
    val stackable: Boolean
    val highIsGood: Boolean
    val categoryID: Int

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int

    @Serializer(dgmattributetype::class)
    companion object : KSerializer<dgmattributetype> {
        fun getItem(id: Int): dgmattributetype
        fun allItems(): List<dgmattributetype>
        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: dgmattributetype)

        override fun deserialize(input: Decoder): dgmattributetype

        fun serializer(): KSerializer<dgmattributetype>
    }
}

