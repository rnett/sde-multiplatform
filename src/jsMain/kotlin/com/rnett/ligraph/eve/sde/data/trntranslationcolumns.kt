package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

actual data class trntranslationcolumn(
    actual val tcGroupID: Int,
    actual val tcID: Int,
    actual val tableName: String,
    actual val columnName: String,
    actual val masterID: String
) {
    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is trntranslationcolumn)
            return false
        return tcID == other.tcID
    }


    actual override fun hashCode() = tcID


    @Serializer(trntranslationcolumn::class)
    actual companion object : KSerializer<trntranslationcolumn> {
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("trntranslationcolumn") {
            init {
                addElement("tcGroupID")
                addElement("tcID")
                addElement("tableName")
                addElement("columnName")
                addElement("masterID")
            }
        }

        actual override fun serialize(output: Encoder, obj: trntranslationcolumn) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.tcGroupID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.tcID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.tableName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.columnName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                4,
                HexConverter.printHexBinary(obj.masterID.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): trntranslationcolumn {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var temp_tcGroupID: Int? = null
            var temp_tcID: Int? = null
            var temp_tableName: String? = null
            var temp_columnName: String? = null
            var temp_masterID: String? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> temp_tcGroupID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    1 -> temp_tcID = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    2 -> temp_tableName = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    3 -> temp_columnName = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    4 -> temp_masterID = stringFromUtf8Bytes(
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

            return trntranslationcolumn(
                temp_tcGroupID ?: throw SerializationException("Missing value for tcGroupID"),
                temp_tcID ?: throw SerializationException("Missing value for tcID"),
                temp_tableName ?: throw SerializationException("Missing value for tableName"),
                temp_columnName ?: throw SerializationException("Missing value for columnName"),
                temp_masterID ?: throw SerializationException("Missing value for masterID")
            )
        }

        actual fun serializer(): KSerializer<trntranslationcolumn> = this
    }
}

