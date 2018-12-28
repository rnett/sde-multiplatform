package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

actual data class invflag(
    actual val flagID: Int,
    actual val flagName: String,
    actual val flagText: String,
    actual val orderID: Int
) {
    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is invflag)
            return false
        return flagID == other.flagID
    }


    actual override fun hashCode() = flagID


    actual override fun toString() = flagName

    @Serializer(invflag::class)
    actual companion object : KSerializer<invflag> {
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("invflag") {
            init {
                addElement("flagID")
                addElement("flagName")
                addElement("flagText")
                addElement("orderID")
            }
        }

        actual override fun serialize(output: Encoder, obj: invflag) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.flagID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.flagName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.flagText.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.orderID.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): invflag {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var temp_flagID: Int? = null
            var temp_flagName: String? = null
            var temp_flagText: String? = null
            var temp_orderID: Int? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> temp_flagID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    1 -> temp_flagName = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    2 -> temp_flagText = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    3 -> temp_orderID = stringFromUtf8Bytes(
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

            return invflag(
                temp_flagID ?: throw SerializationException("Missing value for flagID"),
                temp_flagName ?: throw SerializationException("Missing value for flagName"),
                temp_flagText ?: throw SerializationException("Missing value for flagText"),
                temp_orderID ?: throw SerializationException("Missing value for orderID")
            )
        }

        actual fun serializer(): KSerializer<invflag> = this
    }
}

