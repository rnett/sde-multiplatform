
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.transactions.transaction

object chrraces : IntIdTable("chrraces", "raceID") {
    // Database Columns

    val raceID = integer("raceID")//.primaryKey()
    val raceName = varchar("raceName", 100)
    val description = varchar("description", 1000)
    val iconID = integer("iconID")
    val shortDescription = varchar("shortDescription", 500)
}


@Serializable(with = chrrace.Companion::class)
actual class chrrace(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(chrrace::class)
    actual companion object : IntEntityClass<chrrace>(chrraces), KSerializer<chrrace> {
        actual fun getItem(id: Int) = transaction { super.get(id) }
        actual fun allItems() = transaction { super.all().toList() }
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("chrrace") {
            init {
                addElement("raceID")
                addElement("raceName")
                addElement("description")
                addElement("iconID")
                addElement("shortDescription")
            }
        }

        actual override fun serialize(output: Encoder, obj: chrrace) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.raceID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.raceName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.description.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.iconID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                4,
                HexConverter.printHexBinary(obj.shortDescription.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): chrrace {
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
                throw SerializationException("Id 'raceID' @ index 0 not found")
            else
                return chrrace[id]
        }

        actual fun serializer(): KSerializer<chrrace> = this
    }

    // Database Columns

    actual val raceID by chrraces.raceID
    actual val raceName by chrraces.raceName
    actual val description by chrraces.description
    actual val iconID by chrraces.iconID
    actual val shortDescription by chrraces.shortDescription


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is chrrace)
            return false
        return raceID == other.raceID
    }


    actual override fun hashCode() = raceID


    actual override fun toString() = raceName
}

