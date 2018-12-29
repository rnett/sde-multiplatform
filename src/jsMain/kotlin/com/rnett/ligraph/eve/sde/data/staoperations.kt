
package com.rnett.ligraph.eve.sde.data


import com.rnett.kframe.data.callEndpoint
import com.rnett.ligraph.eve.sde.requestClient
import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

actual data class staoperation(
    actual val activityID: Int,
    actual val operationID: Int,
    actual val operationName: String,
    actual val description: String,
    actual val fringe: Int,
    actual val corridor: Int,
    actual val hub: Int,
    actual val border: Int,
    actual val ratio: Int,
    actual val caldariStationTypeID: Int,
    actual val minmatarStationTypeID: Int,
    actual val amarrStationTypeID: Int,
    actual val gallenteStationTypeID: Int,
    actual val joveStationTypeID: Int
) {
    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is staoperation)
            return false
        return operationID == other.operationID
    }


    actual override fun hashCode() = operationID


    actual override fun toString() = operationName

    @Serializer(staoperation::class)
    actual companion object : KSerializer<staoperation> {
        actual fun getItem(id: Int): staoperation = callEndpoint(this::getItem, requestClient, id)
        actual fun allItems(): List<staoperation> = callEndpoint(this::allItems, requestClient)
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("staoperation") {
            init {
                addElement("activityID")
                addElement("operationID")
                addElement("operationName")
                addElement("description")
                addElement("fringe")
                addElement("corridor")
                addElement("hub")
                addElement("border")
                addElement("ratio")
                addElement("caldariStationTypeID")
                addElement("minmatarStationTypeID")
                addElement("amarrStationTypeID")
                addElement("gallenteStationTypeID")
                addElement("joveStationTypeID")
            }
        }

        actual override fun serialize(output: Encoder, obj: staoperation) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.activityID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.operationID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.operationName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.description.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                4,
                HexConverter.printHexBinary(obj.fringe.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                5,
                HexConverter.printHexBinary(obj.corridor.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                6,
                HexConverter.printHexBinary(obj.hub.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                7,
                HexConverter.printHexBinary(obj.border.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                8,
                HexConverter.printHexBinary(obj.ratio.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                9,
                HexConverter.printHexBinary(obj.caldariStationTypeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                10,
                HexConverter.printHexBinary(obj.minmatarStationTypeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                11,
                HexConverter.printHexBinary(obj.amarrStationTypeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                12,
                HexConverter.printHexBinary(obj.gallenteStationTypeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                13,
                HexConverter.printHexBinary(obj.joveStationTypeID.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): staoperation {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var temp_activityID: Int? = null
            var temp_operationID: Int? = null
            var temp_operationName: String? = null
            var temp_description: String? = null
            var temp_fringe: Int? = null
            var temp_corridor: Int? = null
            var temp_hub: Int? = null
            var temp_border: Int? = null
            var temp_ratio: Int? = null
            var temp_caldariStationTypeID: Int? = null
            var temp_minmatarStationTypeID: Int? = null
            var temp_amarrStationTypeID: Int? = null
            var temp_gallenteStationTypeID: Int? = null
            var temp_joveStationTypeID: Int? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> temp_activityID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    1 -> temp_operationID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    2 -> temp_operationName = stringFromUtf8Bytes(
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
                    4 -> temp_fringe =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    5 -> temp_corridor =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    6 -> temp_hub =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    7 -> temp_border =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    8 -> temp_ratio =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    9 -> temp_caldariStationTypeID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    10 -> temp_minmatarStationTypeID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    11 -> temp_amarrStationTypeID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    12 -> temp_gallenteStationTypeID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    13 -> temp_joveStationTypeID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    else -> if (i < descriptor.elementsCount) continue@loop else throw SerializationException("Unknown index $i")
                }
            }

            inp.endStructure(descriptor)

            return staoperation(
                temp_activityID ?: throw SerializationException("Missing value for activityID"),
                temp_operationID ?: throw SerializationException("Missing value for operationID"),
                temp_operationName ?: throw SerializationException("Missing value for operationName"),
                temp_description ?: throw SerializationException("Missing value for description"),
                temp_fringe ?: throw SerializationException("Missing value for fringe"),
                temp_corridor ?: throw SerializationException("Missing value for corridor"),
                temp_hub ?: throw SerializationException("Missing value for hub"),
                temp_border ?: throw SerializationException("Missing value for border"),
                temp_ratio ?: throw SerializationException("Missing value for ratio"),
                temp_caldariStationTypeID ?: throw SerializationException("Missing value for caldariStationTypeID"),
                temp_minmatarStationTypeID ?: throw SerializationException("Missing value for minmatarStationTypeID"),
                temp_amarrStationTypeID ?: throw SerializationException("Missing value for amarrStationTypeID"),
                temp_gallenteStationTypeID ?: throw SerializationException("Missing value for gallenteStationTypeID"),
                temp_joveStationTypeID ?: throw SerializationException("Missing value for joveStationTypeID")
            )
        }

        actual fun serializer(): KSerializer<staoperation> = this
    }
}

