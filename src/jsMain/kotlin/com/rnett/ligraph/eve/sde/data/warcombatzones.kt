
package com.rnett.ligraph.eve.sde.data


import com.rnett.kframe.data.callEndpoint
import com.rnett.ligraph.eve.sde.requestClient
import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

@Serializable(with = warcombatzone.Companion::class)
actual data class warcombatzone(
    actual val combatZoneID: Int,
    actual val combatZoneName: String,
    actual val factionID: Int,
    actual val centerSystemID: Int,
    actual val description: String
) {


    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is warcombatzone)
            return false
        return combatZoneID == other.combatZoneID
    }


    actual override fun hashCode() = combatZoneID


    actual override fun toString() = combatZoneName

    @Serializer(warcombatzone::class)
    actual companion object : KSerializer<warcombatzone> {
        actual fun getItem(id: Int): warcombatzone = callEndpoint(this::getItem, requestClient, id)
        actual fun allItems(): List<warcombatzone> = callEndpoint(this::allItems, requestClient)


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
            var temp_combatZoneID: Int? = null
            var temp_combatZoneName: String? = null
            var temp_factionID: Int? = null
            var temp_centerSystemID: Int? = null
            var temp_description: String? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> temp_combatZoneID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    1 -> temp_combatZoneName = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    2 -> temp_factionID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    3 -> temp_centerSystemID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    4 -> temp_description = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    else -> if (i < descriptor.elementsCount) continue@loop else throw SerializationException("Unknown index $i")
                }
            }

            inp.endStructure(descriptor)

            return warcombatzone(
                temp_combatZoneID ?: throw SerializationException("Missing value for combatZoneID"),
                temp_combatZoneName ?: throw SerializationException("Missing value for combatZoneName"),
                temp_factionID ?: throw SerializationException("Missing value for factionID"),
                temp_centerSystemID ?: throw SerializationException("Missing value for centerSystemID"),
                temp_description ?: throw SerializationException("Missing value for description")
            )
        }

        actual fun serializer(): KSerializer<warcombatzone> = this
    }
}

