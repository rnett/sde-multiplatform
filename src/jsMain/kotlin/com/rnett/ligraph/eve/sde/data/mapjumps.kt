
package com.rnett.ligraph.eve.sde.data


import com.rnett.kframe.data.callEndpoint
import com.rnett.ligraph.eve.sde.requestClient
import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

actual data class mapjump(
    actual val stargateID: Int,
    actual val destinationID: Int
) {
    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is mapjump)
            return false
        return stargateID == other.stargateID
    }


    actual override fun hashCode() = stargateID


    @Serializer(mapjump::class)
    actual companion object : KSerializer<mapjump> {
        actual fun getItem(id: Int): mapjump = callEndpoint(this::getItem, requestClient, id)
        actual fun allItems(): List<mapjump> = callEndpoint(this::allItems, requestClient)
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
            var temp_stargateID: Int? = null
            var temp_destinationID: Int? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> temp_stargateID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    1 -> temp_destinationID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    else -> if (i < descriptor.elementsCount) continue@loop else throw SerializationException("Unknown index $i")
                }
            }

            inp.endStructure(descriptor)

            return mapjump(
                temp_stargateID ?: throw SerializationException("Missing value for stargateID"),
                temp_destinationID ?: throw SerializationException("Missing value for destinationID")
            )
        }

        actual fun serializer(): KSerializer<mapjump> = this
    }
}

