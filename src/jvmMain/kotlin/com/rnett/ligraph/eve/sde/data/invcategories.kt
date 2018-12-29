
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.SizedIterable
import org.jetbrains.exposed.sql.transactions.transaction

object invcategories : IntIdTable("invcategories", "categoryID") {
    // Database Columns

    val categoryID = integer("categoryID").primaryKey()
    val categoryName = varchar("categoryName", 100)
    val iconID = integer("iconID")
    val published = bool("published")


    // Referencing/Exported Keys (One to Many)

    // 1 keys.  Not present in object
}



actual class invcategory(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(invcategory::class)
    actual companion object : IntEntityClass<invcategory>(invcategories), KSerializer<invcategory> {
        actual fun getItem(id: Int) = transaction { super.get(id) }
        actual fun allItems() = transaction { super.all().toList() }
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
                throw SerializationException("Id 'categoryID' @ index 0 not found")
            else
                return invcategory[id]
        }

        actual fun serializer(): KSerializer<invcategory> = this
    }

    // Database Columns

    actual val categoryID by invcategories.categoryID
    actual val categoryName by invcategories.categoryName
    actual val iconID by invcategories.iconID
    actual val published by invcategories.published


    // Referencing/Exported Keys (One to Many)

    val invgroups_rk: SizedIterable<invgroup> by invgroup referrersOn invgroups.category


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is invcategory)
            return false
        return categoryID == other.categoryID
    }


    actual override fun hashCode() = categoryID


    actual override fun toString() = categoryName
}

