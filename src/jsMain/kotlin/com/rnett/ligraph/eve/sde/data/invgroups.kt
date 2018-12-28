package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

actual data class invgroup(
    actual val groupID: Int,
    actual val categoryID: Int,
    actual val groupName: String,
    actual val iconID: Int,
    actual val useBasePrice: Boolean,
    actual val anchored: Boolean,
    actual val anchorable: Boolean,
    actual val fittableNonSingleton: Boolean,
    actual val published: Boolean
) {
    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is invgroup)
            return false
        return groupID == other.groupID
    }


    actual override fun hashCode() = groupID


    actual override fun toString() = groupName

    @Serializer(invgroup::class)
    actual companion object : KSerializer<invgroup> {
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("invgroup") {
            init {
                addElement("groupID")
                addElement("categoryID")
                addElement("groupName")
                addElement("iconID")
                addElement("useBasePrice")
                addElement("anchored")
                addElement("anchorable")
                addElement("fittableNonSingleton")
                addElement("published")
            }
        }

        actual override fun serialize(output: Encoder, obj: invgroup) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.groupID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.categoryID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.groupName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.iconID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                4,
                HexConverter.printHexBinary(obj.useBasePrice.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                5,
                HexConverter.printHexBinary(obj.anchored.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                6,
                HexConverter.printHexBinary(obj.anchorable.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                7,
                HexConverter.printHexBinary(obj.fittableNonSingleton.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                8,
                HexConverter.printHexBinary(obj.published.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): invgroup {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var temp_groupID: Int? = null
            var temp_categoryID: Int? = null
            var temp_groupName: String? = null
            var temp_iconID: Int? = null
            var temp_useBasePrice: Boolean? = null
            var temp_anchored: Boolean? = null
            var temp_anchorable: Boolean? = null
            var temp_fittableNonSingleton: Boolean? = null
            var temp_published: Boolean? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> temp_groupID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    1 -> temp_categoryID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    2 -> temp_groupName = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    3 -> temp_iconID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    4 -> temp_useBasePrice = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toBoolean()
                    5 -> temp_anchored = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toBoolean()
                    6 -> temp_anchorable = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toBoolean()
                    7 -> temp_fittableNonSingleton = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toBoolean()
                    8 -> temp_published = stringFromUtf8Bytes(
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

            return invgroup(
                temp_groupID ?: throw SerializationException("Missing value for groupID"),
                temp_categoryID ?: throw SerializationException("Missing value for categoryID"),
                temp_groupName ?: throw SerializationException("Missing value for groupName"),
                temp_iconID ?: throw SerializationException("Missing value for iconID"),
                temp_useBasePrice ?: throw SerializationException("Missing value for useBasePrice"),
                temp_anchored ?: throw SerializationException("Missing value for anchored"),
                temp_anchorable ?: throw SerializationException("Missing value for anchorable"),
                temp_fittableNonSingleton ?: throw SerializationException("Missing value for fittableNonSingleton"),
                temp_published ?: throw SerializationException("Missing value for published")
            )
        }

        actual fun serializer(): KSerializer<invgroup> = this
    }
}

