package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable

object invmetagroups : IntIdTable("invmetagroups", "metaGroupID") {
    // Database Columns

    val metaGroupID = integer("metaGroupID").primaryKey()
    val metaGroupName = varchar("metaGroupName", 100)
    val description = varchar("description", 1000)
    val iconID = integer("iconID")
}


actual class invmetagroup(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(invmetagroup::class)
    actual companion object : IntEntityClass<invmetagroup>(invmetagroups), KSerializer<invmetagroup> {
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("invmetagroup") {
            init {
                addElement("metaGroupID")
                addElement("metaGroupName")
                addElement("description")
                addElement("iconID")
            }
        }

        actual override fun serialize(output: Encoder, obj: invmetagroup) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.metaGroupID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.metaGroupName.toString().toUtf8Bytes())
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
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): invmetagroup {
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
                throw SerializationException("Id 'metaGroupID' @ index 0 not found")
            else
                return invmetagroup[id]
        }

        actual fun serializer(): KSerializer<invmetagroup> = this
    }

    // Database Columns

    actual val metaGroupID by invmetagroups.metaGroupID
    actual val metaGroupName by invmetagroups.metaGroupName
    actual val description by invmetagroups.description
    actual val iconID by invmetagroups.iconID


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is invmetagroup)
            return false
        return metaGroupID == other.metaGroupID
    }


    actual override fun hashCode() = metaGroupID


    actual override fun toString() = metaGroupName
}

