package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable

object agtagenttypes : IntIdTable("agtagenttypes", "agentTypeID") {
    // Database Columns

    val agentTypeID = integer("agentTypeID").primaryKey()
    val agentType = varchar("agentType", 50)
}


actual class agtagenttype(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(agtagenttype::class)
    actual companion object : IntEntityClass<agtagenttype>(agtagenttypes), KSerializer<agtagenttype> {
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("agtagenttype") {
            init {
                addElement("agentTypeID")
                addElement("agentType")
            }
        }

        actual override fun serialize(output: Encoder, obj: agtagenttype) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.agentTypeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.agentType.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): agtagenttype {
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
                throw SerializationException("Id 'agentTypeID' @ index 0 not found")
            else
                return agtagenttype[id]
        }

        actual fun serializer(): KSerializer<agtagenttype> = this
    }

    // Database Columns

    actual val agentTypeID by agtagenttypes.agentTypeID
    actual val agentType by agtagenttypes.agentType


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is agtagenttype)
            return false
        return agentTypeID == other.agentTypeID
    }


    actual override fun hashCode() = agentTypeID


}

