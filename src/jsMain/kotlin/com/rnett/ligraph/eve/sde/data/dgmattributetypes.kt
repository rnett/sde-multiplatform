
package com.rnett.ligraph.eve.sde.data


import com.rnett.kframe.data.callEndpoint
import com.rnett.ligraph.eve.sde.requestClient
import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

actual data class dgmattributetype(
    actual val attributeID: Int,
    actual val attributeName: String,
    actual val description: String,
    actual val iconID: Int,
    actual val defaultValue: Double,
    actual val published: Boolean,
    actual val displayName: String,
    actual val unitID: Int,
    actual val stackable: Boolean,
    actual val highIsGood: Boolean,
    actual val categoryID: Int
) {
    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is dgmattributetype)
            return false
        return attributeID == other.attributeID
    }


    actual override fun hashCode() = attributeID


    @Serializer(dgmattributetype::class)
    actual companion object : KSerializer<dgmattributetype> {
        actual fun getItem(id: Int): dgmattributetype = callEndpoint(this::getItem, requestClient, id)
        actual fun allItems(): List<dgmattributetype> = callEndpoint(this::allItems, requestClient)
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("dgmattributetype") {
            init {
                addElement("attributeID")
                addElement("attributeName")
                addElement("description")
                addElement("iconID")
                addElement("defaultValue")
                addElement("published")
                addElement("displayName")
                addElement("unitID")
                addElement("stackable")
                addElement("highIsGood")
                addElement("categoryID")
            }
        }

        actual override fun serialize(output: Encoder, obj: dgmattributetype) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.attributeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.attributeName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.description.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.iconID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                4,
                HexConverter.printHexBinary(obj.defaultValue.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                5,
                HexConverter.printHexBinary(obj.published.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                6,
                HexConverter.printHexBinary(obj.displayName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                7,
                HexConverter.printHexBinary(obj.unitID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                8,
                HexConverter.printHexBinary(obj.stackable.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                9,
                HexConverter.printHexBinary(obj.highIsGood.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                10,
                HexConverter.printHexBinary(obj.categoryID.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): dgmattributetype {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var temp_attributeID: Int? = null
            var temp_attributeName: String? = null
            var temp_description: String? = null
            var temp_iconID: Int? = null
            var temp_defaultValue: Double? = null
            var temp_published: Boolean? = null
            var temp_displayName: String? = null
            var temp_unitID: Int? = null
            var temp_stackable: Boolean? = null
            var temp_highIsGood: Boolean? = null
            var temp_categoryID: Int? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> temp_attributeID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    1 -> temp_attributeName = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    2 -> temp_description = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    3 -> temp_iconID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    4 -> temp_defaultValue = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    5 -> temp_published = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toBoolean()
                    6 -> temp_displayName = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    7 -> temp_unitID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    8 -> temp_stackable = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toBoolean()
                    9 -> temp_highIsGood = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toBoolean()
                    10 -> temp_categoryID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    else -> if (i < descriptor.elementsCount) continue@loop else throw SerializationException("Unknown index $i")
                }
            }

            inp.endStructure(descriptor)

            return dgmattributetype(
                temp_attributeID ?: throw SerializationException("Missing value for attributeID"),
                temp_attributeName ?: throw SerializationException("Missing value for attributeName"),
                temp_description ?: throw SerializationException("Missing value for description"),
                temp_iconID ?: throw SerializationException("Missing value for iconID"),
                temp_defaultValue ?: throw SerializationException("Missing value for defaultValue"),
                temp_published ?: throw SerializationException("Missing value for published"),
                temp_displayName ?: throw SerializationException("Missing value for displayName"),
                temp_unitID ?: throw SerializationException("Missing value for unitID"),
                temp_stackable ?: throw SerializationException("Missing value for stackable"),
                temp_highIsGood ?: throw SerializationException("Missing value for highIsGood"),
                temp_categoryID ?: throw SerializationException("Missing value for categoryID")
            )
        }

        actual fun serializer(): KSerializer<dgmattributetype> = this
    }
}

