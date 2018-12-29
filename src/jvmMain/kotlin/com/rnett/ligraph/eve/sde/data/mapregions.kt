
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

object mapregions : IntIdTable("mapregions", "regionID") {
    // Database Columns

    val regionID = integer("regionID").primaryKey()
    val regionName = varchar("regionName", 100)
    val x = double("x")
    val y = double("y")
    val z = double("z")
    val xMin = double("xMin")
    val xMax = double("xMax")
    val yMin = double("yMin")
    val yMax = double("yMax")
    val zMin = double("zMin")
    val zMax = double("zMax")
    val factionID = integer("factionID")
    val radius = double("radius")


    // Referencing/Exported Keys (One to Many)

    // 2 keys.  Not present in object
}


@Serializable(with = mapregion.Companion::class)
actual class mapregion(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(mapregion::class)
    actual companion object : IntEntityClass<mapregion>(mapregions), KSerializer<mapregion> {
        actual fun getItem(id: Int) = transaction { super.get(id) }
        actual fun allItems() = transaction { super.all().toList() }
        actual fun getMapconstellatia(item: mapregion): List<mapconstellation> = transaction { item.mapconstellatia }
        actual fun getMapsolarsystems_rk(item: mapregion): List<mapsolarsystem> =
            transaction { item.mapsolarsystems_rk }

        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("mapregion") {
            init {
                addElement("regionID")
                addElement("regionName")
                addElement("x")
                addElement("y")
                addElement("z")
                addElement("xMin")
                addElement("xMax")
                addElement("yMin")
                addElement("yMax")
                addElement("zMin")
                addElement("zMax")
                addElement("factionID")
                addElement("radius")
            }
        }

        actual override fun serialize(output: Encoder, obj: mapregion) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.regionID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.regionName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.x.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.y.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                4,
                HexConverter.printHexBinary(obj.z.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                5,
                HexConverter.printHexBinary(obj.xMin.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                6,
                HexConverter.printHexBinary(obj.xMax.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                7,
                HexConverter.printHexBinary(obj.yMin.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                8,
                HexConverter.printHexBinary(obj.yMax.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                9,
                HexConverter.printHexBinary(obj.zMin.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                10,
                HexConverter.printHexBinary(obj.zMax.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                11,
                HexConverter.printHexBinary(obj.factionID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                12,
                HexConverter.printHexBinary(obj.radius.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): mapregion {
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
                throw SerializationException("Id 'regionID' @ index 0 not found")
            else
                return mapregion[id]
        }

        actual fun serializer(): KSerializer<mapregion> = this
    }

    // Database Columns

    actual val regionID by mapregions.regionID
    actual val regionName by mapregions.regionName
    actual val x by mapregions.x
    actual val y by mapregions.y
    actual val z by mapregions.z
    actual val xMin by mapregions.xMin
    actual val xMax by mapregions.xMax
    actual val yMin by mapregions.yMin
    actual val yMax by mapregions.yMax
    actual val zMin by mapregions.zMin
    actual val zMax by mapregions.zMax
    actual val factionID by mapregions.factionID
    actual val radius by mapregions.radius


    // Referencing/Exported Keys (One to Many)

    val _mapconstellatia: SizedIterable<mapconstellation> by mapconstellation referrersOn mapconstellations.region
    actual val mapconstellatia: List<mapconstellation> get() = _mapconstellatia.toList()

    val _mapsolarsystems_rk: SizedIterable<mapsolarsystem> by mapsolarsystem referrersOn mapsolarsystems.region
    actual val mapsolarsystems_rk: List<mapsolarsystem> get() = _mapsolarsystems_rk.toList()


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is mapregion)
            return false
        return regionID == other.regionID
    }


    actual override fun hashCode() = regionID


    actual override fun toString() = regionName
}

