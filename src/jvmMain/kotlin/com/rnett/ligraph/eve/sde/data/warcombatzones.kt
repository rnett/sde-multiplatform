package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable

object warcombatzones : IntIdTable("warcombatzones", "combatZoneID") {
    // Database Columns

    val combatZoneID = integer("combatZoneID").primaryKey()
    val combatZoneName = varchar("combatZoneName", 100)
    val factionID = integer("factionID")
    val centerSystemID = integer("centerSystemID")
    val description = varchar("description", 500)
}


actual class warcombatzone(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(warcombatzone::class)
    actual companion object : IntEntityClass<warcombatzone>(warcombatzones), KSerializer<warcombatzone> {
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("warcombatzone") {
            init {
                addElement("combatZoneID")
                addElement("combatZoneName")
                addElement("factionID")
                addElement("centerSystemID")
                addElement("description")
            }
        }

        actual override fun serialize(output: Encoder, obj: warcombatzone) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.combatZoneID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.combatZoneName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.factionID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.centerSystemID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                4,
                HexConverter.printHexBinary(obj.description.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): warcombatzone {
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
                throw SerializationException("Id 'combatZoneID' @ index 0 not found")
            else
                return warcombatzone[id]
        }

        actual fun serializer(): KSerializer<warcombatzone> = this
    }

    // Database Columns

    actual val combatZoneID by warcombatzones.combatZoneID
    actual val combatZoneName by warcombatzones.combatZoneName
    actual val factionID by warcombatzones.factionID
    actual val centerSystemID by warcombatzones.centerSystemID
    actual val description by warcombatzones.description


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is warcombatzone)
            return false
        return combatZoneID == other.combatZoneID
    }


    actual override fun hashCode() = combatZoneID


    actual override fun toString() = combatZoneName
}

