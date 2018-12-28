package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable

object industryblueprints : IntIdTable("industryblueprints", "typeID") {
    // Database Columns

    val typeID = integer("typeID").primaryKey()
    val maxProductionLimit = integer("maxProductionLimit")
}


actual class industryblueprint(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(industryblueprint::class)
    actual companion object : IntEntityClass<industryblueprint>(industryblueprints), KSerializer<industryblueprint> {
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("industryblueprint") {
            init {
                addElement("typeID")
                addElement("maxProductionLimit")
            }
        }

        actual override fun serialize(output: Encoder, obj: industryblueprint) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.typeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.maxProductionLimit.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): industryblueprint {
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
                return industryblueprint[id]
        }

        actual fun serializer(): KSerializer<industryblueprint> = this
    }

    // Database Columns

    actual val typeID by industryblueprints.typeID
    actual val maxProductionLimit by industryblueprints.maxProductionLimit


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is industryblueprint)
            return false
        return typeID == other.typeID
    }


    actual override fun hashCode() = typeID


}

