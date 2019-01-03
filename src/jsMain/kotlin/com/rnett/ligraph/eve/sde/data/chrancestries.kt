
package com.rnett.ligraph.eve.sde.data


import com.rnett.kframe.data.callEndpoint
import com.rnett.ligraph.eve.sde.requestClient
import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

@Serializable(with = chrancestry.Companion::class)
actual data class chrancestry(
    actual val ancestryID: Int,
    actual val ancestryName: String,
    actual val bloodlineID: Int,
    actual val description: String,
    actual val perception: Int,
    actual val willpower: Int,
    actual val charisma: Int,
    actual val memory: Int,
    actual val intelligence: Int,
    actual val iconID: Int,
    actual val shortDescription: String
) {


    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is chrancestry)
            return false
        return ancestryID == other.ancestryID
    }


    actual override fun hashCode() = ancestryID


    actual override fun toString() = ancestryName

    @Serializer(chrancestry::class)
    actual companion object : KSerializer<chrancestry> {
        actual fun getItem(id: Int): chrancestry = callEndpoint(this::getItem, requestClient, id)
        actual fun allItems(): List<chrancestry> = callEndpoint(this::allItems, requestClient)


        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("chrancestry") {
            init {
                addElement("ancestryID")
                addElement("ancestryName")
                addElement("bloodlineID")
                addElement("description")
                addElement("perception")
                addElement("willpower")
                addElement("charisma")
                addElement("memory")
                addElement("intelligence")
                addElement("iconID")
                addElement("shortDescription")
            }
        }

        actual override fun serialize(output: Encoder, obj: chrancestry) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.ancestryID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.ancestryName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.bloodlineID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.description.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                4,
                HexConverter.printHexBinary(obj.perception.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                5,
                HexConverter.printHexBinary(obj.willpower.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                6,
                HexConverter.printHexBinary(obj.charisma.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                7,
                HexConverter.printHexBinary(obj.memory.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                8,
                HexConverter.printHexBinary(obj.intelligence.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                9,
                HexConverter.printHexBinary(obj.iconID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                10,
                HexConverter.printHexBinary(obj.shortDescription.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): chrancestry {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var temp_ancestryID: Int? = null
            var temp_ancestryName: String? = null
            var temp_bloodlineID: Int? = null
            var temp_description: String? = null
            var temp_perception: Int? = null
            var temp_willpower: Int? = null
            var temp_charisma: Int? = null
            var temp_memory: Int? = null
            var temp_intelligence: Int? = null
            var temp_iconID: Int? = null
            var temp_shortDescription: String? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> temp_ancestryID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    1 -> temp_ancestryName = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    2 -> temp_bloodlineID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    3 -> temp_description = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    4 -> temp_perception =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    5 -> temp_willpower =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    6 -> temp_charisma =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    7 -> temp_memory =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    8 -> temp_intelligence =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    9 -> temp_iconID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    10 -> temp_shortDescription = stringFromUtf8Bytes(
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

            return chrancestry(
                temp_ancestryID ?: throw SerializationException("Missing value for ancestryID"),
                temp_ancestryName ?: throw SerializationException("Missing value for ancestryName"),
                temp_bloodlineID ?: throw SerializationException("Missing value for bloodlineID"),
                temp_description ?: throw SerializationException("Missing value for description"),
                temp_perception ?: throw SerializationException("Missing value for perception"),
                temp_willpower ?: throw SerializationException("Missing value for willpower"),
                temp_charisma ?: throw SerializationException("Missing value for charisma"),
                temp_memory ?: throw SerializationException("Missing value for memory"),
                temp_intelligence ?: throw SerializationException("Missing value for intelligence"),
                temp_iconID ?: throw SerializationException("Missing value for iconID"),
                temp_shortDescription ?: throw SerializationException("Missing value for shortDescription")
            )
        }

        actual fun serializer(): KSerializer<chrancestry> = this
    }
}

