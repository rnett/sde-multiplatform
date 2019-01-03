
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

@Serializable(with = invuniquename.Companion::class)
expect class invuniquename {
    val itemID: Int
    val itemName: String
    val groupID: Int

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
    override fun toString(): String

    @Serializer(invuniquename::class)
    companion object : KSerializer<invuniquename> {
        fun getItem(id: Int): invuniquename
        fun allItems(): List<invuniquename>


        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: invuniquename)

        override fun deserialize(input: Decoder): invuniquename

        fun serializer(): KSerializer<invuniquename>
    }
}
operator fun invuniquename.Companion.get(id: Int) = getItem(id)
operator fun invuniquename.Companion.invoke() = allItems()


