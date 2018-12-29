
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

expect class invitem {
    val itemID: Int
    val typeID: Int
    val ownerID: Int
    val locationID: Int
    val flagID: Int
    val quantity: Int

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int

    @Serializer(invitem::class)
    companion object : KSerializer<invitem> {
        fun getItem(id: Int): invitem
        fun allItems(): List<invitem>
        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: invitem)

        override fun deserialize(input: Decoder): invitem

        fun serializer(): KSerializer<invitem>
    }
}

