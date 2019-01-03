
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.transactions.transaction

object stastationtypes : IntIdTable("stastationtypes", "stationTypeID") {
    // Database Columns

    val stationTypeID = integer("stationTypeID")//.primaryKey()
    val dockEntryX = double("dockEntryX")
    val dockEntryY = double("dockEntryY")
    val dockEntryZ = double("dockEntryZ")
    val dockOrientationX = double("dockOrientationX")
    val dockOrientationY = double("dockOrientationY")
    val dockOrientationZ = double("dockOrientationZ")
    val operationID = integer("operationID")
    val officeSlots = integer("officeSlots")
    val reprocessingEfficiency = double("reprocessingEfficiency")
    val conquerable = bool("conquerable")
}


@Serializable(with = stastationtype.Companion::class)
actual class stastationtype(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(stastationtype::class)
    actual companion object : IntEntityClass<stastationtype>(stastationtypes), KSerializer<stastationtype> {
        actual fun getItem(id: Int) = transaction { super.get(id) }
        actual fun allItems() = transaction { super.all().toList() }
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("stastationtype") {
            init {
                addElement("stationTypeID")
                addElement("dockEntryX")
                addElement("dockEntryY")
                addElement("dockEntryZ")
                addElement("dockOrientationX")
                addElement("dockOrientationY")
                addElement("dockOrientationZ")
                addElement("operationID")
                addElement("officeSlots")
                addElement("reprocessingEfficiency")
                addElement("conquerable")
            }
        }

        actual override fun serialize(output: Encoder, obj: stastationtype) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.stationTypeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.dockEntryX.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.dockEntryY.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.dockEntryZ.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                4,
                HexConverter.printHexBinary(obj.dockOrientationX.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                5,
                HexConverter.printHexBinary(obj.dockOrientationY.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                6,
                HexConverter.printHexBinary(obj.dockOrientationZ.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                7,
                HexConverter.printHexBinary(obj.operationID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                8,
                HexConverter.printHexBinary(obj.officeSlots.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                9,
                HexConverter.printHexBinary(obj.reprocessingEfficiency.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                10,
                HexConverter.printHexBinary(obj.conquerable.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): stastationtype {
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
                throw SerializationException("Id 'stationTypeID' @ index 0 not found")
            else
                return stastationtype[id]
        }

        actual fun serializer(): KSerializer<stastationtype> = this
    }

    // Database Columns

    actual val stationTypeID by stastationtypes.stationTypeID
    actual val dockEntryX by stastationtypes.dockEntryX
    actual val dockEntryY by stastationtypes.dockEntryY
    actual val dockEntryZ by stastationtypes.dockEntryZ
    actual val dockOrientationX by stastationtypes.dockOrientationX
    actual val dockOrientationY by stastationtypes.dockOrientationY
    actual val dockOrientationZ by stastationtypes.dockOrientationZ
    actual val operationID by stastationtypes.operationID
    actual val officeSlots by stastationtypes.officeSlots
    actual val reprocessingEfficiency by stastationtypes.reprocessingEfficiency
    actual val conquerable by stastationtypes.conquerable


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is stastationtype)
            return false
        return stationTypeID == other.stationTypeID
    }


    actual override fun hashCode() = stationTypeID


}

