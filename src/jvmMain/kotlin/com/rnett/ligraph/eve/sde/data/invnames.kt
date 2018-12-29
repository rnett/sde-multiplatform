
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.transactions.transaction

object invnames : IntIdTable("invnames", "itemID") {
    // Database Columns

    val itemID = integer("itemID").primaryKey()
    val itemName = varchar("itemName", 200)
}


@Serializable(with = invname.Companion::class)
actual class invname(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(invname::class)
    actual companion object : IntEntityClass<invname>(invnames), KSerializer<invname> {
        actual fun getItem(id: Int) = transaction { super.get(id) }
        actual fun allItems() = transaction { super.all().toList() }
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
                return invname[id]
        }

        actual fun serializer(): KSerializer<invname> = this
    }

    // Database Columns

    actual val itemID by invnames.itemID
    actual val itemName by invnames.itemName


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is invname)
            return false
        return itemID == other.itemID
    }


    actual override fun hashCode() = itemID


    actual override fun toString() = itemName
}

