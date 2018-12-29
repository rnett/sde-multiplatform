
package com.rnett.ligraph.eve.sde.data


import com.rnett.kframe.data.callEndpoint
import com.rnett.ligraph.eve.sde.requestClient
import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

@Serializable(with = agtagent.Companion::class)
actual data class agtagent(
    actual val agentID: Int,
    actual val divisionID: Int,
    actual val corporationID: Int,
    actual val locationID: Int,
    actual val level: Int,
    actual val quality: Int,
    actual val agentTypeID: Int,
    actual val isLocator: Boolean
) {


    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is agtagent)
            return false
        return agentID == other.agentID
    }


    actual override fun hashCode() = agentID


    @Serializer(agtagent::class)
    actual companion object : KSerializer<agtagent> {
        actual fun getItem(id: Int): agtagent = callEndpoint(this::getItem, requestClient, id)
        actual fun allItems(): List<agtagent> = callEndpoint(this::allItems, requestClient)


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
            var temp_agentID: Int? = null
            var temp_divisionID: Int? = null
            var temp_corporationID: Int? = null
            var temp_locationID: Int? = null
            var temp_level: Int? = null
            var temp_quality: Int? = null
            var temp_agentTypeID: Int? = null
            var temp_isLocator: Boolean? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> temp_agentID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    1 -> temp_divisionID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    2 -> temp_corporationID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    3 -> temp_locationID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    4 -> temp_level = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    5 -> temp_quality = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    6 -> temp_agentTypeID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    7 -> temp_isLocator = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toBoolean()
                    else -> if (i < descriptor.elementsCount) continue@loop else throw SerializationException("Unknown index $i")
                }
            }

            inp.endStructure(descriptor)

            return agtagent(
                temp_agentID ?: throw SerializationException("Missing value for agentID"),
                temp_divisionID ?: throw SerializationException("Missing value for divisionID"),
                temp_corporationID ?: throw SerializationException("Missing value for corporationID"),
                temp_locationID ?: throw SerializationException("Missing value for locationID"),
                temp_level ?: throw SerializationException("Missing value for level"),
                temp_quality ?: throw SerializationException("Missing value for quality"),
                temp_agentTypeID ?: throw SerializationException("Missing value for agentTypeID"),
                temp_isLocator ?: throw SerializationException("Missing value for isLocator")
            )
        }

        actual fun serializer(): KSerializer<agtagent> = this
    }
}

