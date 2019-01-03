
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.transactions.transaction

object maplocationwormholeclasses : IntIdTable("maplocationwormholeclasses", "locationID") {
    // Database Columns

    val locationID = integer("locationID")//.primaryKey()
    val wormholeClassID = integer("wormholeClassID")
}


@Serializable(with = maplocationwormholeclass.Companion::class)
actual class maplocationwormholeclass(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(maplocationwormholeclass::class)
    actual companion object : IntEntityClass<maplocationwormholeclass>(maplocationwormholeclasses),
        KSerializer<maplocationwormholeclass> {
        actual fun getItem(id: Int) = transaction { super.get(id) }
        actual fun allItems() = transaction { super.all().toList() }
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("maplocationwormholeclass") {
            init {
                addElement("locationID")
                addElement("wormholeClassID")
            }
        }

        actual override fun serialize(output: Encoder, obj: maplocationwormholeclass) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.locationID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.wormholeClassID.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): maplocationwormholeclass {
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
                throw SerializationException("Id 'locationID' @ index 0 not found")
            else
                return maplocationwormholeclass[id]
        }

        actual fun serializer(): KSerializer<maplocationwormholeclass> = this
    }

    // Database Columns

    actual val locationID by maplocationwormholeclasses.locationID
    actual val wormholeClassID by maplocationwormholeclasses.wormholeClassID


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is maplocationwormholeclass)
            return false
        return locationID == other.locationID
    }


    actual override fun hashCode() = locationID


}

