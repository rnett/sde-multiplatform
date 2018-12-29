
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

expect class trntranslationcolumn {
    val tcGroupID: Int
    val tcID: Int
    val tableName: String
    val columnName: String
    val masterID: String

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int

    @Serializer(trntranslationcolumn::class)
    companion object : KSerializer<trntranslationcolumn> {
        fun getItem(id: Int): trntranslationcolumn
        fun allItems(): List<trntranslationcolumn>
        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: trntranslationcolumn)

        override fun deserialize(input: Decoder): trntranslationcolumn

        fun serializer(): KSerializer<trntranslationcolumn>
    }
}

