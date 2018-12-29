
package com.rnett.ligraph.eve.sde.data


import com.rnett.kframe.data.callEndpoint
import com.rnett.ligraph.eve.sde.requestClient
import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

@Serializable(with = crpnpccorporation.Companion::class)
actual data class crpnpccorporation(
    actual val corporationID: Int,
    actual val size: Char,
    actual val extent: Char,
    actual val solarSystemID: Int,
    actual val investorID1: Int,
    actual val investorShares1: Int,
    actual val investorID2: Int,
    actual val investorShares2: Int,
    actual val investorID3: Int,
    actual val investorShares3: Int,
    actual val investorID4: Int,
    actual val investorShares4: Int,
    actual val friendID: Int,
    actual val enemyID: Int,
    actual val publicShares: Int,
    actual val initialPrice: Int,
    actual val minSecurity: Double,
    actual val scattered: Boolean,
    actual val fringe: Int,
    actual val corridor: Int,
    actual val hub: Int,
    actual val border: Int,
    actual val factionID: Int,
    actual val sizeFactor: Double,
    actual val stationCount: Int,
    actual val stationSystemCount: Int,
    actual val description: String,
    actual val iconID: Int
) {


    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is crpnpccorporation)
            return false
        return corporationID == other.corporationID
    }


    actual override fun hashCode() = corporationID


    @Serializer(crpnpccorporation::class)
    actual companion object : KSerializer<crpnpccorporation> {
        actual fun getItem(id: Int): crpnpccorporation = callEndpoint(this::getItem, requestClient, id)
        actual fun allItems(): List<crpnpccorporation> = callEndpoint(this::allItems, requestClient)


        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("crpnpccorporation") {
            init {
                addElement("corporationID")
                addElement("size")
                addElement("extent")
                addElement("solarSystemID")
                addElement("investorID1")
                addElement("investorShares1")
                addElement("investorID2")
                addElement("investorShares2")
                addElement("investorID3")
                addElement("investorShares3")
                addElement("investorID4")
                addElement("investorShares4")
                addElement("friendID")
                addElement("enemyID")
                addElement("publicShares")
                addElement("initialPrice")
                addElement("minSecurity")
                addElement("scattered")
                addElement("fringe")
                addElement("corridor")
                addElement("hub")
                addElement("border")
                addElement("factionID")
                addElement("sizeFactor")
                addElement("stationCount")
                addElement("stationSystemCount")
                addElement("description")
                addElement("iconID")
            }
        }

        actual override fun serialize(output: Encoder, obj: crpnpccorporation) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.corporationID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.size.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.extent.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.solarSystemID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                4,
                HexConverter.printHexBinary(obj.investorID1.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                5,
                HexConverter.printHexBinary(obj.investorShares1.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                6,
                HexConverter.printHexBinary(obj.investorID2.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                7,
                HexConverter.printHexBinary(obj.investorShares2.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                8,
                HexConverter.printHexBinary(obj.investorID3.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                9,
                HexConverter.printHexBinary(obj.investorShares3.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                10,
                HexConverter.printHexBinary(obj.investorID4.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                11,
                HexConverter.printHexBinary(obj.investorShares4.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                12,
                HexConverter.printHexBinary(obj.friendID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                13,
                HexConverter.printHexBinary(obj.enemyID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                14,
                HexConverter.printHexBinary(obj.publicShares.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                15,
                HexConverter.printHexBinary(obj.initialPrice.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                16,
                HexConverter.printHexBinary(obj.minSecurity.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                17,
                HexConverter.printHexBinary(obj.scattered.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                18,
                HexConverter.printHexBinary(obj.fringe.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                19,
                HexConverter.printHexBinary(obj.corridor.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                20,
                HexConverter.printHexBinary(obj.hub.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                21,
                HexConverter.printHexBinary(obj.border.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                22,
                HexConverter.printHexBinary(obj.factionID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                23,
                HexConverter.printHexBinary(obj.sizeFactor.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                24,
                HexConverter.printHexBinary(obj.stationCount.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                25,
                HexConverter.printHexBinary(obj.stationSystemCount.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                26,
                HexConverter.printHexBinary(obj.description.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                27,
                HexConverter.printHexBinary(obj.iconID.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): crpnpccorporation {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var temp_corporationID: Int? = null
            var temp_size: Char? = null
            var temp_extent: Char? = null
            var temp_solarSystemID: Int? = null
            var temp_investorID1: Int? = null
            var temp_investorShares1: Int? = null
            var temp_investorID2: Int? = null
            var temp_investorShares2: Int? = null
            var temp_investorID3: Int? = null
            var temp_investorShares3: Int? = null
            var temp_investorID4: Int? = null
            var temp_investorShares4: Int? = null
            var temp_friendID: Int? = null
            var temp_enemyID: Int? = null
            var temp_publicShares: Int? = null
            var temp_initialPrice: Int? = null
            var temp_minSecurity: Double? = null
            var temp_scattered: Boolean? = null
            var temp_fringe: Int? = null
            var temp_corridor: Int? = null
            var temp_hub: Int? = null
            var temp_border: Int? = null
            var temp_factionID: Int? = null
            var temp_sizeFactor: Double? = null
            var temp_stationCount: Int? = null
            var temp_stationSystemCount: Int? = null
            var temp_description: String? = null
            var temp_iconID: Int? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> temp_corporationID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    1 -> temp_size =
                            stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i)))[0]
                    2 -> temp_extent =
                            stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i)))[0]
                    3 -> temp_solarSystemID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    4 -> temp_investorID1 = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    5 -> temp_investorShares1 = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    6 -> temp_investorID2 = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    7 -> temp_investorShares2 = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    8 -> temp_investorID3 = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    9 -> temp_investorShares3 = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    10 -> temp_investorID4 = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    11 -> temp_investorShares4 = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    12 -> temp_friendID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    13 -> temp_enemyID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    14 -> temp_publicShares = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    15 -> temp_initialPrice = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    16 -> temp_minSecurity = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    17 -> temp_scattered = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toBoolean()
                    18 -> temp_fringe = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    19 -> temp_corridor = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    20 -> temp_hub = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    21 -> temp_border = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    22 -> temp_factionID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    23 -> temp_sizeFactor = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    24 -> temp_stationCount = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    25 -> temp_stationSystemCount = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    26 -> temp_description = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    27 -> temp_iconID = stringFromUtf8Bytes(
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

            return crpnpccorporation(
                temp_corporationID ?: throw SerializationException("Missing value for corporationID"),
                temp_size ?: throw SerializationException("Missing value for size"),
                temp_extent ?: throw SerializationException("Missing value for extent"),
                temp_solarSystemID ?: throw SerializationException("Missing value for solarSystemID"),
                temp_investorID1 ?: throw SerializationException("Missing value for investorID1"),
                temp_investorShares1 ?: throw SerializationException("Missing value for investorShares1"),
                temp_investorID2 ?: throw SerializationException("Missing value for investorID2"),
                temp_investorShares2 ?: throw SerializationException("Missing value for investorShares2"),
                temp_investorID3 ?: throw SerializationException("Missing value for investorID3"),
                temp_investorShares3 ?: throw SerializationException("Missing value for investorShares3"),
                temp_investorID4 ?: throw SerializationException("Missing value for investorID4"),
                temp_investorShares4 ?: throw SerializationException("Missing value for investorShares4"),
                temp_friendID ?: throw SerializationException("Missing value for friendID"),
                temp_enemyID ?: throw SerializationException("Missing value for enemyID"),
                temp_publicShares ?: throw SerializationException("Missing value for publicShares"),
                temp_initialPrice ?: throw SerializationException("Missing value for initialPrice"),
                temp_minSecurity ?: throw SerializationException("Missing value for minSecurity"),
                temp_scattered ?: throw SerializationException("Missing value for scattered"),
                temp_fringe ?: throw SerializationException("Missing value for fringe"),
                temp_corridor ?: throw SerializationException("Missing value for corridor"),
                temp_hub ?: throw SerializationException("Missing value for hub"),
                temp_border ?: throw SerializationException("Missing value for border"),
                temp_factionID ?: throw SerializationException("Missing value for factionID"),
                temp_sizeFactor ?: throw SerializationException("Missing value for sizeFactor"),
                temp_stationCount ?: throw SerializationException("Missing value for stationCount"),
                temp_stationSystemCount ?: throw SerializationException("Missing value for stationSystemCount"),
                temp_description ?: throw SerializationException("Missing value for description"),
                temp_iconID ?: throw SerializationException("Missing value for iconID")
            )
        }

        actual fun serializer(): KSerializer<crpnpccorporation> = this
    }
}

