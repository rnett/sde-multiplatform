package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable

object mapjumps : IntIdTable("mapjumps", "stargateID") {
    // Database Columns

    val stargateID = integer("stargateID").primaryKey()
    val destinationID = integer("destinationID")
}


actual class mapjump(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(mapjump::class)
    actual companion object : IntEntityClass<mapjump>(mapjumps), KSerializer<mapjump> {
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("mapjump") {
            init {
                addElement("stargateID")
                addElement("destinationID")
            }
        }

        actual override fun serialize(output: Encoder, obj: mapjump) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.stargateID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.destinationID.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): mapjump {
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
                throw SerializationException("Id 'stargateID' @ index 0 not found")
            else
                return mapjump[id]
        }

        actual fun serializer(): KSerializer<mapjump> = this
    }

    // Database Columns

    actual val stargateID by mapjumps.stargateID
    actual val destinationID by mapjumps.destinationID


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is mapjump)
            return false
        return stargateID == other.stargateID
    }


    actual override fun hashCode() = stargateID


}

