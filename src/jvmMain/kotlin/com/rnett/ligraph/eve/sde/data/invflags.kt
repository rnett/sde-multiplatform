
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.transactions.transaction

object invflags : IntIdTable("invflags", "flagID") {
    // Database Columns

    val flagID = integer("flagID").primaryKey()
    val flagName = varchar("flagName", 200)
    val flagText = varchar("flagText", 100)
    val orderID = integer("orderID")
}


@Serializable(with = invflag.Companion::class)
actual class invflag(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(invflag::class)
    actual companion object : IntEntityClass<invflag>(invflags), KSerializer<invflag> {
        actual fun getItem(id: Int) = transaction { super.get(id) }
        actual fun allItems() = transaction { super.all().toList() }
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("invflag") {
            init {
                addElement("flagID")
                addElement("flagName")
                addElement("flagText")
                addElement("orderID")
            }
        }

        actual override fun serialize(output: Encoder, obj: invflag) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.flagID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.flagName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.flagText.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.orderID.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): invflag {
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
                throw SerializationException("Id 'flagID' @ index 0 not found")
            else
                return invflag[id]
        }

        actual fun serializer(): KSerializer<invflag> = this
    }

    // Database Columns

    actual val flagID by invflags.flagID
    actual val flagName by invflags.flagName
    actual val flagText by invflags.flagText
    actual val orderID by invflags.orderID


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is invflag)
            return false
        return flagID == other.flagID
    }


    actual override fun hashCode() = flagID


    actual override fun toString() = flagName
}

