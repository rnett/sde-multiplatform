
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

@Serializable(with = evegraphic.Companion::class)
expect class evegraphic {
    val graphicID: Int
    val sofFactionName: String
    val graphicFile: String
    val sofHullName: String
    val sofRaceName: String
    val description: String

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int

    @Serializer(evegraphic::class)
    companion object : KSerializer<evegraphic> {
        fun getItem(id: Int): evegraphic
        fun allItems(): List<evegraphic>


        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: evegraphic)

        override fun deserialize(input: Decoder): evegraphic

        fun serializer(): KSerializer<evegraphic>
    }
}
operator fun evegraphic.Companion.get(id: Int) = getItem(id)
operator fun evegraphic.Companion.invoke() = allItems()


