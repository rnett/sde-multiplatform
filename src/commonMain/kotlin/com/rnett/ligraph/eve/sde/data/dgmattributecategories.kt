
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

expect class dgmattributecategory {
    val categoryID: Int
    val categoryName: String
    val categoryDescription: String

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
    override fun toString(): String

    @Serializer(dgmattributecategory::class)
    companion object : KSerializer<dgmattributecategory> {
        fun getItem(id: Int): dgmattributecategory
        fun allItems(): List<dgmattributecategory>
        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: dgmattributecategory)

        override fun deserialize(input: Decoder): dgmattributecategory

        fun serializer(): KSerializer<dgmattributecategory>
    }
}

