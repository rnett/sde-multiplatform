
package com.rnett.ligraph.eve.sde.data


import com.rnett.kframe.data.callEndpoint
import com.rnett.ligraph.eve.sde.requestClient
import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

@Serializable(with = invitem.Companion::class)
actual data class invitem(
    actual val itemID: Int,
    actual val typeID: Int,
    actual val ownerID: Int,
    actual val locationID: Int,
    actual val flagID: Int,
    actual val quantity: Int
) {


    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is invitem)
            return false
        return itemID == other.itemID
    }


    actual override fun hashCode() = itemID


    @Serializer(invitem::class)
    actual companion object : KSerializer<invitem> {
        actual fun getItem(id: Int): invitem = callEndpoint(this::getItem, requestClient, id)
        actual fun allItems(): List<invitem> = callEndpoint(this::allItems, requestClient)


        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("invitem") {
            init {
                addElement("itemID")
                addElement("typeID")
                addElement("ownerID")
                addElement("locationID")
                addElement("flagID")
                addElement("quantity")
            }
        }

        actual override fun serialize(output: Encoder, obj: invitem) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.itemID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.typeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.ownerID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.locationID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                4,
                HexConverter.printHexBinary(obj.flagID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                5,
                HexConverter.printHexBinary(obj.quantity.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): invitem {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var temp_itemID: Int? = null
            var temp_typeID: Int? = null
            var temp_ownerID: Int? = null
            var temp_locationID: Int? = null
            var temp_flagID: Int? = null
            var temp_quantity: Int? = null
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
                    1 -> temp_typeID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    2 -> temp_ownerID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    3 -> temp_locationID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    4 -> temp_flagID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    5 -> temp_quantity = stringFromUtf8Bytes(
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

            return invitem(
                temp_itemID ?: throw SerializationException("Missing value for itemID"),
                temp_typeID ?: throw SerializationException("Missing value for typeID"),
                temp_ownerID ?: throw SerializationException("Missing value for ownerID"),
                temp_locationID ?: throw SerializationException("Missing value for locationID"),
                temp_flagID ?: throw SerializationException("Missing value for flagID"),
                temp_quantity ?: throw SerializationException("Missing value for quantity")
            )
        }

        actual fun serializer(): KSerializer<invitem> = this
    }
}

