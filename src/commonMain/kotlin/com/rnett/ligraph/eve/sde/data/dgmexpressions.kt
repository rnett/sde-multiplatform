package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

expect class dgmexpression {
    val expressionID: Int
    val operandID: Int
    val arg1: Int
    val arg2: Int
    val expressionValue: String
    val description: String
    val expressionName: String
    val expressionTypeID: Int
    val expressionGroupID: Int
    val expressionAttributeID: Int

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
    override fun toString(): String

    @Serializer(dgmexpression::class)
    companion object : KSerializer<dgmexpression> {
        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: dgmexpression)

        override fun deserialize(input: Decoder): dgmexpression

        fun serializer(): KSerializer<dgmexpression>
    }
}

