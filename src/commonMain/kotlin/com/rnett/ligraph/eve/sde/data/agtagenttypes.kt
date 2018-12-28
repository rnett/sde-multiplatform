package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

expect class agtagenttype {
    val agentTypeID: Int
    val agentType: String

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int

    @Serializer(agtagenttype::class)
    companion object : KSerializer<agtagenttype> {
        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: agtagenttype)

        override fun deserialize(input: Decoder): agtagenttype

        fun serializer(): KSerializer<agtagenttype>
    }
}

