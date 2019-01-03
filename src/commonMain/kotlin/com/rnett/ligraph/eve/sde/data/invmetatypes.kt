
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

@Serializable(with = invmetatype.Companion::class)
expect class invmetatype {
    val typeID: Int
    val parentTypeID: Int
    val metaGroupID: Int

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int

    @Serializer(invmetatype::class)
    companion object : KSerializer<invmetatype> {
        fun getItem(id: Int): invmetatype
        fun allItems(): List<invmetatype>


        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: invmetatype)

        override fun deserialize(input: Decoder): invmetatype

        fun serializer(): KSerializer<invmetatype>
    }
}
operator fun invmetatype.Companion.get(id: Int) = getItem(id)
operator fun invmetatype.Companion.invoke() = allItems()


