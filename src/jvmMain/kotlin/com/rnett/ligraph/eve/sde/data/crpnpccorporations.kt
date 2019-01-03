
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.transactions.transaction

object crpnpccorporations : IntIdTable("crpnpccorporations", "corporationID") {
    // Database Columns

    val corporationID = integer("corporationID")//.primaryKey()
    val size = char("size")
    val extent = char("extent")
    val solarSystemID = integer("solarSystemID")
    val investorID1 = integer("investorID1")
    val investorShares1 = integer("investorShares1")
    val investorID2 = integer("investorID2")
    val investorShares2 = integer("investorShares2")
    val investorID3 = integer("investorID3")
    val investorShares3 = integer("investorShares3")
    val investorID4 = integer("investorID4")
    val investorShares4 = integer("investorShares4")
    val friendID = integer("friendID")
    val enemyID = integer("enemyID")
    val publicShares = integer("publicShares")
    val initialPrice = integer("initialPrice")
    val minSecurity = double("minSecurity")
    val scattered = bool("scattered")
    val fringe = integer("fringe")
    val corridor = integer("corridor")
    val hub = integer("hub")
    val border = integer("border")
    val factionID = integer("factionID")
    val sizeFactor = double("sizeFactor")
    val stationCount = integer("stationCount")
    val stationSystemCount = integer("stationSystemCount")
    val description = varchar("description", 4000)
    val iconID = integer("iconID")
}


@Serializable(with = crpnpccorporation.Companion::class)
actual class crpnpccorporation(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(crpnpccorporation::class)
    actual companion object : IntEntityClass<crpnpccorporation>(crpnpccorporations), KSerializer<crpnpccorporation> {
        actual fun getItem(id: Int) = transaction { super.get(id) }
        actual fun allItems() = transaction { super.all().toList() }
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("crpnpccorporation") {
            init {
                addElement("corporationID")
                addElement("size")
                addElement("extent")
                addElement("solarSystemID")
                addElement("investorID1")
                addElement("investorShares1")
                addElement("investorID2")
                addElement("investorShares2")
                addElement("investorID3")
                addElement("investorShares3")
                addElement("investorID4")
                addElement("investorShares4")
                addElement("friendID")
                addElement("enemyID")
                addElement("publicShares")
                addElement("initialPrice")
                addElement("minSecurity")
                addElement("scattered")
                addElement("fringe")
                addElement("corridor")
                addElement("hub")
                addElement("border")
                addElement("factionID")
                addElement("sizeFactor")
                addElement("stationCount")
                addElement("stationSystemCount")
                addElement("description")
                addElement("iconID")
            }
        }

        actual override fun serialize(output: Encoder, obj: crpnpccorporation) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.corporationID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.size.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.extent.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.solarSystemID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                4,
                HexConverter.printHexBinary(obj.investorID1.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                5,
                HexConverter.printHexBinary(obj.investorShares1.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                6,
                HexConverter.printHexBinary(obj.investorID2.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                7,
                HexConverter.printHexBinary(obj.investorShares2.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                8,
                HexConverter.printHexBinary(obj.investorID3.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                9,
                HexConverter.printHexBinary(obj.investorShares3.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                10,
                HexConverter.printHexBinary(obj.investorID4.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                11,
                HexConverter.printHexBinary(obj.investorShares4.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                12,
                HexConverter.printHexBinary(obj.friendID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                13,
                HexConverter.printHexBinary(obj.enemyID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                14,
                HexConverter.printHexBinary(obj.publicShares.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                15,
                HexConverter.printHexBinary(obj.initialPrice.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                16,
                HexConverter.printHexBinary(obj.minSecurity.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                17,
                HexConverter.printHexBinary(obj.scattered.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                18,
                HexConverter.printHexBinary(obj.fringe.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                19,
                HexConverter.printHexBinary(obj.corridor.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                20,
                HexConverter.printHexBinary(obj.hub.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                21,
                HexConverter.printHexBinary(obj.border.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                22,
                HexConverter.printHexBinary(obj.factionID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                23,
                HexConverter.printHexBinary(obj.sizeFactor.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                24,
                HexConverter.printHexBinary(obj.stationCount.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                25,
                HexConverter.printHexBinary(obj.stationSystemCount.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                26,
                HexConverter.printHexBinary(obj.description.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                27,
                HexConverter.printHexBinary(obj.iconID.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): crpnpccorporation {
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
                throw SerializationException("Id 'corporationID' @ index 0 not found")
            else
                return crpnpccorporation[id]
        }

        actual fun serializer(): KSerializer<crpnpccorporation> = this
    }

    // Database Columns

    actual val corporationID by crpnpccorporations.corporationID
    actual val size by crpnpccorporations.size
    actual val extent by crpnpccorporations.extent
    actual val solarSystemID by crpnpccorporations.solarSystemID
    actual val investorID1 by crpnpccorporations.investorID1
    actual val investorShares1 by crpnpccorporations.investorShares1
    actual val investorID2 by crpnpccorporations.investorID2
    actual val investorShares2 by crpnpccorporations.investorShares2
    actual val investorID3 by crpnpccorporations.investorID3
    actual val investorShares3 by crpnpccorporations.investorShares3
    actual val investorID4 by crpnpccorporations.investorID4
    actual val investorShares4 by crpnpccorporations.investorShares4
    actual val friendID by crpnpccorporations.friendID
    actual val enemyID by crpnpccorporations.enemyID
    actual val publicShares by crpnpccorporations.publicShares
    actual val initialPrice by crpnpccorporations.initialPrice
    actual val minSecurity by crpnpccorporations.minSecurity
    actual val scattered by crpnpccorporations.scattered
    actual val fringe by crpnpccorporations.fringe
    actual val corridor by crpnpccorporations.corridor
    actual val hub by crpnpccorporations.hub
    actual val border by crpnpccorporations.border
    actual val factionID by crpnpccorporations.factionID
    actual val sizeFactor by crpnpccorporations.sizeFactor
    actual val stationCount by crpnpccorporations.stationCount
    actual val stationSystemCount by crpnpccorporations.stationSystemCount
    actual val description by crpnpccorporations.description
    actual val iconID by crpnpccorporations.iconID


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is crpnpccorporation)
            return false
        return corporationID == other.corporationID
    }


    actual override fun hashCode() = corporationID


}

