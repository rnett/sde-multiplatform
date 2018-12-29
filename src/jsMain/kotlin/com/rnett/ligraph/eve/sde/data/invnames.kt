
package com.rnett.ligraph.eve.sde.data


import com.rnett.kframe.data.callEndpoint
import com.rnett.ligraph.eve.sde.requestClient
import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

@Serializable(with = invname.Companion::class)
actual data class invname(
    actual val itemID: Int,
    actual val itemName: String
) {


    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is invname)
            return false
        return itemID == other.itemID
    }


    actual override fun hashCode() = itemID


    actual override fun toString() = itemName

    @Serializer(invname::class)
    actual companion object : KSerializer<invname> {
        actual fun getItem(id: Int): invname = callEndpoint(this::getItem, requestClient, id)
        actual fun allItems(): List<invname> = callEndpoint(this::allItems, requestClient)


        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("invname") {
            init {
                addElement("itemID")
                addElement("itemName")
            }
        }

        actual override fun serialize(output: Encoder, obj: invname) {
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
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): invname {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var temp_itemID: Int? = null
            var temp_itemName: String? = null
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
                    else -> if (i < descriptor.elementsCount) continue@loop else throw SerializationException("Unknown index $i")
                }
            }

            inp.endStructure(descriptor)

            return invname(
                temp_itemID ?: throw SerializationException("Missing value for itemID"),
                temp_itemName ?: throw SerializationException("Missing value for itemName")
            )
        }

        actual fun serializer(): KSerializer<invname> = this
    }
}

