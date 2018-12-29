
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.transactions.transaction

object ramactivities : IntIdTable("ramactivities", "activityID") {
    // Database Columns

    val activityID = integer("activityID").primaryKey()
    val activityName = varchar("activityName", 100)
    val iconNo = varchar("iconNo", 5)
    val description = varchar("description", 1000)
    val published = bool("published")
}


@Serializable(with = ramactivity.Companion::class)
actual class ramactivity(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(ramactivity::class)
    actual companion object : IntEntityClass<ramactivity>(ramactivities), KSerializer<ramactivity> {
        actual fun getItem(id: Int) = transaction { super.get(id) }
        actual fun allItems() = transaction { super.all().toList() }
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("ramactivity") {
            init {
                addElement("activityID")
                addElement("activityName")
                addElement("iconNo")
                addElement("description")
                addElement("published")
            }
        }

        actual override fun serialize(output: Encoder, obj: ramactivity) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.activityID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.activityName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.iconNo.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.description.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                4,
                HexConverter.printHexBinary(obj.published.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): ramactivity {
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
                throw SerializationException("Id 'activityID' @ index 0 not found")
            else
                return ramactivity[id]
        }

        actual fun serializer(): KSerializer<ramactivity> = this
    }

    // Database Columns

    actual val activityID by ramactivities.activityID
    actual val activityName by ramactivities.activityName
    actual val iconNo by ramactivities.iconNo
    actual val description by ramactivities.description
    actual val published by ramactivities.published


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is ramactivity)
            return false
        return activityID == other.activityID
    }


    actual override fun hashCode() = activityID


    actual override fun toString() = activityName
}

