
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.transactions.transaction

object maplandmarks : IntIdTable("maplandmarks", "landmarkID") {
    // Database Columns

    val landmarkID = integer("landmarkID").primaryKey()
    val landmarkName = varchar("landmarkName", 100)
    val description = text("description")
    val locationID = integer("locationID")
    val x = double("x")
    val y = double("y")
    val z = double("z")
    val iconID = integer("iconID")
}



actual class maplandmark(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(maplandmark::class)
    actual companion object : IntEntityClass<maplandmark>(maplandmarks), KSerializer<maplandmark> {
        actual fun getItem(id: Int) = transaction { super.get(id) }
        actual fun allItems() = transaction { super.all().toList() }
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("maplandmark") {
            init {
                addElement("landmarkID")
                addElement("landmarkName")
                addElement("description")
                addElement("locationID")
                addElement("x")
                addElement("y")
                addElement("z")
                addElement("iconID")
            }
        }

        actual override fun serialize(output: Encoder, obj: maplandmark) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.landmarkID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.landmarkName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.description.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.locationID.toString().toUtf8Bytes())
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
                HexConverter.printHexBinary(obj.iconID.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): maplandmark {
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
                throw SerializationException("Id 'landmarkID' @ index 0 not found")
            else
                return maplandmark[id]
        }

        actual fun serializer(): KSerializer<maplandmark> = this
    }

    // Database Columns

    actual val landmarkID by maplandmarks.landmarkID
    actual val landmarkName by maplandmarks.landmarkName
    actual val description by maplandmarks.description
    actual val locationID by maplandmarks.locationID
    actual val x by maplandmarks.x
    actual val y by maplandmarks.y
    actual val z by maplandmarks.z
    actual val iconID by maplandmarks.iconID


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is maplandmark)
            return false
        return landmarkID == other.landmarkID
    }


    actual override fun hashCode() = landmarkID


    actual override fun toString() = landmarkName
}

