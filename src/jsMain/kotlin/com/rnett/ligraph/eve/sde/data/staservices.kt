package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

actual data class staservice(
    actual val serviceID: Int,
    actual val serviceName: String,
    actual val description: String
) {
    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is staservice)
            return false
        return serviceID == other.serviceID
    }


    actual override fun hashCode() = serviceID


    actual override fun toString() = serviceName

    @Serializer(staservice::class)
    actual companion object : KSerializer<staservice> {
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("staservice") {
            init {
                addElement("serviceID")
                addElement("serviceName")
                addElement("description")
            }
        }

        actual override fun serialize(output: Encoder, obj: staservice) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.serviceID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.serviceName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.description.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): staservice {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var temp_serviceID: Int? = null
            var temp_serviceName: String? = null
            var temp_description: String? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> temp_serviceID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    1 -> temp_serviceName = stringFromUtf8Bytes(
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

            return staservice(
                temp_serviceID ?: throw SerializationException("Missing value for serviceID"),
                temp_serviceName ?: throw SerializationException("Missing value for serviceName"),
                temp_description ?: throw SerializationException("Missing value for description")
            )
        }

        actual fun serializer(): KSerializer<staservice> = this
    }
}

