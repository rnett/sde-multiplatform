
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

expect class invmarketgroup {
    val marketGroupID: Int
    val parentGroupID: Int
    val marketGroupName: String
    val description: String
    val iconID: Int
    val hasTypes: Boolean

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
    override fun toString(): String

    @Serializer(invmarketgroup::class)
    companion object : KSerializer<invmarketgroup> {
        fun getItem(id: Int): invmarketgroup
        fun allItems(): List<invmarketgroup>
        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: invmarketgroup)

        override fun deserialize(input: Decoder): invmarketgroup

        fun serializer(): KSerializer<invmarketgroup>
    }
}

