
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.LongIdTable
import org.jetbrains.exposed.sql.transactions.transaction

object stastations : LongIdTable("stastations", "stationID") {
    // Database Columns

    val stationID = long("stationID").primaryKey()
    val security = double("security")
    val dockingCostPerVolume = double("dockingCostPerVolume")
    val maxShipVolumeDockable = double("maxShipVolumeDockable")
    val officeRentalCost = integer("officeRentalCost")
    val operationID = integer("operationID")
    val stationTypeID = integer("stationTypeID")
    val corporationID = integer("corporationID")
    val solarSystemID = integer("solarSystemID")
    val constellationID = integer("constellationID")
    val regionID = integer("regionID")
    val stationName = varchar("stationName", 100)
    val x = double("x")
    val y = double("y")
    val z = double("z")
    val reprocessingEfficiency = double("reprocessingEfficiency")
    val reprocessingStationsTake = double("reprocessingStationsTake")
    val reprocessingHangarFlag = integer("reprocessingHangarFlag")
}


@Serializable(with = stastation.Companion::class)
actual class stastation(val myId: EntityID<Long>) : LongEntity(myId) {

    @Serializer(stastation::class)
    actual companion object : LongEntityClass<stastation>(stastations), KSerializer<stastation> {
        actual fun getItem(id: Long) = transaction { super.get(id) }
        actual fun allItems() = transaction { super.all().toList() }
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("stastation") {
            init {
                addElement("stationID")
                addElement("security")
                addElement("dockingCostPerVolume")
                addElement("maxShipVolumeDockable")
                addElement("officeRentalCost")
                addElement("operationID")
                addElement("stationTypeID")
                addElement("corporationID")
                addElement("solarSystemID")
                addElement("constellationID")
                addElement("regionID")
                addElement("stationName")
                addElement("x")
                addElement("y")
                addElement("z")
                addElement("reprocessingEfficiency")
                addElement("reprocessingStationsTake")
                addElement("reprocessingHangarFlag")
            }
        }

        actual override fun serialize(output: Encoder, obj: stastation) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.stationID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.security.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.dockingCostPerVolume.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.maxShipVolumeDockable.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                4,
                HexConverter.printHexBinary(obj.officeRentalCost.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                5,
                HexConverter.printHexBinary(obj.operationID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                6,
                HexConverter.printHexBinary(obj.stationTypeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                7,
                HexConverter.printHexBinary(obj.corporationID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                8,
                HexConverter.printHexBinary(obj.solarSystemID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                9,
                HexConverter.printHexBinary(obj.constellationID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                10,
                HexConverter.printHexBinary(obj.regionID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                11,
                HexConverter.printHexBinary(obj.stationName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                12,
                HexConverter.printHexBinary(obj.x.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                13,
                HexConverter.printHexBinary(obj.y.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                14,
                HexConverter.printHexBinary(obj.z.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                15,
                HexConverter.printHexBinary(obj.reprocessingEfficiency.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                16,
                HexConverter.printHexBinary(obj.reprocessingStationsTake.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                17,
                HexConverter.printHexBinary(obj.reprocessingHangarFlag.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): stastation {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var id: Long? = null
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
                    ).toLong()
                    else -> if (i < descriptor.elementsCount) continue@loop else throw SerializationException("Unknown index $i")
                }
            }

            inp.endStructure(descriptor)
            if (id == null)
                throw SerializationException("Id 'stationID' @ index 0 not found")
            else
                return stastation[id]
        }

        actual fun serializer(): KSerializer<stastation> = this
    }

    // Database Columns

    actual val stationID by stastations.stationID
    actual val security by stastations.security
    actual val dockingCostPerVolume by stastations.dockingCostPerVolume
    actual val maxShipVolumeDockable by stastations.maxShipVolumeDockable
    actual val officeRentalCost by stastations.officeRentalCost
    actual val operationID by stastations.operationID
    actual val stationTypeID by stastations.stationTypeID
    actual val corporationID by stastations.corporationID
    actual val solarSystemID by stastations.solarSystemID
    actual val constellationID by stastations.constellationID
    actual val regionID by stastations.regionID
    actual val stationName by stastations.stationName
    actual val x by stastations.x
    actual val y by stastations.y
    actual val z by stastations.z
    actual val reprocessingEfficiency by stastations.reprocessingEfficiency
    actual val reprocessingStationsTake by stastations.reprocessingStationsTake
    actual val reprocessingHangarFlag by stastations.reprocessingHangarFlag


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is stastation)
            return false
        return stationID == other.stationID
    }


    actual override fun hashCode() = stationID.hashCode()


    actual override fun toString() = stationName
}

