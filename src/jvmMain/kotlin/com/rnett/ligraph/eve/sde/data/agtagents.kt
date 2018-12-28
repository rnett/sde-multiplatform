package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable

object agtagents : IntIdTable("agtagents", "agentID") {
    // Database Columns

    val agentID = integer("agentID").primaryKey()
    val divisionID = integer("divisionID")
    val corporationID = integer("corporationID")
    val locationID = integer("locationID")
    val level = integer("level")
    val quality = integer("quality")
    val agentTypeID = integer("agentTypeID")
    val isLocator = bool("isLocator")
}


actual class agtagent(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(agtagent::class)
    actual companion object : IntEntityClass<agtagent>(agtagents), KSerializer<agtagent> {
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("agtagent") {
            init {
                addElement("agentID")
                addElement("divisionID")
                addElement("corporationID")
                addElement("locationID")
                addElement("level")
                addElement("quality")
                addElement("agentTypeID")
                addElement("isLocator")
            }
        }

        actual override fun serialize(output: Encoder, obj: agtagent) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.agentID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.divisionID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.corporationID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.locationID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                4,
                HexConverter.printHexBinary(obj.level.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                5,
                HexConverter.printHexBinary(obj.quality.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                6,
                HexConverter.printHexBinary(obj.agentTypeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                7,
                HexConverter.printHexBinary(obj.isLocator.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): agtagent {
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
                throw SerializationException("Id 'agentID' @ index 0 not found")
            else
                return agtagent[id]
        }

        actual fun serializer(): KSerializer<agtagent> = this
    }

    // Database Columns

    actual val agentID by agtagents.agentID
    actual val divisionID by agtagents.divisionID
    actual val corporationID by agtagents.corporationID
    actual val locationID by agtagents.locationID
    actual val level by agtagents.level
    actual val quality by agtagents.quality
    actual val agentTypeID by agtagents.agentTypeID
    actual val isLocator by agtagents.isLocator


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is agtagent)
            return false
        return agentID == other.agentID
    }


    actual override fun hashCode() = agentID


}

