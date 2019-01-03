
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

@Serializable(with = agtagenttype.Companion::class)
expect class agtagenttype {
    val agentTypeID: Int
    val agentType: String

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int

    @Serializer(agtagenttype::class)
    companion object : KSerializer<agtagenttype> {
        fun getItem(id: Int): agtagenttype
        fun allItems(): List<agtagenttype>


        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: agtagenttype)

        override fun deserialize(input: Decoder): agtagenttype

        fun serializer(): KSerializer<agtagenttype>
    }
}
operator fun agtagenttype.Companion.get(id: Int) = getItem(id)
operator fun agtagenttype.Companion.invoke() = allItems()


