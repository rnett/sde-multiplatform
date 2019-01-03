
package com.rnett.ligraph.eve.sde.data


import com.rnett.kframe.data.callEndpoint
import com.rnett.ligraph.eve.sde.requestClient
import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

@Serializable(with = evegraphic.Companion::class)
actual data class evegraphic(
    actual val graphicID: Int,
    actual val sofFactionName: String,
    actual val graphicFile: String,
    actual val sofHullName: String,
    actual val sofRaceName: String,
    actual val description: String
) {


    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is evegraphic)
            return false
        return graphicID == other.graphicID
    }


    actual override fun hashCode() = graphicID


    @Serializer(evegraphic::class)
    actual companion object : KSerializer<evegraphic> {
        actual fun getItem(id: Int): evegraphic = callEndpoint(this::getItem, requestClient, id)
        actual fun allItems(): List<evegraphic> = callEndpoint(this::allItems, requestClient)


        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("evegraphic") {
            init {
                addElement("graphicID")
                addElement("sofFactionName")
                addElement("graphicFile")
                addElement("sofHullName")
                addElement("sofRaceName")
                addElement("description")
            }
        }

        actual override fun serialize(output: Encoder, obj: evegraphic) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.graphicID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.sofFactionName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.graphicFile.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.sofHullName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                4,
                HexConverter.printHexBinary(obj.sofRaceName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                5,
                HexConverter.printHexBinary(obj.description.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): evegraphic {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var temp_graphicID: Int? = null
            var temp_sofFactionName: String? = null
            var temp_graphicFile: String? = null
            var temp_sofHullName: String? = null
            var temp_sofRaceName: String? = null
            var temp_description: String? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> temp_graphicID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    1 -> temp_sofFactionName = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    2 -> temp_graphicFile = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    3 -> temp_sofHullName = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    4 -> temp_sofRaceName = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    5 -> temp_description = stringFromUtf8Bytes(
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

            return evegraphic(
                temp_graphicID ?: throw SerializationException("Missing value for graphicID"),
                temp_sofFactionName ?: throw SerializationException("Missing value for sofFactionName"),
                temp_graphicFile ?: throw SerializationException("Missing value for graphicFile"),
                temp_sofHullName ?: throw SerializationException("Missing value for sofHullName"),
                temp_sofRaceName ?: throw SerializationException("Missing value for sofRaceName"),
                temp_description ?: throw SerializationException("Missing value for description")
            )
        }

        actual fun serializer(): KSerializer<evegraphic> = this
    }
}

