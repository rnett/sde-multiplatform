package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

expect class invtrait {
    val traitID: Int
    val typeID: Int
    val skillID: Int
    val bonus: Double
    val bonusText: String
    val unitID: Int

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int

    @Serializer(invtrait::class)
    companion object : KSerializer<invtrait> {
        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: invtrait)

        override fun deserialize(input: Decoder): invtrait

        fun serializer(): KSerializer<invtrait>
    }
}

