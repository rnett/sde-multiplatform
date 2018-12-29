
package com.rnett.ligraph.eve.sde.data


import com.rnett.kframe.data.callEndpoint
import com.rnett.ligraph.eve.sde.requestClient
import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

actual data class planetschematic(
    actual val schematicID: Int,
    actual val schematicName: String,
    actual val cycleTime: Int
) {
    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is planetschematic)
            return false
        return schematicID == other.schematicID
    }


    actual override fun hashCode() = schematicID


    actual override fun toString() = schematicName

    @Serializer(planetschematic::class)
    actual companion object : KSerializer<planetschematic> {
        actual fun getItem(id: Int): planetschematic = callEndpoint(this::getItem, requestClient, id)
        actual fun allItems(): List<planetschematic> = callEndpoint(this::allItems, requestClient)
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("planetschematic") {
            init {
                addElement("schematicID")
                addElement("schematicName")
                addElement("cycleTime")
            }
        }

        actual override fun serialize(output: Encoder, obj: planetschematic) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.schematicID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.schematicName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.cycleTime.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): planetschematic {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var temp_schematicID: Int? = null
            var temp_schematicName: String? = null
            var temp_cycleTime: Int? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> temp_schematicID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    1 -> temp_schematicName = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    2 -> temp_cycleTime =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    else -> if (i < descriptor.elementsCount) continue@loop else throw SerializationException("Unknown index $i")
                }
            }

            inp.endStructure(descriptor)

            return planetschematic(
                temp_schematicID ?: throw SerializationException("Missing value for schematicID"),
                temp_schematicName ?: throw SerializationException("Missing value for schematicName"),
                temp_cycleTime ?: throw SerializationException("Missing value for cycleTime")
            )
        }

        actual fun serializer(): KSerializer<planetschematic> = this
    }
}

