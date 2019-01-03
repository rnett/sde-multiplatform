
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.transactions.transaction

object dgmexpressions : IntIdTable("dgmexpressions", "expressionID") {
    // Database Columns

    val expressionID = integer("expressionID")//.primaryKey()
    val operandID = integer("operandID")
    val arg1 = integer("arg1")
    val arg2 = integer("arg2")
    val expressionValue = varchar("expressionValue", 100)
    val description = varchar("description", 1000)
    val expressionName = varchar("expressionName", 500)
    val expressionTypeID = integer("expressionTypeID")
    val expressionGroupID = integer("expressionGroupID")
    val expressionAttributeID = integer("expressionAttributeID")


    // Foreign/Imported Keys (One to Many)

    val expressionAttribute = reference("expressionAttributeID", dgmattributetypes)
    val expressionGroup = reference("expressionGroupID", invgroups)
    val expressionType = reference("expressionTypeID", invtypes)
}


@Serializable(with = dgmexpression.Companion::class)
actual class dgmexpression(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(dgmexpression::class)
    actual companion object : IntEntityClass<dgmexpression>(dgmexpressions), KSerializer<dgmexpression> {
        actual fun getItem(id: Int) = transaction { super.get(id) }
        actual fun allItems() = transaction { super.all().toList() }
        actual fun getExpressionAttribute(item: dgmexpression): dgmattributetype =
            transaction { item.expressionAttribute }

        actual fun getExpressionGroup(item: dgmexpression): invgroup = transaction { item.expressionGroup }
        actual fun getExpressionType(item: dgmexpression): invtype = transaction { item.expressionType }
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("dgmexpression") {
            init {
                addElement("expressionID")
                addElement("operandID")
                addElement("arg1")
                addElement("arg2")
                addElement("expressionValue")
                addElement("description")
                addElement("expressionName")
                addElement("expressionTypeID")
                addElement("expressionGroupID")
                addElement("expressionAttributeID")
            }
        }

        actual override fun serialize(output: Encoder, obj: dgmexpression) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.expressionID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.operandID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.arg1.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.arg2.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                4,
                HexConverter.printHexBinary(obj.expressionValue.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                5,
                HexConverter.printHexBinary(obj.description.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                6,
                HexConverter.printHexBinary(obj.expressionName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                7,
                HexConverter.printHexBinary(obj.expressionTypeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                8,
                HexConverter.printHexBinary(obj.expressionGroupID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                9,
                HexConverter.printHexBinary(obj.expressionAttributeID.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): dgmexpression {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var id: Int? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> id =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    else -> if (i < descriptor.elementsCount) continue@loop else throw SerializationException("Unknown index $i")
                }
            }

            inp.endStructure(descriptor)
            if (id == null)
                throw SerializationException("Id 'expressionID' @ index 0 not found")
            else
                return dgmexpression[id]
        }

        actual fun serializer(): KSerializer<dgmexpression> = this
    }

    // Database Columns

    actual val expressionID by dgmexpressions.expressionID
    actual val operandID by dgmexpressions.operandID
    actual val arg1 by dgmexpressions.arg1
    actual val arg2 by dgmexpressions.arg2
    actual val expressionValue by dgmexpressions.expressionValue
    actual val description by dgmexpressions.description
    actual val expressionName by dgmexpressions.expressionName
    actual val expressionTypeID by dgmexpressions.expressionTypeID
    actual val expressionGroupID by dgmexpressions.expressionGroupID
    actual val expressionAttributeID by dgmexpressions.expressionAttributeID


    // Foreign/Imported Keys (One to Many)

    actual val expressionAttribute: dgmattributetype by dgmattributetype referencedOn dgmexpressions.expressionAttribute
    actual val expressionGroup: invgroup by invgroup referencedOn dgmexpressions.expressionGroup
    actual val expressionType: invtype by invtype referencedOn dgmexpressions.expressionType


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is dgmexpression)
            return false
        return expressionID == other.expressionID
    }


    actual override fun hashCode() = expressionID


    actual override fun toString() = expressionName
}

