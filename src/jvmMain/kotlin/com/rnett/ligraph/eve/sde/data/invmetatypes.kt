
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.transactions.transaction

object invmetatypes : IntIdTable("invmetatypes", "typeID") {
    // Database Columns

    val typeID = integer("typeID").primaryKey()
    val parentTypeID = integer("parentTypeID")
    val metaGroupID = integer("metaGroupID")
}


@Serializable(with = invmetatype.Companion::class)
actual class invmetatype(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(invmetatype::class)
    actual companion object : IntEntityClass<invmetatype>(invmetatypes), KSerializer<invmetatype> {
        actual fun getItem(id: Int) = transaction { super.get(id) }
        actual fun allItems() = transaction { super.all().toList() }
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("invmetatype") {
            init {
                addElement("typeID")
                addElement("parentTypeID")
                addElement("metaGroupID")
            }
        }

        actual override fun serialize(output: Encoder, obj: invmetatype) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.typeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.parentTypeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.metaGroupID.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): invmetatype {
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
                throw SerializationException("Id 'typeID' @ index 0 not found")
            else
                return invmetatype[id]
        }

        actual fun serializer(): KSerializer<invmetatype> = this
    }

    // Database Columns

    actual val typeID by invmetatypes.typeID
    actual val parentTypeID by invmetatypes.parentTypeID
    actual val metaGroupID by invmetatypes.metaGroupID


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is invmetatype)
            return false
        return typeID == other.typeID
    }


    actual override fun hashCode() = typeID


}

