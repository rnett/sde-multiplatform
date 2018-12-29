
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

@Serializable(with = invflag.Companion::class)
expect class invflag {
    val flagID: Int
    val flagName: String
    val flagText: String
    val orderID: Int

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
    override fun toString(): String

    @Serializer(invflag::class)
    companion object : KSerializer<invflag> {
        fun getItem(id: Int): invflag
        fun allItems(): List<invflag>


        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: invflag)

        override fun deserialize(input: Decoder): invflag

        fun serializer(): KSerializer<invflag>
    }
}

operator fun invflag.Companion.get(id: Int) = getItem(id)
operator fun invflag.Companion.invoke() = allItems()


