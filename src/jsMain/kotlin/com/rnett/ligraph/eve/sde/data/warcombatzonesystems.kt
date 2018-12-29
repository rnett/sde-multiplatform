
package com.rnett.ligraph.eve.sde.data


import com.rnett.kframe.data.callEndpoint
import com.rnett.ligraph.eve.sde.requestClient
import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

@Serializable(with = warcombatzonesystem.Companion::class)
actual data class warcombatzonesystem(
    actual val solarSystemID: Int,
    actual val combatZoneID: Int
) {


    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is warcombatzonesystem)
            return false
        return solarSystemID == other.solarSystemID
    }


    actual override fun hashCode() = solarSystemID


    @Serializer(warcombatzonesystem::class)
    actual companion object : KSerializer<warcombatzonesystem> {
        actual fun getItem(id: Int): warcombatzonesystem = callEndpoint(this::getItem, requestClient, id)
        actual fun allItems(): List<warcombatzonesystem> = callEndpoint(this::allItems, requestClient)


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
            var temp_solarSystemID: Int? = null
            var temp_combatZoneID: Int? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> temp_solarSystemID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    1 -> temp_combatZoneID = stringFromUtf8Bytes(
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

            return warcombatzonesystem(
                temp_solarSystemID ?: throw SerializationException("Missing value for solarSystemID"),
                temp_combatZoneID ?: throw SerializationException("Missing value for combatZoneID")
            )
        }

        actual fun serializer(): KSerializer<warcombatzonesystem> = this
    }
}

