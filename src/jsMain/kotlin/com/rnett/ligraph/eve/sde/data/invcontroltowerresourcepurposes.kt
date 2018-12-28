package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

actual data class invcontroltowerresourcepurpose(
    actual val purpose: Int,
    actual val purposeText: String
) {
    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is invcontroltowerresourcepurpose)
            return false
        return purpose == other.purpose
    }


    actual override fun hashCode() = purpose


    @Serializer(invcontroltowerresourcepurpose::class)
    actual companion object : KSerializer<invcontroltowerresourcepurpose> {
        actual override val descriptor: SerialDescriptor =
            object : SerialClassDescImpl("invcontroltowerresourcepurpose") {
                init {
                    addElement("purpose")
                    addElement("purposeText")
                }
            }

        actual override fun serialize(output: Encoder, obj: invcontroltowerresourcepurpose) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.purpose.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.purposeText.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): invcontroltowerresourcepurpose {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var temp_purpose: Int? = null
            var temp_purposeText: String? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> temp_purpose = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    1 -> temp_purposeText = stringFromUtf8Bytes(
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

            return invcontroltowerresourcepurpose(
                temp_purpose ?: throw SerializationException("Missing value for purpose"),
                temp_purposeText ?: throw SerializationException("Missing value for purposeText")
            )
        }

        actual fun serializer(): KSerializer<invcontroltowerresourcepurpose> = this
    }
}

