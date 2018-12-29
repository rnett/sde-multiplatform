
package com.rnett.ligraph.eve.sde.data


import com.rnett.kframe.data.callEndpoint
import com.rnett.ligraph.eve.sde.requestClient
import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

actual data class chrattribute(
    actual val attributeID: Int,
    actual val attributeName: String,
    actual val description: String,
    actual val iconID: Int,
    actual val shortDescription: String,
    actual val notes: String
) {
    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is chrattribute)
            return false
        return attributeID == other.attributeID
    }


    actual override fun hashCode() = attributeID


    actual override fun toString() = attributeName

    @Serializer(chrattribute::class)
    actual companion object : KSerializer<chrattribute> {
        actual fun getItem(id: Int): chrattribute = callEndpoint(this::getItem, requestClient, id)
        actual fun allItems(): List<chrattribute> = callEndpoint(this::allItems, requestClient)
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("chrattribute") {
            init {
                addElement("attributeID")
                addElement("attributeName")
                addElement("description")
                addElement("iconID")
                addElement("shortDescription")
                addElement("notes")
            }
        }

        actual override fun serialize(output: Encoder, obj: chrattribute) {
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
                HexConverter.printHexBinary(obj.shortDescription.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                5,
                HexConverter.printHexBinary(obj.notes.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): chrattribute {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var temp_attributeID: Int? = null
            var temp_attributeName: String? = null
            var temp_description: String? = null
            var temp_iconID: Int? = null
            var temp_shortDescription: String? = null
            var temp_notes: String? = null
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
                    4 -> temp_shortDescription = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    5 -> temp_notes = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    else -> if (i < descriptor.elementsCount) continue@loop else throw SerializationException("Unknown index $i")
                }
            }

            inp.endStructure(descriptor)

            return chrattribute(
                temp_attributeID ?: throw SerializationException("Missing value for attributeID"),
                temp_attributeName ?: throw SerializationException("Missing value for attributeName"),
                temp_description ?: throw SerializationException("Missing value for description"),
                temp_iconID ?: throw SerializationException("Missing value for iconID"),
                temp_shortDescription ?: throw SerializationException("Missing value for shortDescription"),
                temp_notes ?: throw SerializationException("Missing value for notes")
            )
        }

        actual fun serializer(): KSerializer<chrattribute> = this
    }
}

