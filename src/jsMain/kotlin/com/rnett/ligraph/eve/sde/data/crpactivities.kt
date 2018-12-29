
package com.rnett.ligraph.eve.sde.data


import com.rnett.kframe.data.callEndpoint
import com.rnett.ligraph.eve.sde.requestClient
import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

@Serializable(with = crpactivity.Companion::class)
actual data class crpactivity(
    actual val activityID: Int,
    actual val activityName: String,
    actual val description: String
) {


    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is crpactivity)
            return false
        return activityID == other.activityID
    }


    actual override fun hashCode() = activityID


    actual override fun toString() = activityName

    @Serializer(crpactivity::class)
    actual companion object : KSerializer<crpactivity> {
        actual fun getItem(id: Int): crpactivity = callEndpoint(this::getItem, requestClient, id)
        actual fun allItems(): List<crpactivity> = callEndpoint(this::allItems, requestClient)


        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("crpactivity") {
            init {
                addElement("activityID")
                addElement("activityName")
                addElement("description")
            }
        }

        actual override fun serialize(output: Encoder, obj: crpactivity) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.activityID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.activityName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.description.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): crpactivity {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var temp_activityID: Int? = null
            var temp_activityName: String? = null
            var temp_description: String? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> temp_activityID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    1 -> temp_activityName = stringFromUtf8Bytes(
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
                    else -> if (i < descriptor.elementsCount) continue@loop else throw SerializationException("Unknown index $i")
                }
            }

            inp.endStructure(descriptor)

            return crpactivity(
                temp_activityID ?: throw SerializationException("Missing value for activityID"),
                temp_activityName ?: throw SerializationException("Missing value for activityName"),
                temp_description ?: throw SerializationException("Missing value for description")
            )
        }

        actual fun serializer(): KSerializer<crpactivity> = this
    }
}

