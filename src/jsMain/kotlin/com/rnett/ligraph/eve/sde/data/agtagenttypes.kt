
package com.rnett.ligraph.eve.sde.data


import com.rnett.kframe.data.callEndpoint
import com.rnett.ligraph.eve.sde.requestClient
import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

@Serializable(with = agtagenttype.Companion::class)
actual data class agtagenttype(
    actual val agentTypeID: Int,
    actual val agentType: String
) {


    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is agtagenttype)
            return false
        return agentTypeID == other.agentTypeID
    }


    actual override fun hashCode() = agentTypeID


    @Serializer(agtagenttype::class)
    actual companion object : KSerializer<agtagenttype> {
        actual fun getItem(id: Int): agtagenttype = callEndpoint(this::getItem, requestClient, id)
        actual fun allItems(): List<agtagenttype> = callEndpoint(this::allItems, requestClient)


        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("agtagenttype") {
            init {
                addElement("agentTypeID")
                addElement("agentType")
            }
        }

        actual override fun serialize(output: Encoder, obj: agtagenttype) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.agentTypeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.agentType.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): agtagenttype {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var temp_agentTypeID: Int? = null
            var temp_agentType: String? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> temp_agentTypeID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    1 -> temp_agentType = stringFromUtf8Bytes(
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

            return agtagenttype(
                temp_agentTypeID ?: throw SerializationException("Missing value for agentTypeID"),
                temp_agentType ?: throw SerializationException("Missing value for agentType")
            )
        }

        actual fun serializer(): KSerializer<agtagenttype> = this
    }
}

