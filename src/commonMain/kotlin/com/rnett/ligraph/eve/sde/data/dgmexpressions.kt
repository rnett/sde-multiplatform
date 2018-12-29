
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

@Serializable(with = dgmexpression.Companion::class)
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

    val expressionAttribute: dgmattributetype
    val expressionGroup: invgroup
    val expressionType: invtype
    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
    override fun toString(): String

    @Serializer(dgmexpression::class)
    companion object : KSerializer<dgmexpression> {
        fun getItem(id: Int): dgmexpression
        fun allItems(): List<dgmexpression>

        fun getExpressionAttribute(item: dgmexpression): dgmattributetype
        fun getExpressionGroup(item: dgmexpression): invgroup
        fun getExpressionType(item: dgmexpression): invtype


        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: dgmexpression)

        override fun deserialize(input: Decoder): dgmexpression

        fun serializer(): KSerializer<dgmexpression>
    }
}

operator fun dgmexpression.Companion.get(id: Int) = getItem(id)
operator fun dgmexpression.Companion.invoke() = allItems()


