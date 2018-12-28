package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

expect class certcert {
    val certID: Int
    val description: String
    val groupID: Int
    val name: String

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
    override fun toString(): String

    @Serializer(certcert::class)
    companion object : KSerializer<certcert> {
        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: certcert)

        override fun deserialize(input: Decoder): certcert

        fun serializer(): KSerializer<certcert>
    }
}

