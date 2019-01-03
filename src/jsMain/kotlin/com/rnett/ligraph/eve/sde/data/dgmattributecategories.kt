
package com.rnett.ligraph.eve.sde.data


import com.rnett.kframe.data.callEndpoint
import com.rnett.ligraph.eve.sde.requestClient
import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

@Serializable(with = dgmattributecategory.Companion::class)
actual data class dgmattributecategory(
    actual val categoryID: Int,
    actual val categoryName: String,
    actual val categoryDescription: String
) {


    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is dgmattributecategory)
            return false
        return categoryID == other.categoryID
    }


    actual override fun hashCode() = categoryID


    actual override fun toString() = categoryName

    @Serializer(dgmattributecategory::class)
    actual companion object : KSerializer<dgmattributecategory> {
        actual fun getItem(id: Int): dgmattributecategory = callEndpoint(this::getItem, requestClient, id)
        actual fun allItems(): List<dgmattributecategory> = callEndpoint(this::allItems, requestClient)


        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("dgmattributecategory") {
            init {
                addElement("categoryID")
                addElement("categoryName")
                addElement("categoryDescription")
            }
        }

        actual override fun serialize(output: Encoder, obj: dgmattributecategory) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.categoryID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.categoryName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.categoryDescription.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): dgmattributecategory {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var temp_categoryID: Int? = null
            var temp_categoryName: String? = null
            var temp_categoryDescription: String? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> temp_categoryID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    1 -> temp_categoryName = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    2 -> temp_categoryDescription = stringFromUtf8Bytes(
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

            return dgmattributecategory(
                temp_categoryID ?: throw SerializationException("Missing value for categoryID"),
                temp_categoryName ?: throw SerializationException("Missing value for categoryName"),
                temp_categoryDescription ?: throw SerializationException("Missing value for categoryDescription")
            )
        }

        actual fun serializer(): KSerializer<dgmattributecategory> = this
    }
}

