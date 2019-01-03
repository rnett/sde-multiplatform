
package com.rnett.ligraph.eve.sde.data


import com.rnett.kframe.data.callEndpoint
import com.rnett.ligraph.eve.sde.requestClient
import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

@Serializable(with = maplandmark.Companion::class)
actual data class maplandmark(
    actual val landmarkID: Int,
    actual val landmarkName: String,
    actual val description: String,
    actual val locationID: Int,
    actual val x: Double,
    actual val y: Double,
    actual val z: Double,
    actual val iconID: Int
) {


    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is maplandmark)
            return false
        return landmarkID == other.landmarkID
    }


    actual override fun hashCode() = landmarkID


    actual override fun toString() = landmarkName

    @Serializer(maplandmark::class)
    actual companion object : KSerializer<maplandmark> {
        actual fun getItem(id: Int): maplandmark = callEndpoint(this::getItem, requestClient, id)
        actual fun allItems(): List<maplandmark> = callEndpoint(this::allItems, requestClient)


        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("maplandmark") {
            init {
                addElement("landmarkID")
                addElement("landmarkName")
                addElement("description")
                addElement("locationID")
                addElement("x")
                addElement("y")
                addElement("z")
                addElement("iconID")
            }
        }

        actual override fun serialize(output: Encoder, obj: maplandmark) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.landmarkID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.landmarkName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.description.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.locationID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                4,
                HexConverter.printHexBinary(obj.x.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                5,
                HexConverter.printHexBinary(obj.y.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                6,
                HexConverter.printHexBinary(obj.z.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                7,
                HexConverter.printHexBinary(obj.iconID.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): maplandmark {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var temp_landmarkID: Int? = null
            var temp_landmarkName: String? = null
            var temp_description: String? = null
            var temp_locationID: Int? = null
            var temp_x: Double? = null
            var temp_y: Double? = null
            var temp_z: Double? = null
            var temp_iconID: Int? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> temp_landmarkID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    1 -> temp_landmarkName = stringFromUtf8Bytes(
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
                    3 -> temp_locationID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    4 -> temp_x = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    5 -> temp_y = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    6 -> temp_z = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    7 -> temp_iconID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    else -> if (i < descriptor.elementsCount) continue@loop else throw SerializationException("Unknown index $i")
                }
            }

            inp.endStructure(descriptor)

            return maplandmark(
                temp_landmarkID ?: throw SerializationException("Missing value for landmarkID"),
                temp_landmarkName ?: throw SerializationException("Missing value for landmarkName"),
                temp_description ?: throw SerializationException("Missing value for description"),
                temp_locationID ?: throw SerializationException("Missing value for locationID"),
                temp_x ?: throw SerializationException("Missing value for x"),
                temp_y ?: throw SerializationException("Missing value for y"),
                temp_z ?: throw SerializationException("Missing value for z"),
                temp_iconID ?: throw SerializationException("Missing value for iconID")
            )
        }

        actual fun serializer(): KSerializer<maplandmark> = this
    }
}

