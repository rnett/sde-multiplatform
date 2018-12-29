
package com.rnett.ligraph.eve.sde.data


import com.rnett.kframe.data.callEndpoint
import com.rnett.ligraph.eve.sde.requestClient
import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

@Serializable(with = chrrace.Companion::class)
actual data class chrrace(
    actual val raceID: Int,
    actual val raceName: String,
    actual val description: String,
    actual val iconID: Int,
    actual val shortDescription: String
) {


    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is chrrace)
            return false
        return raceID == other.raceID
    }


    actual override fun hashCode() = raceID


    actual override fun toString() = raceName

    @Serializer(chrrace::class)
    actual companion object : KSerializer<chrrace> {
        actual fun getItem(id: Int): chrrace = callEndpoint(this::getItem, requestClient, id)
        actual fun allItems(): List<chrrace> = callEndpoint(this::allItems, requestClient)


        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("chrrace") {
            init {
                addElement("raceID")
                addElement("raceName")
                addElement("description")
                addElement("iconID")
                addElement("shortDescription")
            }
        }

        actual override fun serialize(output: Encoder, obj: chrrace) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.raceID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.raceName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.description.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.iconID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                4,
                HexConverter.printHexBinary(obj.shortDescription.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): chrrace {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var temp_raceID: Int? = null
            var temp_raceName: String? = null
            var temp_description: String? = null
            var temp_iconID: Int? = null
            var temp_shortDescription: String? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> temp_raceID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    1 -> temp_raceName = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    2 -> temp_description = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    3 -> temp_iconID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    4 -> temp_shortDescription = stringFromUtf8Bytes(
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

            return chrrace(
                temp_raceID ?: throw SerializationException("Missing value for raceID"),
                temp_raceName ?: throw SerializationException("Missing value for raceName"),
                temp_description ?: throw SerializationException("Missing value for description"),
                temp_iconID ?: throw SerializationException("Missing value for iconID"),
                temp_shortDescription ?: throw SerializationException("Missing value for shortDescription")
            )
        }

        actual fun serializer(): KSerializer<chrrace> = this
    }
}

