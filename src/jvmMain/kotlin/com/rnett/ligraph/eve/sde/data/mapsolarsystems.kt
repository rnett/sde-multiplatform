
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.transactions.transaction

object mapsolarsystems : IntIdTable("mapsolarsystems", "solarSystemID") {
    // Database Columns

    val regionID = integer("regionID")
    val constellationID = integer("constellationID")
    val solarSystemID = integer("solarSystemID").primaryKey()
    val solarSystemName = varchar("solarSystemName", 100)
    val x = double("x")
    val y = double("y")
    val z = double("z")
    val xMin = double("xMin")
    val xMax = double("xMax")
    val yMin = double("yMin")
    val yMax = double("yMax")
    val zMin = double("zMin")
    val zMax = double("zMax")
    val luminosity = double("luminosity")
    val border = bool("border")
    val fringe = bool("fringe")
    val corridor = bool("corridor")
    val hub = bool("hub")
    val international = bool("international")
    val regional = bool("regional")
    val constellation = bool("constellation")
    val security = double("security")
    val factionID = integer("factionID")
    val radius = double("radius")
    val sunTypeID = integer("sunTypeID")
    val securityClass = varchar("securityClass", 2)


    // Foreign/Imported Keys (One to Many)

    val constellation_fk = reference("constellationID", mapconstellations)
    val region = reference("regionID", mapregions)
}



actual class mapsolarsystem(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(mapsolarsystem::class)
    actual companion object : IntEntityClass<mapsolarsystem>(mapsolarsystems), KSerializer<mapsolarsystem> {
        actual fun getItem(id: Int) = transaction { super.get(id) }
        actual fun allItems() = transaction { super.all().toList() }
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("mapsolarsystem") {
            init {
                addElement("regionID")
                addElement("constellationID")
                addElement("solarSystemID")
                addElement("solarSystemName")
                addElement("x")
                addElement("y")
                addElement("z")
                addElement("xMin")
                addElement("xMax")
                addElement("yMin")
                addElement("yMax")
                addElement("zMin")
                addElement("zMax")
                addElement("luminosity")
                addElement("border")
                addElement("fringe")
                addElement("corridor")
                addElement("hub")
                addElement("international")
                addElement("regional")
                addElement("constellation")
                addElement("security")
                addElement("factionID")
                addElement("radius")
                addElement("sunTypeID")
                addElement("securityClass")
            }
        }

        actual override fun serialize(output: Encoder, obj: mapsolarsystem) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.regionID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.constellationID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.solarSystemID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.solarSystemName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                4,
                HexConverter.printHexBinary(obj.x.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                5,
                HexConverter.printHexBinary(obj.y.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                6,
                HexConverter.printHexBinary(obj.z.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                7,
                HexConverter.printHexBinary(obj.xMin.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                8,
                HexConverter.printHexBinary(obj.xMax.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                9,
                HexConverter.printHexBinary(obj.yMin.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                10,
                HexConverter.printHexBinary(obj.yMax.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                11,
                HexConverter.printHexBinary(obj.zMin.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                12,
                HexConverter.printHexBinary(obj.zMax.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                13,
                HexConverter.printHexBinary(obj.luminosity.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                14,
                HexConverter.printHexBinary(obj.border.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                15,
                HexConverter.printHexBinary(obj.fringe.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                16,
                HexConverter.printHexBinary(obj.corridor.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                17,
                HexConverter.printHexBinary(obj.hub.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                18,
                HexConverter.printHexBinary(obj.international.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                19,
                HexConverter.printHexBinary(obj.regional.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                20,
                HexConverter.printHexBinary(obj.constellation.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                21,
                HexConverter.printHexBinary(obj.security.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                22,
                HexConverter.printHexBinary(obj.factionID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                23,
                HexConverter.printHexBinary(obj.radius.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                24,
                HexConverter.printHexBinary(obj.sunTypeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                25,
                HexConverter.printHexBinary(obj.securityClass.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): mapsolarsystem {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var id: Int? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    2 -> id =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    else -> if (i < descriptor.elementsCount) continue@loop else throw SerializationException("Unknown index $i")
                }
            }

            inp.endStructure(descriptor)
            if (id == null)
                throw SerializationException("Id 'solarSystemID' @ index 2 not found")
            else
                return mapsolarsystem[id]
        }

        actual fun serializer(): KSerializer<mapsolarsystem> = this
    }

    // Database Columns

    actual val regionID by mapsolarsystems.regionID
    actual val constellationID by mapsolarsystems.constellationID
    actual val solarSystemID by mapsolarsystems.solarSystemID
    actual val solarSystemName by mapsolarsystems.solarSystemName
    actual val x by mapsolarsystems.x
    actual val y by mapsolarsystems.y
    actual val z by mapsolarsystems.z
    actual val xMin by mapsolarsystems.xMin
    actual val xMax by mapsolarsystems.xMax
    actual val yMin by mapsolarsystems.yMin
    actual val yMax by mapsolarsystems.yMax
    actual val zMin by mapsolarsystems.zMin
    actual val zMax by mapsolarsystems.zMax
    actual val luminosity by mapsolarsystems.luminosity
    actual val border by mapsolarsystems.border
    actual val fringe by mapsolarsystems.fringe
    actual val corridor by mapsolarsystems.corridor
    actual val hub by mapsolarsystems.hub
    actual val international by mapsolarsystems.international
    actual val regional by mapsolarsystems.regional
    actual val constellation by mapsolarsystems.constellation
    actual val security by mapsolarsystems.security
    actual val factionID by mapsolarsystems.factionID
    actual val radius by mapsolarsystems.radius
    actual val sunTypeID by mapsolarsystems.sunTypeID
    actual val securityClass by mapsolarsystems.securityClass


    // Foreign/Imported Keys (One to Many)

    val constellation_fk: mapconstellation by mapconstellation referencedOn mapsolarsystems.constellation_fk
    val region: mapregion by mapregion referencedOn mapsolarsystems.region


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is mapsolarsystem)
            return false
        return solarSystemID == other.solarSystemID
    }


    actual override fun hashCode() = solarSystemID


    actual override fun toString() = solarSystemName
}

