
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

expect class invcategory {
    val categoryID: Int
    val categoryName: String
    val iconID: Int
    val published: Boolean

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
    override fun toString(): String

    @Serializer(invcategory::class)
    companion object : KSerializer<invcategory> {
        fun getItem(id: Int): invcategory
        fun allItems(): List<invcategory>
        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: invcategory)

        override fun deserialize(input: Decoder): invcategory

        fun serializer(): KSerializer<invcategory>
    }
}

