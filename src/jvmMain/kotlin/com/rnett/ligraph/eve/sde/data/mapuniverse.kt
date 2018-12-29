
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.transactions.transaction

object mapuniverses : IntIdTable("mapuniverse", "universeID") {
    // Database Columns

    val universeID = integer("universeID").primaryKey()
    val universeName = varchar("universeName", 100)
    val x = double("x")
    val y = double("y")
    val z = double("z")
    val xMin = double("xMin")
    val xMax = double("xMax")
    val yMin = double("yMin")
    val yMax = double("yMax")
    val zMin = double("zMin")
    val zMax = double("zMax")
    val radius = double("radius")
}



actual class mapuniverse(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(mapuniverse::class)
    actual companion object : IntEntityClass<mapuniverse>(mapuniverses), KSerializer<mapuniverse> {
        actual fun getItem(id: Int) = transaction { super.get(id) }
        actual fun allItems() = transaction { super.all().toList() }
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("mapuniverse") {
            init {
                addElement("universeID")
                addElement("universeName")
                addElement("x")
                addElement("y")
                addElement("z")
                addElement("xMin")
                addElement("xMax")
                addElement("yMin")
                addElement("yMax")
                addElement("zMin")
                addElement("zMax")
                addElement("radius")
            }
        }

        actual override fun serialize(output: Encoder, obj: mapuniverse) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.universeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.universeName.toString().toUtf8Bytes())
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
                HexConverter.printHexBinary(obj.radius.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): mapuniverse {
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
                throw SerializationException("Id 'universeID' @ index 0 not found")
            else
                return mapuniverse[id]
        }

        actual fun serializer(): KSerializer<mapuniverse> = this
    }

    // Database Columns

    actual val universeID by mapuniverses.universeID
    actual val universeName by mapuniverses.universeName
    actual val x by mapuniverses.x
    actual val y by mapuniverses.y
    actual val z by mapuniverses.z
    actual val xMin by mapuniverses.xMin
    actual val xMax by mapuniverses.xMax
    actual val yMin by mapuniverses.yMin
    actual val yMax by mapuniverses.yMax
    actual val zMin by mapuniverses.zMin
    actual val zMax by mapuniverses.zMax
    actual val radius by mapuniverses.radius


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is mapuniverse)
            return false
        return universeID == other.universeID
    }


    actual override fun hashCode() = universeID


    actual override fun toString() = universeName
}

