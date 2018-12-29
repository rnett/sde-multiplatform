
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.transactions.transaction

object invcontroltowerresourcepurposes : IntIdTable("invcontroltowerresourcepurposes", "purpose") {
    // Database Columns

    val purpose = integer("purpose").primaryKey()
    val purposeText = varchar("purposeText", 100)
}


@Serializable(with = invcontroltowerresourcepurpose.Companion::class)
actual class invcontroltowerresourcepurpose(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(invcontroltowerresourcepurpose::class)
    actual companion object : IntEntityClass<invcontroltowerresourcepurpose>(invcontroltowerresourcepurposes),
        KSerializer<invcontroltowerresourcepurpose> {
        actual fun getItem(id: Int) = transaction { super.get(id) }
        actual fun allItems() = transaction { super.all().toList() }
        actual override val descriptor: SerialDescriptor =
            object : SerialClassDescImpl("invcontroltowerresourcepurpose") {
                init {
                    addElement("purpose")
                    addElement("purposeText")
                }
            }

        actual override fun serialize(output: Encoder, obj: invcontroltowerresourcepurpose) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.purpose.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.purposeText.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): invcontroltowerresourcepurpose {
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
                throw SerializationException("Id 'purpose' @ index 0 not found")
            else
                return invcontroltowerresourcepurpose[id]
        }

        actual fun serializer(): KSerializer<invcontroltowerresourcepurpose> = this
    }

    // Database Columns

    actual val purpose by invcontroltowerresourcepurposes.purpose
    actual val purposeText by invcontroltowerresourcepurposes.purposeText


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is invcontroltowerresourcepurpose)
            return false
        return purpose == other.purpose
    }


    actual override fun hashCode() = purpose


}

