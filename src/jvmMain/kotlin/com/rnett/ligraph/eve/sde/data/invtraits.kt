
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.transactions.transaction

object invtraits : IntIdTable("invtraits", "traitID") {
    // Database Columns

    val traitID = integer("traitID").autoIncrement().primaryKey()
    val typeID = integer("typeID")
    val skillID = integer("skillID")
    val bonus = double("bonus")
    val bonusText = text("bonusText")
    val unitID = integer("unitID")


    // Foreign/Imported Keys (One to Many)

    val type = reference("typeID", invtypes)
}



actual class invtrait(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(invtrait::class)
    actual companion object : IntEntityClass<invtrait>(invtraits), KSerializer<invtrait> {
        actual fun getItem(id: Int) = transaction { super.get(id) }
        actual fun allItems() = transaction { super.all().toList() }
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("invtrait") {
            init {
                addElement("traitID")
                addElement("typeID")
                addElement("skillID")
                addElement("bonus")
                addElement("bonusText")
                addElement("unitID")
            }
        }

        actual override fun serialize(output: Encoder, obj: invtrait) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.traitID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.typeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.skillID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.bonus.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                4,
                HexConverter.printHexBinary(obj.bonusText.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                5,
                HexConverter.printHexBinary(obj.unitID.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): invtrait {
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
                throw SerializationException("Id 'traitID' @ index 0 not found")
            else
                return invtrait[id]
        }

        actual fun serializer(): KSerializer<invtrait> = this
    }

    // Database Columns

    actual val traitID by invtraits.traitID
    actual val typeID by invtraits.typeID
    actual val skillID by invtraits.skillID
    actual val bonus by invtraits.bonus
    actual val bonusText by invtraits.bonusText
    actual val unitID by invtraits.unitID


    // Foreign/Imported Keys (One to Many)

    val type: invtype by invtype referencedOn invtraits.type


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is invtrait)
            return false
        return traitID == other.traitID
    }


    actual override fun hashCode() = traitID


}

