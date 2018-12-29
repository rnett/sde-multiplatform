
package com.rnett.ligraph.eve.sde.data


import com.rnett.kframe.data.callEndpoint
import com.rnett.ligraph.eve.sde.requestClient
import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

actual data class stastation(
    actual val stationID: Long,
    actual val security: Double,
    actual val dockingCostPerVolume: Double,
    actual val maxShipVolumeDockable: Double,
    actual val officeRentalCost: Int,
    actual val operationID: Int,
    actual val stationTypeID: Int,
    actual val corporationID: Int,
    actual val solarSystemID: Int,
    actual val constellationID: Int,
    actual val regionID: Int,
    actual val stationName: String,
    actual val x: Double,
    actual val y: Double,
    actual val z: Double,
    actual val reprocessingEfficiency: Double,
    actual val reprocessingStationsTake: Double,
    actual val reprocessingHangarFlag: Int
) {
    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is stastation)
            return false
        return stationID == other.stationID
    }


    actual override fun hashCode() = stationID.hashCode()


    actual override fun toString() = stationName

    @Serializer(stastation::class)
    actual companion object : KSerializer<stastation> {
        actual fun getItem(id: Long): stastation = callEndpoint(this::getItem, requestClient, id)
        actual fun allItems(): List<stastation> = callEndpoint(this::allItems, requestClient)
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("stastation") {
            init {
                addElement("stationID")
                addElement("security")
                addElement("dockingCostPerVolume")
                addElement("maxShipVolumeDockable")
                addElement("officeRentalCost")
                addElement("operationID")
                addElement("stationTypeID")
                addElement("corporationID")
                addElement("solarSystemID")
                addElement("constellationID")
                addElement("regionID")
                addElement("stationName")
                addElement("x")
                addElement("y")
                addElement("z")
                addElement("reprocessingEfficiency")
                addElement("reprocessingStationsTake")
                addElement("reprocessingHangarFlag")
            }
        }

        actual override fun serialize(output: Encoder, obj: stastation) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.stationID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.security.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.dockingCostPerVolume.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.maxShipVolumeDockable.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                4,
                HexConverter.printHexBinary(obj.officeRentalCost.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                5,
                HexConverter.printHexBinary(obj.operationID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                6,
                HexConverter.printHexBinary(obj.stationTypeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                7,
                HexConverter.printHexBinary(obj.corporationID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                8,
                HexConverter.printHexBinary(obj.solarSystemID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                9,
                HexConverter.printHexBinary(obj.constellationID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                10,
                HexConverter.printHexBinary(obj.regionID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                11,
                HexConverter.printHexBinary(obj.stationName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                12,
                HexConverter.printHexBinary(obj.x.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                13,
                HexConverter.printHexBinary(obj.y.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                14,
                HexConverter.printHexBinary(obj.z.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                15,
                HexConverter.printHexBinary(obj.reprocessingEfficiency.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                16,
                HexConverter.printHexBinary(obj.reprocessingStationsTake.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                17,
                HexConverter.printHexBinary(obj.reprocessingHangarFlag.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): stastation {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var temp_stationID: Long? = null
            var temp_security: Double? = null
            var temp_dockingCostPerVolume: Double? = null
            var temp_maxShipVolumeDockable: Double? = null
            var temp_officeRentalCost: Int? = null
            var temp_operationID: Int? = null
            var temp_stationTypeID: Int? = null
            var temp_corporationID: Int? = null
            var temp_solarSystemID: Int? = null
            var temp_constellationID: Int? = null
            var temp_regionID: Int? = null
            var temp_stationName: String? = null
            var temp_x: Double? = null
            var temp_y: Double? = null
            var temp_z: Double? = null
            var temp_reprocessingEfficiency: Double? = null
            var temp_reprocessingStationsTake: Double? = null
            var temp_reprocessingHangarFlag: Int? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> temp_stationID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toLong()
                    1 -> temp_security = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    2 -> temp_dockingCostPerVolume = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    3 -> temp_maxShipVolumeDockable = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    4 -> temp_officeRentalCost =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    5 -> temp_operationID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    6 -> temp_stationTypeID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    7 -> temp_corporationID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    8 -> temp_solarSystemID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    9 -> temp_constellationID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    10 -> temp_regionID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    11 -> temp_stationName = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    12 -> temp_x = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    13 -> temp_y = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    14 -> temp_z = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    15 -> temp_reprocessingEfficiency = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    16 -> temp_reprocessingStationsTake = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    17 -> temp_reprocessingHangarFlag =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    else -> if (i < descriptor.elementsCount) continue@loop else throw SerializationException("Unknown index $i")
                }
            }

            inp.endStructure(descriptor)

            return stastation(
                temp_stationID ?: throw SerializationException("Missing value for stationID"),
                temp_security ?: throw SerializationException("Missing value for security"),
                temp_dockingCostPerVolume ?: throw SerializationException("Missing value for dockingCostPerVolume"),
                temp_maxShipVolumeDockable ?: throw SerializationException("Missing value for maxShipVolumeDockable"),
                temp_officeRentalCost ?: throw SerializationException("Missing value for officeRentalCost"),
                temp_operationID ?: throw SerializationException("Missing value for operationID"),
                temp_stationTypeID ?: throw SerializationException("Missing value for stationTypeID"),
                temp_corporationID ?: throw SerializationException("Missing value for corporationID"),
                temp_solarSystemID ?: throw SerializationException("Missing value for solarSystemID"),
                temp_constellationID ?: throw SerializationException("Missing value for constellationID"),
                temp_regionID ?: throw SerializationException("Missing value for regionID"),
                temp_stationName ?: throw SerializationException("Missing value for stationName"),
                temp_x ?: throw SerializationException("Missing value for x"),
                temp_y ?: throw SerializationException("Missing value for y"),
                temp_z ?: throw SerializationException("Missing value for z"),
                temp_reprocessingEfficiency ?: throw SerializationException("Missing value for reprocessingEfficiency"),
                temp_reprocessingStationsTake
                    ?: throw SerializationException("Missing value for reprocessingStationsTake"),
                temp_reprocessingHangarFlag ?: throw SerializationException("Missing value for reprocessingHangarFlag")
            )
        }

        actual fun serializer(): KSerializer<stastation> = this
    }
}

