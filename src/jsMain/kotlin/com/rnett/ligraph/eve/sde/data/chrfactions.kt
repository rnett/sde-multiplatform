package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

actual data class chrfaction(
    actual val factionID: Int,
    actual val factionName: String,
    actual val description: String,
    actual val raceIDs: Int,
    actual val solarSystemID: Int,
    actual val corporationID: Int,
    actual val sizeFactor: Double,
    actual val stationCount: Int,
    actual val stationSystemCount: Int,
    actual val militiaCorporationID: Int,
    actual val iconID: Int
) {
    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is chrfaction)
            return false
        return factionID == other.factionID
    }


    actual override fun hashCode() = factionID


    actual override fun toString() = factionName

    @Serializer(chrfaction::class)
    actual companion object : KSerializer<chrfaction> {
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("chrfaction") {
            init {
                addElement("factionID")
                addElement("factionName")
                addElement("description")
                addElement("raceIDs")
                addElement("solarSystemID")
                addElement("corporationID")
                addElement("sizeFactor")
                addElement("stationCount")
                addElement("stationSystemCount")
                addElement("militiaCorporationID")
                addElement("iconID")
            }
        }

        actual override fun serialize(output: Encoder, obj: chrfaction) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.factionID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.factionName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.description.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.raceIDs.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                4,
                HexConverter.printHexBinary(obj.solarSystemID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                5,
                HexConverter.printHexBinary(obj.corporationID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                6,
                HexConverter.printHexBinary(obj.sizeFactor.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                7,
                HexConverter.printHexBinary(obj.stationCount.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                8,
                HexConverter.printHexBinary(obj.stationSystemCount.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                9,
                HexConverter.printHexBinary(obj.militiaCorporationID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                10,
                HexConverter.printHexBinary(obj.iconID.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): chrfaction {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var temp_factionID: Int? = null
            var temp_factionName: String? = null
            var temp_description: String? = null
            var temp_raceIDs: Int? = null
            var temp_solarSystemID: Int? = null
            var temp_corporationID: Int? = null
            var temp_sizeFactor: Double? = null
            var temp_stationCount: Int? = null
            var temp_stationSystemCount: Int? = null
            var temp_militiaCorporationID: Int? = null
            var temp_iconID: Int? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> temp_factionID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    1 -> temp_factionName = stringFromUtf8Bytes(
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
                    3 -> temp_raceIDs = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    4 -> temp_solarSystemID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    5 -> temp_corporationID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    6 -> temp_sizeFactor = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    7 -> temp_stationCount = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    8 -> temp_stationSystemCount = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    9 -> temp_militiaCorporationID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    10 -> temp_iconID = stringFromUtf8Bytes(
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

            return chrfaction(
                temp_factionID ?: throw SerializationException("Missing value for factionID"),
                temp_factionName ?: throw SerializationException("Missing value for factionName"),
                temp_description ?: throw SerializationException("Missing value for description"),
                temp_raceIDs ?: throw SerializationException("Missing value for raceIDs"),
                temp_solarSystemID ?: throw SerializationException("Missing value for solarSystemID"),
                temp_corporationID ?: throw SerializationException("Missing value for corporationID"),
                temp_sizeFactor ?: throw SerializationException("Missing value for sizeFactor"),
                temp_stationCount ?: throw SerializationException("Missing value for stationCount"),
                temp_stationSystemCount ?: throw SerializationException("Missing value for stationSystemCount"),
                temp_militiaCorporationID ?: throw SerializationException("Missing value for militiaCorporationID"),
                temp_iconID ?: throw SerializationException("Missing value for iconID")
            )
        }

        actual fun serializer(): KSerializer<chrfaction> = this
    }
}

