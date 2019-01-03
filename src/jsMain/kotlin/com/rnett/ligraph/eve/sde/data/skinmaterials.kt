
package com.rnett.ligraph.eve.sde.data


import com.rnett.kframe.data.callEndpoint
import com.rnett.ligraph.eve.sde.requestClient
import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

@Serializable(with = skinmaterial.Companion::class)
actual data class skinmaterial(
    actual val skinMaterialID: Int,
    actual val displayNameID: Int,
    actual val materialSetID: Int
) {


    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is skinmaterial)
            return false
        return skinMaterialID == other.skinMaterialID
    }


    actual override fun hashCode() = skinMaterialID


    @Serializer(skinmaterial::class)
    actual companion object : KSerializer<skinmaterial> {
        actual fun getItem(id: Int): skinmaterial = callEndpoint(this::getItem, requestClient, id)
        actual fun allItems(): List<skinmaterial> = callEndpoint(this::allItems, requestClient)


        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("skinmaterial") {
            init {
                addElement("skinMaterialID")
                addElement("displayNameID")
                addElement("materialSetID")
            }
        }

        actual override fun serialize(output: Encoder, obj: skinmaterial) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.skinMaterialID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.displayNameID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.materialSetID.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): skinmaterial {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var temp_skinMaterialID: Int? = null
            var temp_displayNameID: Int? = null
            var temp_materialSetID: Int? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> temp_skinMaterialID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    1 -> temp_displayNameID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    2 -> temp_materialSetID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    else -> if (i < descriptor.elementsCount) continue@loop else throw SerializationException("Unknown index $i")
                }
            }

            inp.endStructure(descriptor)

            return skinmaterial(
                temp_skinMaterialID ?: throw SerializationException("Missing value for skinMaterialID"),
                temp_displayNameID ?: throw SerializationException("Missing value for displayNameID"),
                temp_materialSetID ?: throw SerializationException("Missing value for materialSetID")
            )
        }

        actual fun serializer(): KSerializer<skinmaterial> = this
    }
}

