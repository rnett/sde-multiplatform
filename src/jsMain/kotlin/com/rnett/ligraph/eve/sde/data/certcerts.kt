
package com.rnett.ligraph.eve.sde.data


import com.rnett.kframe.data.callEndpoint
import com.rnett.ligraph.eve.sde.requestClient
import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

@Serializable(with = certcert.Companion::class)
actual data class certcert(
    actual val certID: Int,
    actual val description: String,
    actual val groupID: Int,
    actual val name: String
) {


    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is certcert)
            return false
        return certID == other.certID
    }


    actual override fun hashCode() = certID


    actual override fun toString() = name

    @Serializer(certcert::class)
    actual companion object : KSerializer<certcert> {
        actual fun getItem(id: Int): certcert = callEndpoint(this::getItem, requestClient, id)
        actual fun allItems(): List<certcert> = callEndpoint(this::allItems, requestClient)


        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("certcert") {
            init {
                addElement("certID")
                addElement("description")
                addElement("groupID")
                addElement("name")
            }
        }

        actual override fun serialize(output: Encoder, obj: certcert) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.certID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.description.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.groupID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.name.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): certcert {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var temp_certID: Int? = null
            var temp_description: String? = null
            var temp_groupID: Int? = null
            var temp_name: String? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> temp_certID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    1 -> temp_description = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    2 -> temp_groupID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    3 -> temp_name = stringFromUtf8Bytes(
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

            return certcert(
                temp_certID ?: throw SerializationException("Missing value for certID"),
                temp_description ?: throw SerializationException("Missing value for description"),
                temp_groupID ?: throw SerializationException("Missing value for groupID"),
                temp_name ?: throw SerializationException("Missing value for name")
            )
        }

        actual fun serializer(): KSerializer<certcert> = this
    }
}

