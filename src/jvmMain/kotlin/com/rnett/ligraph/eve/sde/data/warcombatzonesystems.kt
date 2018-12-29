
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.transactions.transaction

object warcombatzonesystems : IntIdTable("warcombatzonesystems", "solarSystemID") {
    // Database Columns

    val solarSystemID = integer("solarSystemID").primaryKey()
    val combatZoneID = integer("combatZoneID")
}


@Serializable(with = warcombatzonesystem.Companion::class)
actual class warcombatzonesystem(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(warcombatzonesystem::class)
    actual companion object : IntEntityClass<warcombatzonesystem>(warcombatzonesystems),
        KSerializer<warcombatzonesystem> {
        actual fun getItem(id: Int) = transaction { super.get(id) }
        actual fun allItems() = transaction { super.all().toList() }
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("warcombatzonesystem") {
            init {
                addElement("solarSystemID")
                addElement("combatZoneID")
            }
        }

        actual override fun serialize(output: Encoder, obj: warcombatzonesystem) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.solarSystemID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.combatZoneID.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): warcombatzonesystem {
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
                throw SerializationException("Id 'solarSystemID' @ index 0 not found")
            else
                return warcombatzonesystem[id]
        }

        actual fun serializer(): KSerializer<warcombatzonesystem> = this
    }

    // Database Columns

    actual val solarSystemID by warcombatzonesystems.solarSystemID
    actual val combatZoneID by warcombatzonesystems.combatZoneID


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is warcombatzonesystem)
            return false
        return solarSystemID == other.solarSystemID
    }


    actual override fun hashCode() = solarSystemID


}

