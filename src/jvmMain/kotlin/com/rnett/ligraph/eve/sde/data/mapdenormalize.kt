package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable

object mapdenormalizes : IntIdTable("mapdenormalize", "itemID") {
    // Database Columns

    val itemID = integer("itemID").primaryKey()
    val typeID = integer("typeID")
    val groupID = integer("groupID")
    val solarSystemID = integer("solarSystemID")
    val constellationID = integer("constellationID")
    val regionID = integer("regionID")
    val orbitID = integer("orbitID")
    val x = double("x")
    val y = double("y")
    val z = double("z")
    val radius = double("radius")
    val itemName = varchar("itemName", 100)
    val security = double("security")
    val celestialIndex = integer("celestialIndex")
    val orbitIndex = integer("orbitIndex")
}


actual class mapdenormalize(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(mapdenormalize::class)
    actual companion object : IntEntityClass<mapdenormalize>(mapdenormalizes), KSerializer<mapdenormalize> {
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("mapdenormalize") {
            init {
                addElement("itemID")
                addElement("typeID")
                addElement("groupID")
                addElement("solarSystemID")
                addElement("constellationID")
                addElement("regionID")
                addElement("orbitID")
                addElement("x")
                addElement("y")
                addElement("z")
                addElement("radius")
                addElement("itemName")
                addElement("security")
                addElement("celestialIndex")
                addElement("orbitIndex")
            }
        }

        actual override fun serialize(output: Encoder, obj: mapdenormalize) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.itemID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.typeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.groupID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.solarSystemID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                4,
                HexConverter.printHexBinary(obj.constellationID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                5,
                HexConverter.printHexBinary(obj.regionID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                6,
                HexConverter.printHexBinary(obj.orbitID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                7,
                HexConverter.printHexBinary(obj.x.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                8,
                HexConverter.printHexBinary(obj.y.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                9,
                HexConverter.printHexBinary(obj.z.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                10,
                HexConverter.printHexBinary(obj.radius.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                11,
                HexConverter.printHexBinary(obj.itemName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                12,
                HexConverter.printHexBinary(obj.security.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                13,
                HexConverter.printHexBinary(obj.celestialIndex.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                14,
                HexConverter.printHexBinary(obj.orbitIndex.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): mapdenormalize {
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
                throw SerializationException("Id 'itemID' @ index 0 not found")
            else
                return mapdenormalize[id]
        }

        actual fun serializer(): KSerializer<mapdenormalize> = this
    }

    // Database Columns

    actual val itemID by mapdenormalizes.itemID
    actual val typeID by mapdenormalizes.typeID
    actual val groupID by mapdenormalizes.groupID
    actual val solarSystemID by mapdenormalizes.solarSystemID
    actual val constellationID by mapdenormalizes.constellationID
    actual val regionID by mapdenormalizes.regionID
    actual val orbitID by mapdenormalizes.orbitID
    actual val x by mapdenormalizes.x
    actual val y by mapdenormalizes.y
    actual val z by mapdenormalizes.z
    actual val radius by mapdenormalizes.radius
    actual val itemName by mapdenormalizes.itemName
    actual val security by mapdenormalizes.security
    actual val celestialIndex by mapdenormalizes.celestialIndex
    actual val orbitIndex by mapdenormalizes.orbitIndex


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is mapdenormalize)
            return false
        return itemID == other.itemID
    }


    actual override fun hashCode() = itemID


    actual override fun toString() = itemName
}

