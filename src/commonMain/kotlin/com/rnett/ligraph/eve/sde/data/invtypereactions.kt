
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

expect class invtypereaction {
    val reactionTypeID: Int
    val input: Boolean
    val typeID: Int
    val quantity: Int

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int

    @Serializer(invtypereaction::class)
    companion object : KSerializer<invtypereaction> {
        fun getItem(id: Int): invtypereaction
        fun allItems(): List<invtypereaction>
        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: invtypereaction)

        override fun deserialize(input: Decoder): invtypereaction

        fun serializer(): KSerializer<invtypereaction>
    }
}

