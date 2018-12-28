package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable

object ramassemblylinetypes : IntIdTable("ramassemblylinetypes", "assemblyLineTypeID") {
    // Database Columns

    val assemblyLineTypeID = integer("assemblyLineTypeID").primaryKey()
    val assemblyLineTypeName = varchar("assemblyLineTypeName", 100)
    val description = varchar("description", 1000)
    val baseTimeMultiplier = double("baseTimeMultiplier")
    val baseMaterialMultiplier = double("baseMaterialMultiplier")
    val baseCostMultiplier = double("baseCostMultiplier")
    val volume = double("volume")
    val activityID = integer("activityID")
    val minCostPerHour = double("minCostPerHour")
}


actual class ramassemblylinetype(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(ramassemblylinetype::class)
    actual companion object : IntEntityClass<ramassemblylinetype>(ramassemblylinetypes),
        KSerializer<ramassemblylinetype> {
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("ramassemblylinetype") {
            init {
                addElement("assemblyLineTypeID")
                addElement("assemblyLineTypeName")
                addElement("description")
                addElement("baseTimeMultiplier")
                addElement("baseMaterialMultiplier")
                addElement("baseCostMultiplier")
                addElement("volume")
                addElement("activityID")
                addElement("minCostPerHour")
            }
        }

        actual override fun serialize(output: Encoder, obj: ramassemblylinetype) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.assemblyLineTypeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.assemblyLineTypeName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.description.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.baseTimeMultiplier.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                4,
                HexConverter.printHexBinary(obj.baseMaterialMultiplier.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                5,
                HexConverter.printHexBinary(obj.baseCostMultiplier.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                6,
                HexConverter.printHexBinary(obj.volume.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                7,
                HexConverter.printHexBinary(obj.activityID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                8,
                HexConverter.printHexBinary(obj.minCostPerHour.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): ramassemblylinetype {
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
                throw SerializationException("Id 'assemblyLineTypeID' @ index 0 not found")
            else
                return ramassemblylinetype[id]
        }

        actual fun serializer(): KSerializer<ramassemblylinetype> = this
    }

    // Database Columns

    actual val assemblyLineTypeID by ramassemblylinetypes.assemblyLineTypeID
    actual val assemblyLineTypeName by ramassemblylinetypes.assemblyLineTypeName
    actual val description by ramassemblylinetypes.description
    actual val baseTimeMultiplier by ramassemblylinetypes.baseTimeMultiplier
    actual val baseMaterialMultiplier by ramassemblylinetypes.baseMaterialMultiplier
    actual val baseCostMultiplier by ramassemblylinetypes.baseCostMultiplier
    actual val volume by ramassemblylinetypes.volume
    actual val activityID by ramassemblylinetypes.activityID
    actual val minCostPerHour by ramassemblylinetypes.minCostPerHour


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is ramassemblylinetype)
            return false
        return assemblyLineTypeID == other.assemblyLineTypeID
    }


    actual override fun hashCode() = assemblyLineTypeID


    actual override fun toString() = assemblyLineTypeName
}

