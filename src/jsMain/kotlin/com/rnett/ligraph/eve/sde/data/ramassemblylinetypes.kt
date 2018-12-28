package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

actual data class ramassemblylinetype(
    actual val assemblyLineTypeID: Int,
    actual val assemblyLineTypeName: String,
    actual val description: String,
    actual val baseTimeMultiplier: Double,
    actual val baseMaterialMultiplier: Double,
    actual val baseCostMultiplier: Double,
    actual val volume: Double,
    actual val activityID: Int,
    actual val minCostPerHour: Double
) {
    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is ramassemblylinetype)
            return false
        return assemblyLineTypeID == other.assemblyLineTypeID
    }


    actual override fun hashCode() = assemblyLineTypeID


    actual override fun toString() = assemblyLineTypeName

    @Serializer(ramassemblylinetype::class)
    actual companion object : KSerializer<ramassemblylinetype> {
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("ramassemblylinetype") {
            init {
                addElement("assemblyLineTypeID")
                addElement("assemblyLineTypeName")
                addElement("description")
                addElement("baseTimeMultiplier")
                addElement("baseMaterialMultiplier")
                addElement("baseCostMultiplier")
                addElement("volume")
                addElement("activityID")
                addElement("minCostPerHour")
            }
        }

        actual override fun serialize(output: Encoder, obj: ramassemblylinetype) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.assemblyLineTypeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.assemblyLineTypeName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.description.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.baseTimeMultiplier.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                4,
                HexConverter.printHexBinary(obj.baseMaterialMultiplier.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                5,
                HexConverter.printHexBinary(obj.baseCostMultiplier.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                6,
                HexConverter.printHexBinary(obj.volume.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                7,
                HexConverter.printHexBinary(obj.activityID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                8,
                HexConverter.printHexBinary(obj.minCostPerHour.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): ramassemblylinetype {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var temp_assemblyLineTypeID: Int? = null
            var temp_assemblyLineTypeName: String? = null
            var temp_description: String? = null
            var temp_baseTimeMultiplier: Double? = null
            var temp_baseMaterialMultiplier: Double? = null
            var temp_baseCostMultiplier: Double? = null
            var temp_volume: Double? = null
            var temp_activityID: Int? = null
            var temp_minCostPerHour: Double? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> temp_assemblyLineTypeID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    1 -> temp_assemblyLineTypeName = stringFromUtf8Bytes(
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
                    3 -> temp_baseTimeMultiplier = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    4 -> temp_baseMaterialMultiplier = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    5 -> temp_baseCostMultiplier = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    6 -> temp_volume = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    7 -> temp_activityID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    8 -> temp_minCostPerHour = stringFromUtf8Bytes(
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

            return ramassemblylinetype(
                temp_assemblyLineTypeID ?: throw SerializationException("Missing value for assemblyLineTypeID"),
                temp_assemblyLineTypeName ?: throw SerializationException("Missing value for assemblyLineTypeName"),
                temp_description ?: throw SerializationException("Missing value for description"),
                temp_baseTimeMultiplier ?: throw SerializationException("Missing value for baseTimeMultiplier"),
                temp_baseMaterialMultiplier ?: throw SerializationException("Missing value for baseMaterialMultiplier"),
                temp_baseCostMultiplier ?: throw SerializationException("Missing value for baseCostMultiplier"),
                temp_volume ?: throw SerializationException("Missing value for volume"),
                temp_activityID ?: throw SerializationException("Missing value for activityID"),
                temp_minCostPerHour ?: throw SerializationException("Missing value for minCostPerHour")
            )
        }

        actual fun serializer(): KSerializer<ramassemblylinetype> = this
    }
}

