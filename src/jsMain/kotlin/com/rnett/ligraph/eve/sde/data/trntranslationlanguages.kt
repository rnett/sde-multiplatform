
package com.rnett.ligraph.eve.sde.data


import com.rnett.kframe.data.callEndpoint
import com.rnett.ligraph.eve.sde.requestClient
import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

@Serializable(with = trntranslationlanguage.Companion::class)
actual data class trntranslationlanguage(
    actual val numericLanguageID: Int,
    actual val languageID: String,
    actual val languageName: String
) {


    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is trntranslationlanguage)
            return false
        return numericLanguageID == other.numericLanguageID
    }


    actual override fun hashCode() = numericLanguageID


    actual override fun toString() = languageName

    @Serializer(trntranslationlanguage::class)
    actual companion object : KSerializer<trntranslationlanguage> {
        actual fun getItem(id: Int): trntranslationlanguage = callEndpoint(this::getItem, requestClient, id)
        actual fun allItems(): List<trntranslationlanguage> = callEndpoint(this::allItems, requestClient)


        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("trntranslationlanguage") {
            init {
                addElement("numericLanguageID")
                addElement("languageID")
                addElement("languageName")
            }
        }

        actual override fun serialize(output: Encoder, obj: trntranslationlanguage) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.numericLanguageID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.languageID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.languageName.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): trntranslationlanguage {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var temp_numericLanguageID: Int? = null
            var temp_languageID: String? = null
            var temp_languageName: String? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> temp_numericLanguageID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    1 -> temp_languageID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    2 -> temp_languageName = stringFromUtf8Bytes(
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

            return trntranslationlanguage(
                temp_numericLanguageID ?: throw SerializationException("Missing value for numericLanguageID"),
                temp_languageID ?: throw SerializationException("Missing value for languageID"),
                temp_languageName ?: throw SerializationException("Missing value for languageName")
            )
        }

        actual fun serializer(): KSerializer<trntranslationlanguage> = this
    }
}

