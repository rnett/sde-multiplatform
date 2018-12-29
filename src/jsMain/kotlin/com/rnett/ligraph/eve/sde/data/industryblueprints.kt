
package com.rnett.ligraph.eve.sde.data


import com.rnett.kframe.data.callEndpoint
import com.rnett.ligraph.eve.sde.requestClient
import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

@Serializable(with = industryblueprint.Companion::class)
actual data class industryblueprint(
    actual val typeID: Int,
    actual val maxProductionLimit: Int
) {


    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is industryblueprint)
            return false
        return typeID == other.typeID
    }


    actual override fun hashCode() = typeID


    @Serializer(industryblueprint::class)
    actual companion object : KSerializer<industryblueprint> {
        actual fun getItem(id: Int): industryblueprint = callEndpoint(this::getItem, requestClient, id)
        actual fun allItems(): List<industryblueprint> = callEndpoint(this::allItems, requestClient)


        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("industryblueprint") {
            init {
                addElement("typeID")
                addElement("maxProductionLimit")
            }
        }

        actual override fun serialize(output: Encoder, obj: industryblueprint) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.typeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.maxProductionLimit.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): industryblueprint {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var temp_typeID: Int? = null
            var temp_maxProductionLimit: Int? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> temp_typeID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    1 -> temp_maxProductionLimit = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    else -> if (i < descriptor.elementsCount) continue@loop else throw SerializationException("Unknown index $i")
                }
            }

            inp.endStructure(descriptor)

            return industryblueprint(
                temp_typeID ?: throw SerializationException("Missing value for typeID"),
                temp_maxProductionLimit ?: throw SerializationException("Missing value for maxProductionLimit")
            )
        }

        actual fun serializer(): KSerializer<industryblueprint> = this
    }
}

