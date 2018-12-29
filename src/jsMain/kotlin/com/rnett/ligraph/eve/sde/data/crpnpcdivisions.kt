
package com.rnett.ligraph.eve.sde.data


import com.rnett.kframe.data.callEndpoint
import com.rnett.ligraph.eve.sde.requestClient
import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

@Serializable(with = crpnpcdivision.Companion::class)
actual data class crpnpcdivision(
    actual val divisionID: Int,
    actual val divisionName: String,
    actual val description: String,
    actual val leaderType: String
) {


    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is crpnpcdivision)
            return false
        return divisionID == other.divisionID
    }


    actual override fun hashCode() = divisionID


    actual override fun toString() = divisionName

    @Serializer(crpnpcdivision::class)
    actual companion object : KSerializer<crpnpcdivision> {
        actual fun getItem(id: Int): crpnpcdivision = callEndpoint(this::getItem, requestClient, id)
        actual fun allItems(): List<crpnpcdivision> = callEndpoint(this::allItems, requestClient)


        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("crpnpcdivision") {
            init {
                addElement("divisionID")
                addElement("divisionName")
                addElement("description")
                addElement("leaderType")
            }
        }

        actual override fun serialize(output: Encoder, obj: crpnpcdivision) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.divisionID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.divisionName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.description.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.leaderType.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): crpnpcdivision {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var temp_divisionID: Int? = null
            var temp_divisionName: String? = null
            var temp_description: String? = null
            var temp_leaderType: String? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> temp_divisionID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    1 -> temp_divisionName = stringFromUtf8Bytes(
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
                    3 -> temp_leaderType = stringFromUtf8Bytes(
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

            return crpnpcdivision(
                temp_divisionID ?: throw SerializationException("Missing value for divisionID"),
                temp_divisionName ?: throw SerializationException("Missing value for divisionName"),
                temp_description ?: throw SerializationException("Missing value for description"),
                temp_leaderType ?: throw SerializationException("Missing value for leaderType")
            )
        }

        actual fun serializer(): KSerializer<crpnpcdivision> = this
    }
}

