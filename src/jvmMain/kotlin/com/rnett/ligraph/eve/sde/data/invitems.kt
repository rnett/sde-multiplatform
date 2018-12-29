
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.transactions.transaction

object invitems : IntIdTable("invitems", "itemID") {
    // Database Columns

    val itemID = integer("itemID").primaryKey()
    val typeID = integer("typeID")
    val ownerID = integer("ownerID")
    val locationID = integer("locationID")
    val flagID = integer("flagID")
    val quantity = integer("quantity")
}


@Serializable(with = invitem.Companion::class)
actual class invitem(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(invitem::class)
    actual companion object : IntEntityClass<invitem>(invitems), KSerializer<invitem> {
        actual fun getItem(id: Int) = transaction { super.get(id) }
        actual fun allItems() = transaction { super.all().toList() }
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
            var id: Int? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> id = stringFromUtf8Bytes(
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
            if (id == null)
                throw SerializationException("Id 'itemID' @ index 0 not found")
            else
                return invitem[id]
        }

        actual fun serializer(): KSerializer<invitem> = this
    }

    // Database Columns

    actual val itemID by invitems.itemID
    actual val typeID by invitems.typeID
    actual val ownerID by invitems.ownerID
    actual val locationID by invitems.locationID
    actual val flagID by invitems.flagID
    actual val quantity by invitems.quantity


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is invitem)
            return false
        return itemID == other.itemID
    }


    actual override fun hashCode() = itemID


}

