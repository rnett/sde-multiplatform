
package com.rnett.ligraph.eve.sde.data


import com.rnett.kframe.data.callEndpoint
import com.rnett.ligraph.eve.sde.requestClient
import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

@Serializable(with = invmetatype.Companion::class)
actual data class invmetatype(
    actual val typeID: Int,
    actual val parentTypeID: Int,
    actual val metaGroupID: Int
) {


    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is invmetatype)
            return false
        return typeID == other.typeID
    }


    actual override fun hashCode() = typeID


    @Serializer(invmetatype::class)
    actual companion object : KSerializer<invmetatype> {
        actual fun getItem(id: Int): invmetatype = callEndpoint(this::getItem, requestClient, id)
        actual fun allItems(): List<invmetatype> = callEndpoint(this::allItems, requestClient)


        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("invmetatype") {
            init {
                addElement("typeID")
                addElement("parentTypeID")
                addElement("metaGroupID")
            }
        }

        actual override fun serialize(output: Encoder, obj: invmetatype) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.typeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.parentTypeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.metaGroupID.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): invmetatype {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var temp_typeID: Int? = null
            var temp_parentTypeID: Int? = null
            var temp_metaGroupID: Int? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> temp_typeID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    1 -> temp_parentTypeID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    2 -> temp_metaGroupID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    else -> if (i < descriptor.elementsCount) continue@loop else throw SerializationException("Unknown index $i")
                }
            }

            inp.endStructure(descriptor)

            return invmetatype(
                temp_typeID ?: throw SerializationException("Missing value for typeID"),
                temp_parentTypeID ?: throw SerializationException("Missing value for parentTypeID"),
                temp_metaGroupID ?: throw SerializationException("Missing value for metaGroupID")
            )
        }

        actual fun serializer(): KSerializer<invmetatype> = this
    }
}

