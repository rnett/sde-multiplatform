
package com.rnett.ligraph.eve.sde.data


import com.rnett.kframe.data.callEndpoint
import com.rnett.ligraph.eve.sde.requestClient
import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

@Serializable(with = mapdenormalize.Companion::class)
actual data class mapdenormalize(
    actual val itemID: Int,
    actual val typeID: Int,
    actual val groupID: Int,
    actual val solarSystemID: Int,
    actual val constellationID: Int,
    actual val regionID: Int,
    actual val orbitID: Int,
    actual val x: Double,
    actual val y: Double,
    actual val z: Double,
    actual val radius: Double,
    actual val itemName: String,
    actual val security: Double,
    actual val celestialIndex: Int,
    actual val orbitIndex: Int
) {


    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is mapdenormalize)
            return false
        return itemID == other.itemID
    }


    actual override fun hashCode() = itemID


    actual override fun toString() = itemName

    @Serializer(mapdenormalize::class)
    actual companion object : KSerializer<mapdenormalize> {
        actual fun getItem(id: Int): mapdenormalize = callEndpoint(this::getItem, requestClient, id)
        actual fun allItems(): List<mapdenormalize> = callEndpoint(this::allItems, requestClient)


        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("mapdenormalize") {
            init {
                addElement("itemID")
                addElement("typeID")
                addElement("groupID")
                addElement("solarSystemID")
                addElement("constellationID")
                addElement("regionID")
                addElement("orbitID")
                addElement("x")
                addElement("y")
                addElement("z")
                addElement("radius")
                addElement("itemName")
                addElement("security")
                addElement("celestialIndex")
                addElement("orbitIndex")
            }
        }

        actual override fun serialize(output: Encoder, obj: mapdenormalize) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.itemID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.typeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.groupID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.solarSystemID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                4,
                HexConverter.printHexBinary(obj.constellationID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                5,
                HexConverter.printHexBinary(obj.regionID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                6,
                HexConverter.printHexBinary(obj.orbitID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                7,
                HexConverter.printHexBinary(obj.x.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                8,
                HexConverter.printHexBinary(obj.y.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                9,
                HexConverter.printHexBinary(obj.z.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                10,
                HexConverter.printHexBinary(obj.radius.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                11,
                HexConverter.printHexBinary(obj.itemName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                12,
                HexConverter.printHexBinary(obj.security.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                13,
                HexConverter.printHexBinary(obj.celestialIndex.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                14,
                HexConverter.printHexBinary(obj.orbitIndex.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): mapdenormalize {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var temp_itemID: Int? = null
            var temp_typeID: Int? = null
            var temp_groupID: Int? = null
            var temp_solarSystemID: Int? = null
            var temp_constellationID: Int? = null
            var temp_regionID: Int? = null
            var temp_orbitID: Int? = null
            var temp_x: Double? = null
            var temp_y: Double? = null
            var temp_z: Double? = null
            var temp_radius: Double? = null
            var temp_itemName: String? = null
            var temp_security: Double? = null
            var temp_celestialIndex: Int? = null
            var temp_orbitIndex: Int? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> temp_itemID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    1 -> temp_typeID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    2 -> temp_groupID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    3 -> temp_solarSystemID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    4 -> temp_constellationID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    5 -> temp_regionID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    6 -> temp_orbitID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    7 -> temp_x = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    8 -> temp_y = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    9 -> temp_z = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    10 -> temp_radius = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    11 -> temp_itemName = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    12 -> temp_security = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    13 -> temp_celestialIndex =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    14 -> temp_orbitIndex =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    else -> if (i < descriptor.elementsCount) continue@loop else throw SerializationException("Unknown index $i")
                }
            }

            inp.endStructure(descriptor)

            return mapdenormalize(
                temp_itemID ?: throw SerializationException("Missing value for itemID"),
                temp_typeID ?: throw SerializationException("Missing value for typeID"),
                temp_groupID ?: throw SerializationException("Missing value for groupID"),
                temp_solarSystemID ?: throw SerializationException("Missing value for solarSystemID"),
                temp_constellationID ?: throw SerializationException("Missing value for constellationID"),
                temp_regionID ?: throw SerializationException("Missing value for regionID"),
                temp_orbitID ?: throw SerializationException("Missing value for orbitID"),
                temp_x ?: throw SerializationException("Missing value for x"),
                temp_y ?: throw SerializationException("Missing value for y"),
                temp_z ?: throw SerializationException("Missing value for z"),
                temp_radius ?: throw SerializationException("Missing value for radius"),
                temp_itemName ?: throw SerializationException("Missing value for itemName"),
                temp_security ?: throw SerializationException("Missing value for security"),
                temp_celestialIndex ?: throw SerializationException("Missing value for celestialIndex"),
                temp_orbitIndex ?: throw SerializationException("Missing value for orbitIndex")
            )
        }

        actual fun serializer(): KSerializer<mapdenormalize> = this
    }
}

