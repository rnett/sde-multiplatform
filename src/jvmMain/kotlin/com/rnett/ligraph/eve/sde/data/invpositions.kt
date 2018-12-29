
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.transactions.transaction

object invpositions : IntIdTable("invpositions", "itemID") {
    // Database Columns

    val itemID = integer("itemID").primaryKey()
    val x = double("x")
    val y = double("y")
    val z = double("z")
    val yaw = float("yaw")
    val pitch = float("pitch")
    val roll = float("roll")
}



actual class invposition(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(invposition::class)
    actual companion object : IntEntityClass<invposition>(invpositions), KSerializer<invposition> {
        actual fun getItem(id: Int) = transaction { super.get(id) }
        actual fun allItems() = transaction { super.all().toList() }
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("invposition") {
            init {
                addElement("itemID")
                addElement("x")
                addElement("y")
                addElement("z")
                addElement("yaw")
                addElement("pitch")
                addElement("roll")
            }
        }

        actual override fun serialize(output: Encoder, obj: invposition) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.itemID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.x.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.y.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.z.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                4,
                HexConverter.printHexBinary(obj.yaw.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                5,
                HexConverter.printHexBinary(obj.pitch.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                6,
                HexConverter.printHexBinary(obj.roll.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): invposition {
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
                throw SerializationException("Id 'itemID' @ index 0 not found")
            else
                return invposition[id]
        }

        actual fun serializer(): KSerializer<invposition> = this
    }

    // Database Columns

    actual val itemID by invpositions.itemID
    actual val x by invpositions.x
    actual val y by invpositions.y
    actual val z by invpositions.z
    actual val yaw by invpositions.yaw
    actual val pitch by invpositions.pitch
    actual val roll by invpositions.roll


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is invposition)
            return false
        return itemID == other.itemID
    }


    actual override fun hashCode() = itemID


}

