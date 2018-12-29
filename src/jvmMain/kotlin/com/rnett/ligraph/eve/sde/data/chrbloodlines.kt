
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.transactions.transaction

object chrbloodlines : IntIdTable("chrbloodlines", "bloodlineID") {
    // Database Columns

    val bloodlineID = integer("bloodlineID").primaryKey()
    val bloodlineName = varchar("bloodlineName", 100)
    val raceID = integer("raceID")
    val description = varchar("description", 1000)
    val maleDescription = varchar("maleDescription", 1000)
    val femaleDescription = varchar("femaleDescription", 1000)
    val shipTypeID = integer("shipTypeID")
    val corporationID = integer("corporationID")
    val perception = integer("perception")
    val willpower = integer("willpower")
    val charisma = integer("charisma")
    val memory = integer("memory")
    val intelligence = integer("intelligence")
    val iconID = integer("iconID")
    val shortDescription = varchar("shortDescription", 500)
    val shortMaleDescription = varchar("shortMaleDescription", 500)
    val shortFemaleDescription = varchar("shortFemaleDescription", 500)
}


@Serializable(with = chrbloodline.Companion::class)
actual class chrbloodline(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(chrbloodline::class)
    actual companion object : IntEntityClass<chrbloodline>(chrbloodlines), KSerializer<chrbloodline> {
        actual fun getItem(id: Int) = transaction { super.get(id) }
        actual fun allItems() = transaction { super.all().toList() }
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("chrbloodline") {
            init {
                addElement("bloodlineID")
                addElement("bloodlineName")
                addElement("raceID")
                addElement("description")
                addElement("maleDescription")
                addElement("femaleDescription")
                addElement("shipTypeID")
                addElement("corporationID")
                addElement("perception")
                addElement("willpower")
                addElement("charisma")
                addElement("memory")
                addElement("intelligence")
                addElement("iconID")
                addElement("shortDescription")
                addElement("shortMaleDescription")
                addElement("shortFemaleDescription")
            }
        }

        actual override fun serialize(output: Encoder, obj: chrbloodline) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.bloodlineID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.bloodlineName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.raceID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.description.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                4,
                HexConverter.printHexBinary(obj.maleDescription.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                5,
                HexConverter.printHexBinary(obj.femaleDescription.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                6,
                HexConverter.printHexBinary(obj.shipTypeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                7,
                HexConverter.printHexBinary(obj.corporationID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                8,
                HexConverter.printHexBinary(obj.perception.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                9,
                HexConverter.printHexBinary(obj.willpower.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                10,
                HexConverter.printHexBinary(obj.charisma.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                11,
                HexConverter.printHexBinary(obj.memory.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                12,
                HexConverter.printHexBinary(obj.intelligence.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                13,
                HexConverter.printHexBinary(obj.iconID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                14,
                HexConverter.printHexBinary(obj.shortDescription.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                15,
                HexConverter.printHexBinary(obj.shortMaleDescription.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                16,
                HexConverter.printHexBinary(obj.shortFemaleDescription.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): chrbloodline {
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
                throw SerializationException("Id 'bloodlineID' @ index 0 not found")
            else
                return chrbloodline[id]
        }

        actual fun serializer(): KSerializer<chrbloodline> = this
    }

    // Database Columns

    actual val bloodlineID by chrbloodlines.bloodlineID
    actual val bloodlineName by chrbloodlines.bloodlineName
    actual val raceID by chrbloodlines.raceID
    actual val description by chrbloodlines.description
    actual val maleDescription by chrbloodlines.maleDescription
    actual val femaleDescription by chrbloodlines.femaleDescription
    actual val shipTypeID by chrbloodlines.shipTypeID
    actual val corporationID by chrbloodlines.corporationID
    actual val perception by chrbloodlines.perception
    actual val willpower by chrbloodlines.willpower
    actual val charisma by chrbloodlines.charisma
    actual val memory by chrbloodlines.memory
    actual val intelligence by chrbloodlines.intelligence
    actual val iconID by chrbloodlines.iconID
    actual val shortDescription by chrbloodlines.shortDescription
    actual val shortMaleDescription by chrbloodlines.shortMaleDescription
    actual val shortFemaleDescription by chrbloodlines.shortFemaleDescription


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is chrbloodline)
            return false
        return bloodlineID == other.bloodlineID
    }


    actual override fun hashCode() = bloodlineID


    actual override fun toString() = bloodlineName
}

