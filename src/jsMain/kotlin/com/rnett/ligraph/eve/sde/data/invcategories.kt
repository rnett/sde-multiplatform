package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

actual data class invcategory(
    actual val categoryID: Int,
    actual val categoryName: String,
    actual val iconID: Int,
    actual val published: Boolean
) {
    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is invcategory)
            return false
        return categoryID == other.categoryID
    }


    actual override fun hashCode() = categoryID


    actual override fun toString() = categoryName

    @Serializer(invcategory::class)
    actual companion object : KSerializer<invcategory> {
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("invcategory") {
            init {
                addElement("categoryID")
                addElement("categoryName")
                addElement("iconID")
                addElement("published")
            }
        }

        actual override fun serialize(output: Encoder, obj: invcategory) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.categoryID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.categoryName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.iconID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.published.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): invcategory {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var temp_categoryID: Int? = null
            var temp_categoryName: String? = null
            var temp_iconID: Int? = null
            var temp_published: Boolean? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> temp_categoryID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    1 -> temp_categoryName = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    2 -> temp_iconID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    3 -> temp_published = stringFromUtf8Bytes(
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

            return invcategory(
                temp_categoryID ?: throw SerializationException("Missing value for categoryID"),
                temp_categoryName ?: throw SerializationException("Missing value for categoryName"),
                temp_iconID ?: throw SerializationException("Missing value for iconID"),
                temp_published ?: throw SerializationException("Missing value for published")
            )
        }

        actual fun serializer(): KSerializer<invcategory> = this
    }
}

