
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

expect class maplocationscene {
    val locationID: Int
    val graphicID: Int

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int

    @Serializer(maplocationscene::class)
    companion object : KSerializer<maplocationscene> {
        fun getItem(id: Int): maplocationscene
        fun allItems(): List<maplocationscene>
        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: maplocationscene)

        override fun deserialize(input: Decoder): maplocationscene

        fun serializer(): KSerializer<maplocationscene>
    }
}

