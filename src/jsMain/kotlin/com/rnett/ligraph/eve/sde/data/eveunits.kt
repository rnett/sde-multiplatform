
package com.rnett.ligraph.eve.sde.data


import com.rnett.kframe.data.callEndpoint
import com.rnett.ligraph.eve.sde.requestClient
import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

@Serializable(with = eveunit.Companion::class)
actual data class eveunit(
    actual val unitID: Int,
    actual val unitName: String,
    actual val displayName: String,
    actual val description: String
) {


    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is eveunit)
            return false
        return unitID == other.unitID
    }


    actual override fun hashCode() = unitID


    @Serializer(eveunit::class)
    actual companion object : KSerializer<eveunit> {
        actual fun getItem(id: Int): eveunit = callEndpoint(this::getItem, requestClient, id)
        actual fun allItems(): List<eveunit> = callEndpoint(this::allItems, requestClient)


        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("eveunit") {
            init {
                addElement("unitID")
                addElement("unitName")
                addElement("displayName")
                addElement("description")
            }
        }

        actual override fun serialize(output: Encoder, obj: eveunit) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.unitID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.unitName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.displayName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.description.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): eveunit {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var temp_unitID: Int? = null
            var temp_unitName: String? = null
            var temp_displayName: String? = null
            var temp_description: String? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> temp_unitID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    1 -> temp_unitName = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    2 -> temp_displayName = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    3 -> temp_description = stringFromUtf8Bytes(
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

            return eveunit(
                temp_unitID ?: throw SerializationException("Missing value for unitID"),
                temp_unitName ?: throw SerializationException("Missing value for unitName"),
                temp_displayName ?: throw SerializationException("Missing value for displayName"),
                temp_description ?: throw SerializationException("Missing value for description")
            )
        }

        actual fun serializer(): KSerializer<eveunit> = this
    }
}

