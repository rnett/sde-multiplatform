
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

expect class eveicon {
    val iconID: Int
    val iconFile: String
    val description: String

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int

    @Serializer(eveicon::class)
    companion object : KSerializer<eveicon> {
        fun getItem(id: Int): eveicon
        fun allItems(): List<eveicon>
        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: eveicon)

        override fun deserialize(input: Decoder): eveicon

        fun serializer(): KSerializer<eveicon>
    }
}

