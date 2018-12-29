
package com.rnett.ligraph.eve.sde.data


import com.rnett.kframe.data.callEndpoint
import com.rnett.ligraph.eve.sde.requestClient
import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

actual data class maplocationscene(
    actual val locationID: Int,
    actual val graphicID: Int
) {
    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is maplocationscene)
            return false
        return locationID == other.locationID
    }


    actual override fun hashCode() = locationID


    @Serializer(maplocationscene::class)
    actual companion object : KSerializer<maplocationscene> {
        actual fun getItem(id: Int): maplocationscene = callEndpoint(this::getItem, requestClient, id)
        actual fun allItems(): List<maplocationscene> = callEndpoint(this::allItems, requestClient)
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("maplocationscene") {
            init {
                addElement("locationID")
                addElement("graphicID")
            }
        }

        actual override fun serialize(output: Encoder, obj: maplocationscene) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.locationID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.graphicID.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): maplocationscene {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var temp_locationID: Int? = null
            var temp_graphicID: Int? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> temp_locationID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    1 -> temp_graphicID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    else -> if (i < descriptor.elementsCount) continue@loop else throw SerializationException("Unknown index $i")
                }
            }

            inp.endStructure(descriptor)

            return maplocationscene(
                temp_locationID ?: throw SerializationException("Missing value for locationID"),
                temp_graphicID ?: throw SerializationException("Missing value for graphicID")
            )
        }

        actual fun serializer(): KSerializer<maplocationscene> = this
    }
}

