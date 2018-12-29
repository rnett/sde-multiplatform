
package com.rnett.ligraph.eve.sde.data


import com.rnett.kframe.data.callEndpoint
import com.rnett.ligraph.eve.sde.requestClient
import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

@Serializable(with = skin.Companion::class)
actual data class skin(
    actual val skinID: Int,
    actual val internalName: String,
    actual val skinMaterialID: Int
) {


    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is skin)
            return false
        return skinID == other.skinID
    }


    actual override fun hashCode() = skinID


    actual override fun toString() = internalName

    @Serializer(skin::class)
    actual companion object : KSerializer<skin> {
        actual fun getItem(id: Int): skin = callEndpoint(this::getItem, requestClient, id)
        actual fun allItems(): List<skin> = callEndpoint(this::allItems, requestClient)


        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("skin") {
            init {
                addElement("skinID")
                addElement("internalName")
                addElement("skinMaterialID")
            }
        }

        actual override fun serialize(output: Encoder, obj: skin) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.skinID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.internalName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.skinMaterialID.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): skin {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var temp_skinID: Int? = null
            var temp_internalName: String? = null
            var temp_skinMaterialID: Int? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> temp_skinID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    1 -> temp_internalName = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    2 -> temp_skinMaterialID = stringFromUtf8Bytes(
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

            return skin(
                temp_skinID ?: throw SerializationException("Missing value for skinID"),
                temp_internalName ?: throw SerializationException("Missing value for internalName"),
                temp_skinMaterialID ?: throw SerializationException("Missing value for skinMaterialID")
            )
        }

        actual fun serializer(): KSerializer<skin> = this
    }
}

