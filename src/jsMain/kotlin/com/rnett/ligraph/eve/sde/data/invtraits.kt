
package com.rnett.ligraph.eve.sde.data


import com.rnett.kframe.data.callEndpoint
import com.rnett.ligraph.eve.sde.requestClient
import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

actual data class invtrait(
    actual val traitID: Int,
    actual val typeID: Int,
    actual val skillID: Int,
    actual val bonus: Double,
    actual val bonusText: String,
    actual val unitID: Int
) {
    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is invtrait)
            return false
        return traitID == other.traitID
    }


    actual override fun hashCode() = traitID


    @Serializer(invtrait::class)
    actual companion object : KSerializer<invtrait> {
        actual fun getItem(id: Int): invtrait = callEndpoint(this::getItem, requestClient, id)
        actual fun allItems(): List<invtrait> = callEndpoint(this::allItems, requestClient)
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("invtrait") {
            init {
                addElement("traitID")
                addElement("typeID")
                addElement("skillID")
                addElement("bonus")
                addElement("bonusText")
                addElement("unitID")
            }
        }

        actual override fun serialize(output: Encoder, obj: invtrait) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.traitID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.typeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.skillID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.bonus.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                4,
                HexConverter.printHexBinary(obj.bonusText.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                5,
                HexConverter.printHexBinary(obj.unitID.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): invtrait {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var temp_traitID: Int? = null
            var temp_typeID: Int? = null
            var temp_skillID: Int? = null
            var temp_bonus: Double? = null
            var temp_bonusText: String? = null
            var temp_unitID: Int? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> temp_traitID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    1 -> temp_typeID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    2 -> temp_skillID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    3 -> temp_bonus = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    4 -> temp_bonusText = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    5 -> temp_unitID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    else -> if (i < descriptor.elementsCount) continue@loop else throw SerializationException("Unknown index $i")
                }
            }

            inp.endStructure(descriptor)

            return invtrait(
                temp_traitID ?: throw SerializationException("Missing value for traitID"),
                temp_typeID ?: throw SerializationException("Missing value for typeID"),
                temp_skillID ?: throw SerializationException("Missing value for skillID"),
                temp_bonus ?: throw SerializationException("Missing value for bonus"),
                temp_bonusText ?: throw SerializationException("Missing value for bonusText"),
                temp_unitID ?: throw SerializationException("Missing value for unitID")
            )
        }

        actual fun serializer(): KSerializer<invtrait> = this
    }
}

