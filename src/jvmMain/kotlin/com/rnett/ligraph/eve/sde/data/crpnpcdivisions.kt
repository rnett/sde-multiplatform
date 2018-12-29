
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.transactions.transaction

object crpnpcdivisions : IntIdTable("crpnpcdivisions", "divisionID") {
    // Database Columns

    val divisionID = integer("divisionID").primaryKey()
    val divisionName = varchar("divisionName", 100)
    val description = varchar("description", 1000)
    val leaderType = varchar("leaderType", 100)
}



actual class crpnpcdivision(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(crpnpcdivision::class)
    actual companion object : IntEntityClass<crpnpcdivision>(crpnpcdivisions), KSerializer<crpnpcdivision> {
        actual fun getItem(id: Int) = transaction { super.get(id) }
        actual fun allItems() = transaction { super.all().toList() }
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("crpnpcdivision") {
            init {
                addElement("divisionID")
                addElement("divisionName")
                addElement("description")
                addElement("leaderType")
            }
        }

        actual override fun serialize(output: Encoder, obj: crpnpcdivision) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.divisionID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.divisionName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.description.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.leaderType.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): crpnpcdivision {
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
                throw SerializationException("Id 'divisionID' @ index 0 not found")
            else
                return crpnpcdivision[id]
        }

        actual fun serializer(): KSerializer<crpnpcdivision> = this
    }

    // Database Columns

    actual val divisionID by crpnpcdivisions.divisionID
    actual val divisionName by crpnpcdivisions.divisionName
    actual val description by crpnpcdivisions.description
    actual val leaderType by crpnpcdivisions.leaderType


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is crpnpcdivision)
            return false
        return divisionID == other.divisionID
    }


    actual override fun hashCode() = divisionID


    actual override fun toString() = divisionName
}

