
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.transactions.transaction

object chrancestries : IntIdTable("chrancestries", "ancestryID") {
    // Database Columns

    val ancestryID = integer("ancestryID").primaryKey()
    val ancestryName = varchar("ancestryName", 100)
    val bloodlineID = integer("bloodlineID")
    val description = varchar("description", 1000)
    val perception = integer("perception")
    val willpower = integer("willpower")
    val charisma = integer("charisma")
    val memory = integer("memory")
    val intelligence = integer("intelligence")
    val iconID = integer("iconID")
    val shortDescription = varchar("shortDescription", 500)
}



actual class chrancestry(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(chrancestry::class)
    actual companion object : IntEntityClass<chrancestry>(chrancestries), KSerializer<chrancestry> {
        actual fun getItem(id: Int) = transaction { super.get(id) }
        actual fun allItems() = transaction { super.all().toList() }
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("chrancestry") {
            init {
                addElement("ancestryID")
                addElement("ancestryName")
                addElement("bloodlineID")
                addElement("description")
                addElement("perception")
                addElement("willpower")
                addElement("charisma")
                addElement("memory")
                addElement("intelligence")
                addElement("iconID")
                addElement("shortDescription")
            }
        }

        actual override fun serialize(output: Encoder, obj: chrancestry) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.ancestryID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.ancestryName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.bloodlineID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.description.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                4,
                HexConverter.printHexBinary(obj.perception.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                5,
                HexConverter.printHexBinary(obj.willpower.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                6,
                HexConverter.printHexBinary(obj.charisma.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                7,
                HexConverter.printHexBinary(obj.memory.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                8,
                HexConverter.printHexBinary(obj.intelligence.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                9,
                HexConverter.printHexBinary(obj.iconID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                10,
                HexConverter.printHexBinary(obj.shortDescription.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): chrancestry {
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
                throw SerializationException("Id 'ancestryID' @ index 0 not found")
            else
                return chrancestry[id]
        }

        actual fun serializer(): KSerializer<chrancestry> = this
    }

    // Database Columns

    actual val ancestryID by chrancestries.ancestryID
    actual val ancestryName by chrancestries.ancestryName
    actual val bloodlineID by chrancestries.bloodlineID
    actual val description by chrancestries.description
    actual val perception by chrancestries.perception
    actual val willpower by chrancestries.willpower
    actual val charisma by chrancestries.charisma
    actual val memory by chrancestries.memory
    actual val intelligence by chrancestries.intelligence
    actual val iconID by chrancestries.iconID
    actual val shortDescription by chrancestries.shortDescription


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is chrancestry)
            return false
        return ancestryID == other.ancestryID
    }


    actual override fun hashCode() = ancestryID


    actual override fun toString() = ancestryName
}

