
package com.rnett.ligraph.eve.sde.data


import com.rnett.kframe.data.callEndpoint
import com.rnett.ligraph.eve.sde.requestClient
import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

@Serializable(with = invvolume.Companion::class)
actual data class invvolume(
    actual val typeID: Int,
    actual val volume: Int
) {


    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is invvolume)
            return false
        return typeID == other.typeID
    }


    actual override fun hashCode() = typeID


    @Serializer(invvolume::class)
    actual companion object : KSerializer<invvolume> {
        actual fun getItem(id: Int): invvolume = callEndpoint(this::getItem, requestClient, id)
        actual fun allItems(): List<invvolume> = callEndpoint(this::allItems, requestClient)


        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("invvolume") {
            init {
                addElement("typeID")
                addElement("volume")
            }
        }

        actual override fun serialize(output: Encoder, obj: invvolume) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.typeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.volume.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): invvolume {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var temp_typeID: Int? = null
            var temp_volume: Int? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> temp_typeID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    1 -> temp_volume =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    else -> if (i < descriptor.elementsCount) continue@loop else throw SerializationException("Unknown index $i")
                }
            }

            inp.endStructure(descriptor)

            return invvolume(
                temp_typeID ?: throw SerializationException("Missing value for typeID"),
                temp_volume ?: throw SerializationException("Missing value for volume")
            )
        }

        actual fun serializer(): KSerializer<invvolume> = this
    }
}

