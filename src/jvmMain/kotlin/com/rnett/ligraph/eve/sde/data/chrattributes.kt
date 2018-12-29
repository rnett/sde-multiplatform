
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.transactions.transaction

object chrattributes : IntIdTable("chrattributes", "attributeID") {
    // Database Columns

    val attributeID = integer("attributeID").primaryKey()
    val attributeName = varchar("attributeName", 100)
    val description = varchar("description", 1000)
    val iconID = integer("iconID")
    val shortDescription = varchar("shortDescription", 500)
    val notes = varchar("notes", 500)
}


@Serializable(with = chrattribute.Companion::class)
actual class chrattribute(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(chrattribute::class)
    actual companion object : IntEntityClass<chrattribute>(chrattributes), KSerializer<chrattribute> {
        actual fun getItem(id: Int) = transaction { super.get(id) }
        actual fun allItems() = transaction { super.all().toList() }
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("chrattribute") {
            init {
                addElement("attributeID")
                addElement("attributeName")
                addElement("description")
                addElement("iconID")
                addElement("shortDescription")
                addElement("notes")
            }
        }

        actual override fun serialize(output: Encoder, obj: chrattribute) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.attributeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.attributeName.toString().toUtf8Bytes())
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
            compositeOutput.encodeStringElement(
                descriptor,
                4,
                HexConverter.printHexBinary(obj.shortDescription.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                5,
                HexConverter.printHexBinary(obj.notes.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): chrattribute {
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
                throw SerializationException("Id 'attributeID' @ index 0 not found")
            else
                return chrattribute[id]
        }

        actual fun serializer(): KSerializer<chrattribute> = this
    }

    // Database Columns

    actual val attributeID by chrattributes.attributeID
    actual val attributeName by chrattributes.attributeName
    actual val description by chrattributes.description
    actual val iconID by chrattributes.iconID
    actual val shortDescription by chrattributes.shortDescription
    actual val notes by chrattributes.notes


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is chrattribute)
            return false
        return attributeID == other.attributeID
    }


    actual override fun hashCode() = attributeID


    actual override fun toString() = attributeName
}

