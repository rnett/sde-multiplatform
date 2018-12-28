package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable

object eveunits : IntIdTable("eveunits", "unitID") {
    // Database Columns

    val unitID = integer("unitID").primaryKey()
    val unitName = varchar("unitName", 100)
    val displayName = varchar("displayName", 50)
    val description = varchar("description", 1000)
}


actual class eveunit(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(eveunit::class)
    actual companion object : IntEntityClass<eveunit>(eveunits), KSerializer<eveunit> {
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("eveunit") {
            init {
                addElement("unitID")
                addElement("unitName")
                addElement("displayName")
                addElement("description")
            }
        }

        actual override fun serialize(output: Encoder, obj: eveunit) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.unitID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.unitName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.displayName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.description.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): eveunit {
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
                throw SerializationException("Id 'unitID' @ index 0 not found")
            else
                return eveunit[id]
        }

        actual fun serializer(): KSerializer<eveunit> = this
    }

    // Database Columns

    actual val unitID by eveunits.unitID
    actual val unitName by eveunits.unitName
    actual val displayName by eveunits.displayName
    actual val description by eveunits.description


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is eveunit)
            return false
        return unitID == other.unitID
    }


    actual override fun hashCode() = unitID


}

