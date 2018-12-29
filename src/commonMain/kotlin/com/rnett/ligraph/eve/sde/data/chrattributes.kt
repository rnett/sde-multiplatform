
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

expect class chrattribute {
    val attributeID: Int
    val attributeName: String
    val description: String
    val iconID: Int
    val shortDescription: String
    val notes: String

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
    override fun toString(): String

    @Serializer(chrattribute::class)
    companion object : KSerializer<chrattribute> {
        fun getItem(id: Int): chrattribute
        fun allItems(): List<chrattribute>
        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: chrattribute)

        override fun deserialize(input: Decoder): chrattribute

        fun serializer(): KSerializer<chrattribute>
    }
}

