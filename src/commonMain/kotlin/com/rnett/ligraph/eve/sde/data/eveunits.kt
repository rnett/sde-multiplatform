
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

@Serializable(with = eveunit.Companion::class)
expect class eveunit {
    val unitID: Int
    val unitName: String
    val displayName: String
    val description: String

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int

    @Serializer(eveunit::class)
    companion object : KSerializer<eveunit> {
        fun getItem(id: Int): eveunit
        fun allItems(): List<eveunit>


        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: eveunit)

        override fun deserialize(input: Decoder): eveunit

        fun serializer(): KSerializer<eveunit>
    }
}

operator fun eveunit.Companion.get(id: Int) = getItem(id)
operator fun eveunit.Companion.invoke() = allItems()


