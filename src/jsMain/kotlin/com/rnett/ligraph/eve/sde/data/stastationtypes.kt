
package com.rnett.ligraph.eve.sde.data


import com.rnett.kframe.data.callEndpoint
import com.rnett.ligraph.eve.sde.requestClient
import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

@Serializable(with = stastationtype.Companion::class)
actual data class stastationtype(
    actual val stationTypeID: Int,
    actual val dockEntryX: Double,
    actual val dockEntryY: Double,
    actual val dockEntryZ: Double,
    actual val dockOrientationX: Double,
    actual val dockOrientationY: Double,
    actual val dockOrientationZ: Double,
    actual val operationID: Int,
    actual val officeSlots: Int,
    actual val reprocessingEfficiency: Double,
    actual val conquerable: Boolean
) {


    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is stastationtype)
            return false
        return stationTypeID == other.stationTypeID
    }


    actual override fun hashCode() = stationTypeID


    @Serializer(stastationtype::class)
    actual companion object : KSerializer<stastationtype> {
        actual fun getItem(id: Int): stastationtype = callEndpoint(this::getItem, requestClient, id)
        actual fun allItems(): List<stastationtype> = callEndpoint(this::allItems, requestClient)


        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("stastationtype") {
            init {
                addElement("stationTypeID")
                addElement("dockEntryX")
                addElement("dockEntryY")
                addElement("dockEntryZ")
                addElement("dockOrientationX")
                addElement("dockOrientationY")
                addElement("dockOrientationZ")
                addElement("operationID")
                addElement("officeSlots")
                addElement("reprocessingEfficiency")
                addElement("conquerable")
            }
        }

        actual override fun serialize(output: Encoder, obj: stastationtype) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.stationTypeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.dockEntryX.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.dockEntryY.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.dockEntryZ.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                4,
                HexConverter.printHexBinary(obj.dockOrientationX.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                5,
                HexConverter.printHexBinary(obj.dockOrientationY.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                6,
                HexConverter.printHexBinary(obj.dockOrientationZ.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                7,
                HexConverter.printHexBinary(obj.operationID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                8,
                HexConverter.printHexBinary(obj.officeSlots.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                9,
                HexConverter.printHexBinary(obj.reprocessingEfficiency.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                10,
                HexConverter.printHexBinary(obj.conquerable.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): stastationtype {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var temp_stationTypeID: Int? = null
            var temp_dockEntryX: Double? = null
            var temp_dockEntryY: Double? = null
            var temp_dockEntryZ: Double? = null
            var temp_dockOrientationX: Double? = null
            var temp_dockOrientationY: Double? = null
            var temp_dockOrientationZ: Double? = null
            var temp_operationID: Int? = null
            var temp_officeSlots: Int? = null
            var temp_reprocessingEfficiency: Double? = null
            var temp_conquerable: Boolean? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> temp_stationTypeID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    1 -> temp_dockEntryX = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    2 -> temp_dockEntryY = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    3 -> temp_dockEntryZ = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    4 -> temp_dockOrientationX = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    5 -> temp_dockOrientationY = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    6 -> temp_dockOrientationZ = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    7 -> temp_operationID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    8 -> temp_officeSlots = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    9 -> temp_reprocessingEfficiency = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    10 -> temp_conquerable = stringFromUtf8Bytes(
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

            return stastationtype(
                temp_stationTypeID ?: throw SerializationException("Missing value for stationTypeID"),
                temp_dockEntryX ?: throw SerializationException("Missing value for dockEntryX"),
                temp_dockEntryY ?: throw SerializationException("Missing value for dockEntryY"),
                temp_dockEntryZ ?: throw SerializationException("Missing value for dockEntryZ"),
                temp_dockOrientationX ?: throw SerializationException("Missing value for dockOrientationX"),
                temp_dockOrientationY ?: throw SerializationException("Missing value for dockOrientationY"),
                temp_dockOrientationZ ?: throw SerializationException("Missing value for dockOrientationZ"),
                temp_operationID ?: throw SerializationException("Missing value for operationID"),
                temp_officeSlots ?: throw SerializationException("Missing value for officeSlots"),
                temp_reprocessingEfficiency ?: throw SerializationException("Missing value for reprocessingEfficiency"),
                temp_conquerable ?: throw SerializationException("Missing value for conquerable")
            )
        }

        actual fun serializer(): KSerializer<stastationtype> = this
    }
}

