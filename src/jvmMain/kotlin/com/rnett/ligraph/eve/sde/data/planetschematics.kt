
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.transactions.transaction

object planetschematics : IntIdTable("planetschematics", "schematicID") {
    // Database Columns

    val schematicID = integer("schematicID")//.primaryKey()
    val schematicName = varchar("schematicName", 255)
    val cycleTime = integer("cycleTime")
}


@Serializable(with = planetschematic.Companion::class)
actual class planetschematic(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(planetschematic::class)
    actual companion object : IntEntityClass<planetschematic>(planetschematics), KSerializer<planetschematic> {
        actual fun getItem(id: Int) = transaction { super.get(id) }
        actual fun allItems() = transaction { super.all().toList() }
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("planetschematic") {
            init {
                addElement("schematicID")
                addElement("schematicName")
                addElement("cycleTime")
            }
        }

        actual override fun serialize(output: Encoder, obj: planetschematic) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.schematicID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.schematicName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.cycleTime.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): planetschematic {
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
                throw SerializationException("Id 'schematicID' @ index 0 not found")
            else
                return planetschematic[id]
        }

        actual fun serializer(): KSerializer<planetschematic> = this
    }

    // Database Columns

    actual val schematicID by planetschematics.schematicID
    actual val schematicName by planetschematics.schematicName
    actual val cycleTime by planetschematics.cycleTime


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is planetschematic)
            return false
        return schematicID == other.schematicID
    }


    actual override fun hashCode() = schematicID


    actual override fun toString() = schematicName
}

