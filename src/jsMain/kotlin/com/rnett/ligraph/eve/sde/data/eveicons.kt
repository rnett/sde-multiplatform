
package com.rnett.ligraph.eve.sde.data


import com.rnett.kframe.data.callEndpoint
import com.rnett.ligraph.eve.sde.requestClient
import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

actual data class eveicon(
    actual val iconID: Int,
    actual val iconFile: String,
    actual val description: String
) {
    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is eveicon)
            return false
        return iconID == other.iconID
    }


    actual override fun hashCode() = iconID


    @Serializer(eveicon::class)
    actual companion object : KSerializer<eveicon> {
        actual fun getItem(id: Int): eveicon = callEndpoint(this::getItem, requestClient, id)
        actual fun allItems(): List<eveicon> = callEndpoint(this::allItems, requestClient)
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("eveicon") {
            init {
                addElement("iconID")
                addElement("iconFile")
                addElement("description")
            }
        }

        actual override fun serialize(output: Encoder, obj: eveicon) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.iconID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.iconFile.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.description.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): eveicon {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var temp_iconID: Int? = null
            var temp_iconFile: String? = null
            var temp_description: String? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> temp_iconID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    1 -> temp_iconFile = stringFromUtf8Bytes(
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
                    else -> if (i < descriptor.elementsCount) continue@loop else throw SerializationException("Unknown index $i")
                }
            }

            inp.endStructure(descriptor)

            return eveicon(
                temp_iconID ?: throw SerializationException("Missing value for iconID"),
                temp_iconFile ?: throw SerializationException("Missing value for iconFile"),
                temp_description ?: throw SerializationException("Missing value for description")
            )
        }

        actual fun serializer(): KSerializer<eveicon> = this
    }
}

