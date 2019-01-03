
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.transactions.transaction

object invvolumes : IntIdTable("invvolumes", "typeID") {
    // Database Columns

    val typeID = integer("typeID")//.primaryKey()
    val volume = integer("volume")
}


@Serializable(with = invvolume.Companion::class)
actual class invvolume(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(invvolume::class)
    actual companion object : IntEntityClass<invvolume>(invvolumes), KSerializer<invvolume> {
        actual fun getItem(id: Int) = transaction { super.get(id) }
        actual fun allItems() = transaction { super.all().toList() }
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("invvolume") {
            init {
                addElement("typeID")
                addElement("volume")
            }
        }

        actual override fun serialize(output: Encoder, obj: invvolume) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.typeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.volume.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): invvolume {
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
                throw SerializationException("Id 'typeID' @ index 0 not found")
            else
                return invvolume[id]
        }

        actual fun serializer(): KSerializer<invvolume> = this
    }

    // Database Columns

    actual val typeID by invvolumes.typeID
    actual val volume by invvolumes.volume


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is invvolume)
            return false
        return typeID == other.typeID
    }


    actual override fun hashCode() = typeID


}

