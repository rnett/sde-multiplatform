
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.transactions.transaction

object eveicons : IntIdTable("eveicons", "iconID") {
    // Database Columns

    val iconID = integer("iconID").primaryKey()
    val iconFile = varchar("iconFile", 500)
    val description = text("description")
}



actual class eveicon(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(eveicon::class)
    actual companion object : IntEntityClass<eveicon>(eveicons), KSerializer<eveicon> {
        actual fun getItem(id: Int) = transaction { super.get(id) }
        actual fun allItems() = transaction { super.all().toList() }
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("eveicon") {
            init {
                addElement("iconID")
                addElement("iconFile")
                addElement("description")
            }
        }

        actual override fun serialize(output: Encoder, obj: eveicon) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.iconID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.iconFile.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.description.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): eveicon {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var id: Int? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> id =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    else -> if (i < descriptor.elementsCount) continue@loop else throw SerializationException("Unknown index $i")
                }
            }

            inp.endStructure(descriptor)
            if (id == null)
                throw SerializationException("Id 'iconID' @ index 0 not found")
            else
                return eveicon[id]
        }

        actual fun serializer(): KSerializer<eveicon> = this
    }

    // Database Columns

    actual val iconID by eveicons.iconID
    actual val iconFile by eveicons.iconFile
    actual val description by eveicons.description


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is eveicon)
            return false
        return iconID == other.iconID
    }


    actual override fun hashCode() = iconID


}

