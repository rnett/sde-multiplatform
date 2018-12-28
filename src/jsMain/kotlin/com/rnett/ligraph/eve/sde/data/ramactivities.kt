package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

actual data class ramactivity(
    actual val activityID: Int,
    actual val activityName: String,
    actual val iconNo: String,
    actual val description: String,
    actual val published: Boolean
) {
    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is ramactivity)
            return false
        return activityID == other.activityID
    }


    actual override fun hashCode() = activityID


    actual override fun toString() = activityName

    @Serializer(ramactivity::class)
    actual companion object : KSerializer<ramactivity> {
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("ramactivity") {
            init {
                addElement("activityID")
                addElement("activityName")
                addElement("iconNo")
                addElement("description")
                addElement("published")
            }
        }

        actual override fun serialize(output: Encoder, obj: ramactivity) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.activityID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.activityName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.iconNo.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.description.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                4,
                HexConverter.printHexBinary(obj.published.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): ramactivity {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var temp_activityID: Int? = null
            var temp_activityName: String? = null
            var temp_iconNo: String? = null
            var temp_description: String? = null
            var temp_published: Boolean? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> temp_activityID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    1 -> temp_activityName = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    2 -> temp_iconNo = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    3 -> temp_description = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    4 -> temp_published = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toBoolean()
                    else -> if (i < descriptor.elementsCount) continue@loop else throw SerializationException("Unknown index $i")
                }
            }

            inp.endStructure(descriptor)

            return ramactivity(
                temp_activityID ?: throw SerializationException("Missing value for activityID"),
                temp_activityName ?: throw SerializationException("Missing value for activityName"),
                temp_iconNo ?: throw SerializationException("Missing value for iconNo"),
                temp_description ?: throw SerializationException("Missing value for description"),
                temp_published ?: throw SerializationException("Missing value for published")
            )
        }

        actual fun serializer(): KSerializer<ramactivity> = this
    }
}

