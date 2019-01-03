
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.transactions.transaction

object staoperations : IntIdTable("staoperations", "operationID") {
    // Database Columns

    val activityID = integer("activityID")
    val operationID = integer("operationID")//.primaryKey()
    val operationName = varchar("operationName", 100)
    val description = varchar("description", 1000)
    val fringe = integer("fringe")
    val corridor = integer("corridor")
    val hub = integer("hub")
    val border = integer("border")
    val ratio = integer("ratio")
    val caldariStationTypeID = integer("caldariStationTypeID")
    val minmatarStationTypeID = integer("minmatarStationTypeID")
    val amarrStationTypeID = integer("amarrStationTypeID")
    val gallenteStationTypeID = integer("gallenteStationTypeID")
    val joveStationTypeID = integer("joveStationTypeID")
}


@Serializable(with = staoperation.Companion::class)
actual class staoperation(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(staoperation::class)
    actual companion object : IntEntityClass<staoperation>(staoperations), KSerializer<staoperation> {
        actual fun getItem(id: Int) = transaction { super.get(id) }
        actual fun allItems() = transaction { super.all().toList() }
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("staoperation") {
            init {
                addElement("activityID")
                addElement("operationID")
                addElement("operationName")
                addElement("description")
                addElement("fringe")
                addElement("corridor")
                addElement("hub")
                addElement("border")
                addElement("ratio")
                addElement("caldariStationTypeID")
                addElement("minmatarStationTypeID")
                addElement("amarrStationTypeID")
                addElement("gallenteStationTypeID")
                addElement("joveStationTypeID")
            }
        }

        actual override fun serialize(output: Encoder, obj: staoperation) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.activityID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.operationID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.operationName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.description.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                4,
                HexConverter.printHexBinary(obj.fringe.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                5,
                HexConverter.printHexBinary(obj.corridor.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                6,
                HexConverter.printHexBinary(obj.hub.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                7,
                HexConverter.printHexBinary(obj.border.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                8,
                HexConverter.printHexBinary(obj.ratio.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                9,
                HexConverter.printHexBinary(obj.caldariStationTypeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                10,
                HexConverter.printHexBinary(obj.minmatarStationTypeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                11,
                HexConverter.printHexBinary(obj.amarrStationTypeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                12,
                HexConverter.printHexBinary(obj.gallenteStationTypeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                13,
                HexConverter.printHexBinary(obj.joveStationTypeID.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): staoperation {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var id: Int? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    1 -> id =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    else -> if (i < descriptor.elementsCount) continue@loop else throw SerializationException("Unknown index $i")
                }
            }

            inp.endStructure(descriptor)
            if (id == null)
                throw SerializationException("Id 'operationID' @ index 1 not found")
            else
                return staoperation[id]
        }

        actual fun serializer(): KSerializer<staoperation> = this
    }

    // Database Columns

    actual val activityID by staoperations.activityID
    actual val operationID by staoperations.operationID
    actual val operationName by staoperations.operationName
    actual val description by staoperations.description
    actual val fringe by staoperations.fringe
    actual val corridor by staoperations.corridor
    actual val hub by staoperations.hub
    actual val border by staoperations.border
    actual val ratio by staoperations.ratio
    actual val caldariStationTypeID by staoperations.caldariStationTypeID
    actual val minmatarStationTypeID by staoperations.minmatarStationTypeID
    actual val amarrStationTypeID by staoperations.amarrStationTypeID
    actual val gallenteStationTypeID by staoperations.gallenteStationTypeID
    actual val joveStationTypeID by staoperations.joveStationTypeID


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is staoperation)
            return false
        return operationID == other.operationID
    }


    actual override fun hashCode() = operationID


    actual override fun toString() = operationName
}

