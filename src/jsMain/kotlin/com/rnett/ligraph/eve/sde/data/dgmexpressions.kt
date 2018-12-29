
package com.rnett.ligraph.eve.sde.data


import com.rnett.kframe.data.callEndpoint
import com.rnett.ligraph.eve.sde.requestClient
import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

@Serializable(with = dgmexpression.Companion::class)
actual data class dgmexpression(
    actual val expressionID: Int,
    actual val operandID: Int,
    actual val arg1: Int,
    actual val arg2: Int,
    actual val expressionValue: String,
    actual val description: String,
    actual val expressionName: String,
    actual val expressionTypeID: Int,
    actual val expressionGroupID: Int,
    actual val expressionAttributeID: Int
) {
    actual val expressionAttribute: dgmattributetype get() = getExpressionAttribute(this)
    actual val expressionGroup: invgroup get() = getExpressionGroup(this)
    actual val expressionType: invtype get() = getExpressionType(this)


    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is dgmexpression)
            return false
        return expressionID == other.expressionID
    }


    actual override fun hashCode() = expressionID


    actual override fun toString() = expressionName

    @Serializer(dgmexpression::class)
    actual companion object : KSerializer<dgmexpression> {
        actual fun getItem(id: Int): dgmexpression = callEndpoint(this::getItem, requestClient, id)
        actual fun allItems(): List<dgmexpression> = callEndpoint(this::allItems, requestClient)

        actual fun getExpressionAttribute(item: dgmexpression): dgmattributetype =
            callEndpoint(this::getExpressionAttribute, requestClient, item)

        actual fun getExpressionGroup(item: dgmexpression): invgroup =
            callEndpoint(this::getExpressionGroup, requestClient, item)

        actual fun getExpressionType(item: dgmexpression): invtype =
            callEndpoint(this::getExpressionType, requestClient, item)


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
            var temp_expressionID: Int? = null
            var temp_operandID: Int? = null
            var temp_arg1: Int? = null
            var temp_arg2: Int? = null
            var temp_expressionValue: String? = null
            var temp_description: String? = null
            var temp_expressionName: String? = null
            var temp_expressionTypeID: Int? = null
            var temp_expressionGroupID: Int? = null
            var temp_expressionAttributeID: Int? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> temp_expressionID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    1 -> temp_operandID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    2 -> temp_arg1 = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    3 -> temp_arg2 = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    4 -> temp_expressionValue = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    5 -> temp_description = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    6 -> temp_expressionName = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    7 -> temp_expressionTypeID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    8 -> temp_expressionGroupID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    9 -> temp_expressionAttributeID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    else -> if (i < descriptor.elementsCount) continue@loop else throw SerializationException("Unknown index $i")
                }
            }

            inp.endStructure(descriptor)

            return dgmexpression(
                temp_expressionID ?: throw SerializationException("Missing value for expressionID"),
                temp_operandID ?: throw SerializationException("Missing value for operandID"),
                temp_arg1 ?: throw SerializationException("Missing value for arg1"),
                temp_arg2 ?: throw SerializationException("Missing value for arg2"),
                temp_expressionValue ?: throw SerializationException("Missing value for expressionValue"),
                temp_description ?: throw SerializationException("Missing value for description"),
                temp_expressionName ?: throw SerializationException("Missing value for expressionName"),
                temp_expressionTypeID ?: throw SerializationException("Missing value for expressionTypeID"),
                temp_expressionGroupID ?: throw SerializationException("Missing value for expressionGroupID"),
                temp_expressionAttributeID ?: throw SerializationException("Missing value for expressionAttributeID")
            )
        }

        actual fun serializer(): KSerializer<dgmexpression> = this
    }
}

