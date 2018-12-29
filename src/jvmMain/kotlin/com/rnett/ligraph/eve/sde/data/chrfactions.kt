
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.transactions.transaction

object chrfactions : IntIdTable("chrfactions", "factionID") {
    // Database Columns

    val factionID = integer("factionID").primaryKey()
    val factionName = varchar("factionName", 100)
    val description = varchar("description", 1000)
    val raceIDs = integer("raceIDs")
    val solarSystemID = integer("solarSystemID")
    val corporationID = integer("corporationID")
    val sizeFactor = double("sizeFactor")
    val stationCount = integer("stationCount")
    val stationSystemCount = integer("stationSystemCount")
    val militiaCorporationID = integer("militiaCorporationID")
    val iconID = integer("iconID")
}


@Serializable(with = chrfaction.Companion::class)
actual class chrfaction(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(chrfaction::class)
    actual companion object : IntEntityClass<chrfaction>(chrfactions), KSerializer<chrfaction> {
        actual fun getItem(id: Int) = transaction { super.get(id) }
        actual fun allItems() = transaction { super.all().toList() }
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("chrfaction") {
            init {
                addElement("factionID")
                addElement("factionName")
                addElement("description")
                addElement("raceIDs")
                addElement("solarSystemID")
                addElement("corporationID")
                addElement("sizeFactor")
                addElement("stationCount")
                addElement("stationSystemCount")
                addElement("militiaCorporationID")
                addElement("iconID")
            }
        }

        actual override fun serialize(output: Encoder, obj: chrfaction) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.factionID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.factionName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.description.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.raceIDs.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                4,
                HexConverter.printHexBinary(obj.solarSystemID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                5,
                HexConverter.printHexBinary(obj.corporationID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                6,
                HexConverter.printHexBinary(obj.sizeFactor.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                7,
                HexConverter.printHexBinary(obj.stationCount.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                8,
                HexConverter.printHexBinary(obj.stationSystemCount.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                9,
                HexConverter.printHexBinary(obj.militiaCorporationID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                10,
                HexConverter.printHexBinary(obj.iconID.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): chrfaction {
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
                throw SerializationException("Id 'factionID' @ index 0 not found")
            else
                return chrfaction[id]
        }

        actual fun serializer(): KSerializer<chrfaction> = this
    }

    // Database Columns

    actual val factionID by chrfactions.factionID
    actual val factionName by chrfactions.factionName
    actual val description by chrfactions.description
    actual val raceIDs by chrfactions.raceIDs
    actual val solarSystemID by chrfactions.solarSystemID
    actual val corporationID by chrfactions.corporationID
    actual val sizeFactor by chrfactions.sizeFactor
    actual val stationCount by chrfactions.stationCount
    actual val stationSystemCount by chrfactions.stationSystemCount
    actual val militiaCorporationID by chrfactions.militiaCorporationID
    actual val iconID by chrfactions.iconID


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is chrfaction)
            return false
        return factionID == other.factionID
    }


    actual override fun hashCode() = factionID


    actual override fun toString() = factionName
}

