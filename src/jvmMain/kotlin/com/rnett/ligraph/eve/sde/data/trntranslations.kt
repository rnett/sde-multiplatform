package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable

object trntranslations : IntIdTable("trntranslations", "tcID") {
    // Database Columns

    val tcID = integer("tcID").primaryKey(1)
    val keyID = integer("keyID").primaryKey(2)
    val languageID = varchar("languageID", 50).primaryKey(3)
    val text = text("text")
}


actual class trntranslation(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(trntranslation::class)
    actual companion object : IntEntityClass<trntranslation>(trntranslations), KSerializer<trntranslation> {
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("trntranslation") {
            init {
                addElement("tcID")
                addElement("keyID")
                addElement("languageID")
                addElement("text")
            }
        }

        actual override fun serialize(output: Encoder, obj: trntranslation) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.tcID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.keyID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.languageID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.text.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): trntranslation {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var id: Int? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> id = stringFromUtf8Bytes(
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
            if (id == null)
                throw SerializationException("Id 'tcID' @ index 0 not found")
            else
                return trntranslation[id]
        }

        actual fun serializer(): KSerializer<trntranslation> = this
    }

    // Database Columns

    actual val tcID by trntranslations.tcID
    actual val keyID by trntranslations.keyID
    actual val languageID by trntranslations.languageID
    actual val text by trntranslations.text


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is trntranslation)
            return false
        return tcID == other.tcID
    }


    actual override fun hashCode() = tcID


}

