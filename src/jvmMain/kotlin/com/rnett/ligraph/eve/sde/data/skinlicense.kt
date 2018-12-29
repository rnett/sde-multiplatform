
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.transactions.transaction

object skinlicenses : IntIdTable("skinlicense", "licenseTypeID") {
    // Database Columns

    val licenseTypeID = integer("licenseTypeID").primaryKey()
    val duration = integer("duration")
    val skinID = integer("skinID")
}



actual class skinlicense(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(skinlicense::class)
    actual companion object : IntEntityClass<skinlicense>(skinlicenses), KSerializer<skinlicense> {
        actual fun getItem(id: Int) = transaction { super.get(id) }
        actual fun allItems() = transaction { super.all().toList() }
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("skinlicense") {
            init {
                addElement("licenseTypeID")
                addElement("duration")
                addElement("skinID")
            }
        }

        actual override fun serialize(output: Encoder, obj: skinlicense) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.licenseTypeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.duration.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.skinID.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): skinlicense {
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
                throw SerializationException("Id 'licenseTypeID' @ index 0 not found")
            else
                return skinlicense[id]
        }

        actual fun serializer(): KSerializer<skinlicense> = this
    }

    // Database Columns

    actual val licenseTypeID by skinlicenses.licenseTypeID
    actual val duration by skinlicenses.duration
    actual val skinID by skinlicenses.skinID


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is skinlicense)
            return false
        return licenseTypeID == other.licenseTypeID
    }


    actual override fun hashCode() = licenseTypeID


}

