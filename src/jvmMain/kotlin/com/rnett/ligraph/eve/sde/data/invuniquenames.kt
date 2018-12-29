
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.transactions.transaction

object invuniquenames : IntIdTable("invuniquenames", "itemID") {
    // Database Columns

    val itemID = integer("itemID").primaryKey()
    val itemName = varchar("itemName", 200)
    val groupID = integer("groupID")
}


@Serializable(with = invuniquename.Companion::class)
actual class invuniquename(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(invuniquename::class)
    actual companion object : IntEntityClass<invuniquename>(invuniquenames), KSerializer<invuniquename> {
        actual fun getItem(id: Int) = transaction { super.get(id) }
        actual fun allItems() = transaction { super.all().toList() }
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
                return invuniquename[id]
        }

        actual fun serializer(): KSerializer<invuniquename> = this
    }

    // Database Columns

    actual val itemID by invuniquenames.itemID
    actual val itemName by invuniquenames.itemName
    actual val groupID by invuniquenames.groupID


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is invuniquename)
            return false
        return itemID == other.itemID
    }


    actual override fun hashCode() = itemID


    actual override fun toString() = itemName
}

