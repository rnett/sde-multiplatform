
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.transactions.transaction

object evegraphics : IntIdTable("evegraphics", "graphicID") {
    // Database Columns

    val graphicID = integer("graphicID").primaryKey()
    val sofFactionName = varchar("sofFactionName", 100)
    val graphicFile = varchar("graphicFile", 100)
    val sofHullName = varchar("sofHullName", 100)
    val sofRaceName = varchar("sofRaceName", 100)
    val description = text("description")
}


@Serializable(with = evegraphic.Companion::class)
actual class evegraphic(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(evegraphic::class)
    actual companion object : IntEntityClass<evegraphic>(evegraphics), KSerializer<evegraphic> {
        actual fun getItem(id: Int) = transaction { super.get(id) }
        actual fun allItems() = transaction { super.all().toList() }
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("evegraphic") {
            init {
                addElement("graphicID")
                addElement("sofFactionName")
                addElement("graphicFile")
                addElement("sofHullName")
                addElement("sofRaceName")
                addElement("description")
            }
        }

        actual override fun serialize(output: Encoder, obj: evegraphic) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.graphicID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.sofFactionName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.graphicFile.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.sofHullName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                4,
                HexConverter.printHexBinary(obj.sofRaceName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                5,
                HexConverter.printHexBinary(obj.description.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): evegraphic {
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
                throw SerializationException("Id 'graphicID' @ index 0 not found")
            else
                return evegraphic[id]
        }

        actual fun serializer(): KSerializer<evegraphic> = this
    }

    // Database Columns

    actual val graphicID by evegraphics.graphicID
    actual val sofFactionName by evegraphics.sofFactionName
    actual val graphicFile by evegraphics.graphicFile
    actual val sofHullName by evegraphics.sofHullName
    actual val sofRaceName by evegraphics.sofRaceName
    actual val description by evegraphics.description


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is evegraphic)
            return false
        return graphicID == other.graphicID
    }


    actual override fun hashCode() = graphicID


}

