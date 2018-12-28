package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

expect class invcontroltowerresourcepurpose {
    val purpose: Int
    val purposeText: String

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int

    @Serializer(invcontroltowerresourcepurpose::class)
    companion object : KSerializer<invcontroltowerresourcepurpose> {
        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: invcontroltowerresourcepurpose)

        override fun deserialize(input: Decoder): invcontroltowerresourcepurpose

        fun serializer(): KSerializer<invcontroltowerresourcepurpose>
    }
}

