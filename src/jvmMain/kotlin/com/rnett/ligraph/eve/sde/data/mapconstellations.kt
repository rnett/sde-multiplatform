
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

object mapconstellations : IntIdTable("mapconstellations", "constellationID") {
    // Database Columns

    val regionID = integer("regionID")
    val constellationID = integer("constellationID").primaryKey()
    val constellationName = varchar("constellationName", 100)
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


    // Foreign/Imported Keys (One to Many)

    val region = reference("regionID", mapregions)


    // Referencing/Exported Keys (One to Many)

    // 1 keys.  Not present in object
}


@Serializable(with = mapconstellation.Companion::class)
actual class mapconstellation(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(mapconstellation::class)
    actual companion object : IntEntityClass<mapconstellation>(mapconstellations), KSerializer<mapconstellation> {
        actual fun getItem(id: Int) = transaction { super.get(id) }
        actual fun allItems() = transaction { super.all().toList() }
        actual fun getRegion(item: mapconstellation): mapregion = transaction { item.region }
        actual fun getMapsolarsystems_rk(item: mapconstellation): List<mapsolarsystem> =
            transaction { item.mapsolarsystems_rk }

        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("mapconstellation") {
            init {
                addElement("regionID")
                addElement("constellationID")
                addElement("constellationName")
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

        actual override fun serialize(output: Encoder, obj: mapconstellation) {
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
                HexConverter.printHexBinary(obj.constellationName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.x.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                4,
                HexConverter.printHexBinary(obj.y.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                5,
                HexConverter.printHexBinary(obj.z.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                6,
                HexConverter.printHexBinary(obj.xMin.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                7,
                HexConverter.printHexBinary(obj.xMax.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                8,
                HexConverter.printHexBinary(obj.yMin.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                9,
                HexConverter.printHexBinary(obj.yMax.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                10,
                HexConverter.printHexBinary(obj.zMin.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                11,
                HexConverter.printHexBinary(obj.zMax.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                12,
                HexConverter.printHexBinary(obj.factionID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                13,
                HexConverter.printHexBinary(obj.radius.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): mapconstellation {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var id: Int? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    1 -> id = stringFromUtf8Bytes(
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
                throw SerializationException("Id 'constellationID' @ index 1 not found")
            else
                return mapconstellation[id]
        }

        actual fun serializer(): KSerializer<mapconstellation> = this
    }

    // Database Columns

    actual val regionID by mapconstellations.regionID
    actual val constellationID by mapconstellations.constellationID
    actual val constellationName by mapconstellations.constellationName
    actual val x by mapconstellations.x
    actual val y by mapconstellations.y
    actual val z by mapconstellations.z
    actual val xMin by mapconstellations.xMin
    actual val xMax by mapconstellations.xMax
    actual val yMin by mapconstellations.yMin
    actual val yMax by mapconstellations.yMax
    actual val zMin by mapconstellations.zMin
    actual val zMax by mapconstellations.zMax
    actual val factionID by mapconstellations.factionID
    actual val radius by mapconstellations.radius


    // Foreign/Imported Keys (One to Many)

    actual val region: mapregion by mapregion referencedOn mapconstellations.region


    // Referencing/Exported Keys (One to Many)

    val _mapsolarsystems_rk: SizedIterable<mapsolarsystem> by mapsolarsystem referrersOn mapsolarsystems.constellation_fk
    actual val mapsolarsystems_rk: List<mapsolarsystem> get() = _mapsolarsystems_rk.toList()


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is mapconstellation)
            return false
        return constellationID == other.constellationID
    }


    actual override fun hashCode() = constellationID


    actual override fun toString() = constellationName
}

