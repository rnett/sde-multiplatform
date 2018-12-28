package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

actual data class invtype(
    actual val typeID: Int,
    actual val groupID: Int,
    actual val typeName: String,
    actual val description: String,
    actual val mass: Double,
    actual val volume: Double,
    actual val capacity: Double,
    actual val portionSize: Int,
    actual val raceID: Int,
    actual val basePrice: Double,
    actual val published: Boolean,
    actual val marketGroupID: Int,
    actual val iconID: Int,
    actual val soundID: Int,
    actual val graphicID: Int
) {
    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is invtype)
            return false
        return typeID == other.typeID
    }


    actual override fun hashCode() = typeID


    actual override fun toString() = typeName

    @Serializer(invtype::class)
    actual companion object : KSerializer<invtype> {
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("invtype") {
            init {
                addElement("typeID")
                addElement("groupID")
                addElement("typeName")
                addElement("description")
                addElement("mass")
                addElement("volume")
                addElement("capacity")
                addElement("portionSize")
                addElement("raceID")
                addElement("basePrice")
                addElement("published")
                addElement("marketGroupID")
                addElement("iconID")
                addElement("soundID")
                addElement("graphicID")
            }
        }

        actual override fun serialize(output: Encoder, obj: invtype) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.typeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.groupID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.typeName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.description.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                4,
                HexConverter.printHexBinary(obj.mass.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                5,
                HexConverter.printHexBinary(obj.volume.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                6,
                HexConverter.printHexBinary(obj.capacity.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                7,
                HexConverter.printHexBinary(obj.portionSize.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                8,
                HexConverter.printHexBinary(obj.raceID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                9,
                HexConverter.printHexBinary(obj.basePrice.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                10,
                HexConverter.printHexBinary(obj.published.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                11,
                HexConverter.printHexBinary(obj.marketGroupID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                12,
                HexConverter.printHexBinary(obj.iconID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                13,
                HexConverter.printHexBinary(obj.soundID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                14,
                HexConverter.printHexBinary(obj.graphicID.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): invtype {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var temp_typeID: Int? = null
            var temp_groupID: Int? = null
            var temp_typeName: String? = null
            var temp_description: String? = null
            var temp_mass: Double? = null
            var temp_volume: Double? = null
            var temp_capacity: Double? = null
            var temp_portionSize: Int? = null
            var temp_raceID: Int? = null
            var temp_basePrice: Double? = null
            var temp_published: Boolean? = null
            var temp_marketGroupID: Int? = null
            var temp_iconID: Int? = null
            var temp_soundID: Int? = null
            var temp_graphicID: Int? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> temp_typeID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    1 -> temp_groupID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    2 -> temp_typeName = stringFromUtf8Bytes(
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
                    4 -> temp_mass = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    5 -> temp_volume = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    6 -> temp_capacity = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    7 -> temp_portionSize = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    8 -> temp_raceID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    9 -> temp_basePrice = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    10 -> temp_published = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toBoolean()
                    11 -> temp_marketGroupID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    12 -> temp_iconID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    13 -> temp_soundID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    14 -> temp_graphicID = stringFromUtf8Bytes(
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

            return invtype(
                temp_typeID ?: throw SerializationException("Missing value for typeID"),
                temp_groupID ?: throw SerializationException("Missing value for groupID"),
                temp_typeName ?: throw SerializationException("Missing value for typeName"),
                temp_description ?: throw SerializationException("Missing value for description"),
                temp_mass ?: throw SerializationException("Missing value for mass"),
                temp_volume ?: throw SerializationException("Missing value for volume"),
                temp_capacity ?: throw SerializationException("Missing value for capacity"),
                temp_portionSize ?: throw SerializationException("Missing value for portionSize"),
                temp_raceID ?: throw SerializationException("Missing value for raceID"),
                temp_basePrice ?: throw SerializationException("Missing value for basePrice"),
                temp_published ?: throw SerializationException("Missing value for published"),
                temp_marketGroupID ?: throw SerializationException("Missing value for marketGroupID"),
                temp_iconID ?: throw SerializationException("Missing value for iconID"),
                temp_soundID ?: throw SerializationException("Missing value for soundID"),
                temp_graphicID ?: throw SerializationException("Missing value for graphicID")
            )
        }

        actual fun serializer(): KSerializer<invtype> = this
    }
}

