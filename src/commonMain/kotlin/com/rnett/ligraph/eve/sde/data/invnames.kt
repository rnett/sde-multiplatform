
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

@Serializable(with = invname.Companion::class)
expect class invname {
    val itemID: Int
    val itemName: String

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
    override fun toString(): String

    @Serializer(invname::class)
    companion object : KSerializer<invname> {
        fun getItem(id: Int): invname
        fun allItems(): List<invname>


        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: invname)

        override fun deserialize(input: Decoder): invname

        fun serializer(): KSerializer<invname>
    }
}
operator fun invname.Companion.get(id: Int) = getItem(id)
operator fun invname.Companion.invoke() = allItems()


