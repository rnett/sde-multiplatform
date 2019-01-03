
package com.rnett.ligraph.eve.sde.data


import com.rnett.kframe.data.callEndpoint
import com.rnett.ligraph.eve.sde.requestClient
import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

@Serializable(with = mapuniverse.Companion::class)
actual data class mapuniverse(
    actual val universeID: Int,
    actual val universeName: String,
    actual val x: Double,
    actual val y: Double,
    actual val z: Double,
    actual val xMin: Double,
    actual val xMax: Double,
    actual val yMin: Double,
    actual val yMax: Double,
    actual val zMin: Double,
    actual val zMax: Double,
    actual val radius: Double
) {


    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is mapuniverse)
            return false
        return universeID == other.universeID
    }


    actual override fun hashCode() = universeID


    actual override fun toString() = universeName

    @Serializer(mapuniverse::class)
    actual companion object : KSerializer<mapuniverse> {
        actual fun getItem(id: Int): mapuniverse = callEndpoint(this::getItem, requestClient, id)
        actual fun allItems(): List<mapuniverse> = callEndpoint(this::allItems, requestClient)


        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("mapuniverse") {
            init {
                addElement("universeID")
                addElement("universeName")
                addElement("x")
                addElement("y")
                addElement("z")
                addElement("xMin")
                addElement("xMax")
                addElement("yMin")
                addElement("yMax")
                addElement("zMin")
                addElement("zMax")
                addElement("radius")
            }
        }

        actual override fun serialize(output: Encoder, obj: mapuniverse) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.universeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.universeName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.x.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.y.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                4,
                HexConverter.printHexBinary(obj.z.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                5,
                HexConverter.printHexBinary(obj.xMin.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                6,
                HexConverter.printHexBinary(obj.xMax.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                7,
                HexConverter.printHexBinary(obj.yMin.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                8,
                HexConverter.printHexBinary(obj.yMax.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                9,
                HexConverter.printHexBinary(obj.zMin.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                10,
                HexConverter.printHexBinary(obj.zMax.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                11,
                HexConverter.printHexBinary(obj.radius.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): mapuniverse {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var temp_universeID: Int? = null
            var temp_universeName: String? = null
            var temp_x: Double? = null
            var temp_y: Double? = null
            var temp_z: Double? = null
            var temp_xMin: Double? = null
            var temp_xMax: Double? = null
            var temp_yMin: Double? = null
            var temp_yMax: Double? = null
            var temp_zMin: Double? = null
            var temp_zMax: Double? = null
            var temp_radius: Double? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> temp_universeID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    1 -> temp_universeName = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    2 -> temp_x = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    3 -> temp_y = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    4 -> temp_z = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    5 -> temp_xMin = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    6 -> temp_xMax = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    7 -> temp_yMin = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    8 -> temp_yMax = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    9 -> temp_zMin = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    10 -> temp_zMax = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    11 -> temp_radius = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    else -> if (i < descriptor.elementsCount) continue@loop else throw SerializationException("Unknown index $i")
                }
            }

            inp.endStructure(descriptor)

            return mapuniverse(
                temp_universeID ?: throw SerializationException("Missing value for universeID"),
                temp_universeName ?: throw SerializationException("Missing value for universeName"),
                temp_x ?: throw SerializationException("Missing value for x"),
                temp_y ?: throw SerializationException("Missing value for y"),
                temp_z ?: throw SerializationException("Missing value for z"),
                temp_xMin ?: throw SerializationException("Missing value for xMin"),
                temp_xMax ?: throw SerializationException("Missing value for xMax"),
                temp_yMin ?: throw SerializationException("Missing value for yMin"),
                temp_yMax ?: throw SerializationException("Missing value for yMax"),
                temp_zMin ?: throw SerializationException("Missing value for zMin"),
                temp_zMax ?: throw SerializationException("Missing value for zMax"),
                temp_radius ?: throw SerializationException("Missing value for radius")
            )
        }

        actual fun serializer(): KSerializer<mapuniverse> = this
    }
}

