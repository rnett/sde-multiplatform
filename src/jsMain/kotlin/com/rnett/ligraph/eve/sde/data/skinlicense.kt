package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

actual data class skinlicense(
    actual val licenseTypeID: Int,
    actual val duration: Int,
    actual val skinID: Int
) {
    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is skinlicense)
            return false
        return licenseTypeID == other.licenseTypeID
    }


    actual override fun hashCode() = licenseTypeID


    @Serializer(skinlicense::class)
    actual companion object : KSerializer<skinlicense> {
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("skinlicense") {
            init {
                addElement("licenseTypeID")
                addElement("duration")
                addElement("skinID")
            }
        }

        actual override fun serialize(output: Encoder, obj: skinlicense) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.licenseTypeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.duration.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.skinID.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): skinlicense {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var temp_licenseTypeID: Int? = null
            var temp_duration: Int? = null
            var temp_skinID: Int? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> temp_licenseTypeID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    1 -> temp_duration = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    2 -> temp_skinID = stringFromUtf8Bytes(
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

            return skinlicense(
                temp_licenseTypeID ?: throw SerializationException("Missing value for licenseTypeID"),
                temp_duration ?: throw SerializationException("Missing value for duration"),
                temp_skinID ?: throw SerializationException("Missing value for skinID")
            )
        }

        actual fun serializer(): KSerializer<skinlicense> = this
    }
}

