
package com.rnett.ligraph.eve.sde.data


import com.rnett.kframe.data.callEndpoint
import com.rnett.ligraph.eve.sde.requestClient
import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

actual data class trntranslation(
    actual val tcID: Int,
    actual val keyID: Int,
    actual val languageID: String,
    actual val text: String
) {
    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is trntranslation)
            return false
        return tcID == other.tcID
    }


    actual override fun hashCode() = tcID


    @Serializer(trntranslation::class)
    actual companion object : KSerializer<trntranslation> {
        actual fun getItem(id: Int): trntranslation = callEndpoint(this::getItem, requestClient, id)
        actual fun allItems(): List<trntranslation> = callEndpoint(this::allItems, requestClient)
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("trntranslation") {
            init {
                addElement("tcID")
                addElement("keyID")
                addElement("languageID")
                addElement("text")
            }
        }

        actual override fun serialize(output: Encoder, obj: trntranslation) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.tcID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.keyID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.languageID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.text.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): trntranslation {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var temp_tcID: Int? = null
            var temp_keyID: Int? = null
            var temp_languageID: String? = null
            var temp_text: String? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> temp_tcID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    1 -> temp_keyID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    2 -> temp_languageID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    3 -> temp_text = stringFromUtf8Bytes(
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

            return trntranslation(
                temp_tcID ?: throw SerializationException("Missing value for tcID"),
                temp_keyID ?: throw SerializationException("Missing value for keyID"),
                temp_languageID ?: throw SerializationException("Missing value for languageID"),
                temp_text ?: throw SerializationException("Missing value for text")
            )
        }

        actual fun serializer(): KSerializer<trntranslation> = this
    }
}

