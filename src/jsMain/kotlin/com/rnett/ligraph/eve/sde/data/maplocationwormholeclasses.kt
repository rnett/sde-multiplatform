package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

actual data class maplocationwormholeclass(
    actual val locationID: Int,
    actual val wormholeClassID: Int
) {
    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is maplocationwormholeclass)
            return false
        return locationID == other.locationID
    }


    actual override fun hashCode() = locationID


    @Serializer(maplocationwormholeclass::class)
    actual companion object : KSerializer<maplocationwormholeclass> {
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("maplocationwormholeclass") {
            init {
                addElement("locationID")
                addElement("wormholeClassID")
            }
        }

        actual override fun serialize(output: Encoder, obj: maplocationwormholeclass) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.locationID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.wormholeClassID.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): maplocationwormholeclass {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var temp_locationID: Int? = null
            var temp_wormholeClassID: Int? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> temp_locationID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    1 -> temp_wormholeClassID = stringFromUtf8Bytes(
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

            return maplocationwormholeclass(
                temp_locationID ?: throw SerializationException("Missing value for locationID"),
                temp_wormholeClassID ?: throw SerializationException("Missing value for wormholeClassID")
            )
        }

        actual fun serializer(): KSerializer<maplocationwormholeclass> = this
    }
}

