package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable

object invtypereactions : IntIdTable("invtypereactions", "reactionTypeID") {
    // Database Columns

    val reactionTypeID = integer("reactionTypeID").primaryKey(1)
    val input = bool("input").primaryKey(2)
    val typeID = integer("typeID").primaryKey(3)
    val quantity = integer("quantity")
}


actual class invtypereaction(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(invtypereaction::class)
    actual companion object : IntEntityClass<invtypereaction>(invtypereactions), KSerializer<invtypereaction> {
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("invtypereaction") {
            init {
                addElement("reactionTypeID")
                addElement("input")
                addElement("typeID")
                addElement("quantity")
            }
        }

        actual override fun serialize(output: Encoder, obj: invtypereaction) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.reactionTypeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.input.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.typeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.quantity.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): invtypereaction {
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
                throw SerializationException("Id 'reactionTypeID' @ index 0 not found")
            else
                return invtypereaction[id]
        }

        actual fun serializer(): KSerializer<invtypereaction> = this
    }

    // Database Columns

    actual val reactionTypeID by invtypereactions.reactionTypeID
    actual val input by invtypereactions.input
    actual val typeID by invtypereactions.typeID
    actual val quantity by invtypereactions.quantity


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is invtypereaction)
            return false
        return reactionTypeID == other.reactionTypeID
    }


    actual override fun hashCode() = reactionTypeID


}

