
package com.rnett.ligraph.eve.sde.data


import com.rnett.kframe.data.callEndpoint
import com.rnett.ligraph.eve.sde.requestClient
import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

@Serializable(with = invuniquename.Companion::class)
actual data class invuniquename(
    actual val itemID: Int,
    actual val itemName: String,
    actual val groupID: Int
) {


    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is invuniquename)
            return false
        return itemID == other.itemID
    }


    actual override fun hashCode() = itemID


    actual override fun toString() = itemName

    @Serializer(invuniquename::class)
    actual companion object : KSerializer<invuniquename> {
        actual fun getItem(id: Int): invuniquename = callEndpoint(this::getItem, requestClient, id)
        actual fun allItems(): List<invuniquename> = callEndpoint(this::allItems, requestClient)


        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("invuniquename") {
            init {
                addElement("itemID")
                addElement("itemName")
                addElement("groupID")
            }
        }

        actual override fun serialize(output: Encoder, obj: invuniquename) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.itemID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.itemName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.groupID.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): invuniquename {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var temp_itemID: Int? = null
            var temp_itemName: String? = null
            var temp_groupID: Int? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> temp_itemID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    1 -> temp_itemName = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    2 -> temp_groupID = stringFromUtf8Bytes(
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

            return invuniquename(
                temp_itemID ?: throw SerializationException("Missing value for itemID"),
                temp_itemName ?: throw SerializationException("Missing value for itemName"),
                temp_groupID ?: throw SerializationException("Missing value for groupID")
            )
        }

        actual fun serializer(): KSerializer<invuniquename> = this
    }
}

