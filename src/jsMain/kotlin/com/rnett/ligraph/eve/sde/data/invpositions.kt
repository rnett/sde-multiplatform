package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

actual data class invposition(
    actual val itemID: Int,
    actual val x: Double,
    actual val y: Double,
    actual val z: Double,
    actual val yaw: Float,
    actual val pitch: Float,
    actual val roll: Float
) {
    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is invposition)
            return false
        return itemID == other.itemID
    }


    actual override fun hashCode() = itemID


    @Serializer(invposition::class)
    actual companion object : KSerializer<invposition> {
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("invposition") {
            init {
                addElement("itemID")
                addElement("x")
                addElement("y")
                addElement("z")
                addElement("yaw")
                addElement("pitch")
                addElement("roll")
            }
        }

        actual override fun serialize(output: Encoder, obj: invposition) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.itemID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.x.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.y.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.z.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                4,
                HexConverter.printHexBinary(obj.yaw.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                5,
                HexConverter.printHexBinary(obj.pitch.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                6,
                HexConverter.printHexBinary(obj.roll.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): invposition {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var temp_itemID: Int? = null
            var temp_x: Double? = null
            var temp_y: Double? = null
            var temp_z: Double? = null
            var temp_yaw: Float? = null
            var temp_pitch: Float? = null
            var temp_roll: Float? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> temp_itemID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    1 -> temp_x = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    2 -> temp_y = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    3 -> temp_z = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    4 -> temp_yaw = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toFloat()
                    5 -> temp_pitch = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toFloat()
                    6 -> temp_roll = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toFloat()
                    else -> if (i < descriptor.elementsCount) continue@loop else throw SerializationException("Unknown index $i")
                }
            }

            inp.endStructure(descriptor)

            return invposition(
                temp_itemID ?: throw SerializationException("Missing value for itemID"),
                temp_x ?: throw SerializationException("Missing value for x"),
                temp_y ?: throw SerializationException("Missing value for y"),
                temp_z ?: throw SerializationException("Missing value for z"),
                temp_yaw ?: throw SerializationException("Missing value for yaw"),
                temp_pitch ?: throw SerializationException("Missing value for pitch"),
                temp_roll ?: throw SerializationException("Missing value for roll")
            )
        }

        actual fun serializer(): KSerializer<invposition> = this
    }
}

