
package com.rnett.ligraph.eve.sde.data


import com.rnett.kframe.data.callEndpoint
import com.rnett.ligraph.eve.sde.requestClient
import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

@Serializable(with = chrbloodline.Companion::class)
actual data class chrbloodline(
    actual val bloodlineID: Int,
    actual val bloodlineName: String,
    actual val raceID: Int,
    actual val description: String,
    actual val maleDescription: String,
    actual val femaleDescription: String,
    actual val shipTypeID: Int,
    actual val corporationID: Int,
    actual val perception: Int,
    actual val willpower: Int,
    actual val charisma: Int,
    actual val memory: Int,
    actual val intelligence: Int,
    actual val iconID: Int,
    actual val shortDescription: String,
    actual val shortMaleDescription: String,
    actual val shortFemaleDescription: String
) {


    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is chrbloodline)
            return false
        return bloodlineID == other.bloodlineID
    }


    actual override fun hashCode() = bloodlineID


    actual override fun toString() = bloodlineName

    @Serializer(chrbloodline::class)
    actual companion object : KSerializer<chrbloodline> {
        actual fun getItem(id: Int): chrbloodline = callEndpoint(this::getItem, requestClient, id)
        actual fun allItems(): List<chrbloodline> = callEndpoint(this::allItems, requestClient)


        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("chrbloodline") {
            init {
                addElement("bloodlineID")
                addElement("bloodlineName")
                addElement("raceID")
                addElement("description")
                addElement("maleDescription")
                addElement("femaleDescription")
                addElement("shipTypeID")
                addElement("corporationID")
                addElement("perception")
                addElement("willpower")
                addElement("charisma")
                addElement("memory")
                addElement("intelligence")
                addElement("iconID")
                addElement("shortDescription")
                addElement("shortMaleDescription")
                addElement("shortFemaleDescription")
            }
        }

        actual override fun serialize(output: Encoder, obj: chrbloodline) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.bloodlineID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.bloodlineName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.raceID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.description.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                4,
                HexConverter.printHexBinary(obj.maleDescription.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                5,
                HexConverter.printHexBinary(obj.femaleDescription.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                6,
                HexConverter.printHexBinary(obj.shipTypeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                7,
                HexConverter.printHexBinary(obj.corporationID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                8,
                HexConverter.printHexBinary(obj.perception.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                9,
                HexConverter.printHexBinary(obj.willpower.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                10,
                HexConverter.printHexBinary(obj.charisma.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                11,
                HexConverter.printHexBinary(obj.memory.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                12,
                HexConverter.printHexBinary(obj.intelligence.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                13,
                HexConverter.printHexBinary(obj.iconID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                14,
                HexConverter.printHexBinary(obj.shortDescription.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                15,
                HexConverter.printHexBinary(obj.shortMaleDescription.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                16,
                HexConverter.printHexBinary(obj.shortFemaleDescription.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): chrbloodline {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var temp_bloodlineID: Int? = null
            var temp_bloodlineName: String? = null
            var temp_raceID: Int? = null
            var temp_description: String? = null
            var temp_maleDescription: String? = null
            var temp_femaleDescription: String? = null
            var temp_shipTypeID: Int? = null
            var temp_corporationID: Int? = null
            var temp_perception: Int? = null
            var temp_willpower: Int? = null
            var temp_charisma: Int? = null
            var temp_memory: Int? = null
            var temp_intelligence: Int? = null
            var temp_iconID: Int? = null
            var temp_shortDescription: String? = null
            var temp_shortMaleDescription: String? = null
            var temp_shortFemaleDescription: String? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> temp_bloodlineID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    1 -> temp_bloodlineName = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    2 -> temp_raceID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    3 -> temp_description = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    4 -> temp_maleDescription = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    5 -> temp_femaleDescription = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    6 -> temp_shipTypeID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    7 -> temp_corporationID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    8 -> temp_perception =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    9 -> temp_willpower =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    10 -> temp_charisma =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    11 -> temp_memory =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    12 -> temp_intelligence =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    13 -> temp_iconID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    14 -> temp_shortDescription = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    15 -> temp_shortMaleDescription = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    16 -> temp_shortFemaleDescription = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    else -> if (i < descriptor.elementsCount) continue@loop else throw SerializationException("Unknown index $i")
                }
            }

            inp.endStructure(descriptor)

            return chrbloodline(
                temp_bloodlineID ?: throw SerializationException("Missing value for bloodlineID"),
                temp_bloodlineName ?: throw SerializationException("Missing value for bloodlineName"),
                temp_raceID ?: throw SerializationException("Missing value for raceID"),
                temp_description ?: throw SerializationException("Missing value for description"),
                temp_maleDescription ?: throw SerializationException("Missing value for maleDescription"),
                temp_femaleDescription ?: throw SerializationException("Missing value for femaleDescription"),
                temp_shipTypeID ?: throw SerializationException("Missing value for shipTypeID"),
                temp_corporationID ?: throw SerializationException("Missing value for corporationID"),
                temp_perception ?: throw SerializationException("Missing value for perception"),
                temp_willpower ?: throw SerializationException("Missing value for willpower"),
                temp_charisma ?: throw SerializationException("Missing value for charisma"),
                temp_memory ?: throw SerializationException("Missing value for memory"),
                temp_intelligence ?: throw SerializationException("Missing value for intelligence"),
                temp_iconID ?: throw SerializationException("Missing value for iconID"),
                temp_shortDescription ?: throw SerializationException("Missing value for shortDescription"),
                temp_shortMaleDescription ?: throw SerializationException("Missing value for shortMaleDescription"),
                temp_shortFemaleDescription ?: throw SerializationException("Missing value for shortFemaleDescription")
            )
        }

        actual fun serializer(): KSerializer<chrbloodline> = this
    }
}

