
package com.rnett.ligraph.eve.sde.data


import com.rnett.kframe.data.callEndpoint
import com.rnett.ligraph.eve.sde.requestClient
import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

@Serializable(with = invmetagroup.Companion::class)
actual data class invmetagroup(
    actual val metaGroupID: Int,
    actual val metaGroupName: String,
    actual val description: String,
    actual val iconID: Int
) {


    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is invmetagroup)
            return false
        return metaGroupID == other.metaGroupID
    }


    actual override fun hashCode() = metaGroupID


    actual override fun toString() = metaGroupName

    @Serializer(invmetagroup::class)
    actual companion object : KSerializer<invmetagroup> {
        actual fun getItem(id: Int): invmetagroup = callEndpoint(this::getItem, requestClient, id)
        actual fun allItems(): List<invmetagroup> = callEndpoint(this::allItems, requestClient)


        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("invmetagroup") {
            init {
                addElement("metaGroupID")
                addElement("metaGroupName")
                addElement("description")
                addElement("iconID")
            }
        }

        actual override fun serialize(output: Encoder, obj: invmetagroup) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.metaGroupID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.metaGroupName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.description.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.iconID.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): invmetagroup {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var temp_metaGroupID: Int? = null
            var temp_metaGroupName: String? = null
            var temp_description: String? = null
            var temp_iconID: Int? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> temp_metaGroupID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    1 -> temp_metaGroupName = stringFromUtf8Bytes(
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
                    3 -> temp_iconID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    else -> if (i < descriptor.elementsCount) continue@loop else throw SerializationException("Unknown index $i")
                }
            }

            inp.endStructure(descriptor)

            return invmetagroup(
                temp_metaGroupID ?: throw SerializationException("Missing value for metaGroupID"),
                temp_metaGroupName ?: throw SerializationException("Missing value for metaGroupName"),
                temp_description ?: throw SerializationException("Missing value for description"),
                temp_iconID ?: throw SerializationException("Missing value for iconID")
            )
        }

        actual fun serializer(): KSerializer<invmetagroup> = this
    }
}

