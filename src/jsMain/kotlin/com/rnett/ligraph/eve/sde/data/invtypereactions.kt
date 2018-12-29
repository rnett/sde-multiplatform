
package com.rnett.ligraph.eve.sde.data


import com.rnett.kframe.data.callEndpoint
import com.rnett.ligraph.eve.sde.requestClient
import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

actual data class invtypereaction(
    actual val reactionTypeID: Int,
    actual val input: Boolean,
    actual val typeID: Int,
    actual val quantity: Int
) {
    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is invtypereaction)
            return false
        return reactionTypeID == other.reactionTypeID
    }


    actual override fun hashCode() = reactionTypeID


    @Serializer(invtypereaction::class)
    actual companion object : KSerializer<invtypereaction> {
        actual fun getItem(id: Int): invtypereaction = callEndpoint(this::getItem, requestClient, id)
        actual fun allItems(): List<invtypereaction> = callEndpoint(this::allItems, requestClient)
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("invtypereaction") {
            init {
                addElement("reactionTypeID")
                addElement("input")
                addElement("typeID")
                addElement("quantity")
            }
        }

        actual override fun serialize(output: Encoder, obj: invtypereaction) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.reactionTypeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.input.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.typeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.quantity.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): invtypereaction {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var temp_reactionTypeID: Int? = null
            var temp_input: Boolean? = null
            var temp_typeID: Int? = null
            var temp_quantity: Int? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> temp_reactionTypeID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    1 -> temp_input = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toBoolean()
                    2 -> temp_typeID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    3 -> temp_quantity =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    else -> if (i < descriptor.elementsCount) continue@loop else throw SerializationException("Unknown index $i")
                }
            }

            inp.endStructure(descriptor)

            return invtypereaction(
                temp_reactionTypeID ?: throw SerializationException("Missing value for reactionTypeID"),
                temp_input ?: throw SerializationException("Missing value for input"),
                temp_typeID ?: throw SerializationException("Missing value for typeID"),
                temp_quantity ?: throw SerializationException("Missing value for quantity")
            )
        }

        actual fun serializer(): KSerializer<invtypereaction> = this
    }
}

