package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable

object maplocationscenes : IntIdTable("maplocationscenes", "locationID") {
    // Database Columns

    val locationID = integer("locationID").primaryKey()
    val graphicID = integer("graphicID")
}


actual class maplocationscene(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(maplocationscene::class)
    actual companion object : IntEntityClass<maplocationscene>(maplocationscenes), KSerializer<maplocationscene> {
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("maplocationscene") {
            init {
                addElement("locationID")
                addElement("graphicID")
            }
        }

        actual override fun serialize(output: Encoder, obj: maplocationscene) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.locationID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.graphicID.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): maplocationscene {
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
                throw SerializationException("Id 'locationID' @ index 0 not found")
            else
                return maplocationscene[id]
        }

        actual fun serializer(): KSerializer<maplocationscene> = this
    }

    // Database Columns

    actual val locationID by maplocationscenes.locationID
    actual val graphicID by maplocationscenes.graphicID


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is maplocationscene)
            return false
        return locationID == other.locationID
    }


    actual override fun hashCode() = locationID


}

