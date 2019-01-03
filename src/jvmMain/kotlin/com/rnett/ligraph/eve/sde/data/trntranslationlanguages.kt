
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.transactions.transaction

object trntranslationlanguages : IntIdTable("trntranslationlanguages", "numericLanguageID") {
    // Database Columns

    val numericLanguageID = integer("numericLanguageID")//.primaryKey()
    val languageID = varchar("languageID", 50)
    val languageName = varchar("languageName", 200)
}


@Serializable(with = trntranslationlanguage.Companion::class)
actual class trntranslationlanguage(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(trntranslationlanguage::class)
    actual companion object : IntEntityClass<trntranslationlanguage>(trntranslationlanguages),
        KSerializer<trntranslationlanguage> {
        actual fun getItem(id: Int) = transaction { super.get(id) }
        actual fun allItems() = transaction { super.all().toList() }
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("trntranslationlanguage") {
            init {
                addElement("numericLanguageID")
                addElement("languageID")
                addElement("languageName")
            }
        }

        actual override fun serialize(output: Encoder, obj: trntranslationlanguage) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.numericLanguageID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.languageID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.languageName.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): trntranslationlanguage {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var id: Int? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> id =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    else -> if (i < descriptor.elementsCount) continue@loop else throw SerializationException("Unknown index $i")
                }
            }

            inp.endStructure(descriptor)
            if (id == null)
                throw SerializationException("Id 'numericLanguageID' @ index 0 not found")
            else
                return trntranslationlanguage[id]
        }

        actual fun serializer(): KSerializer<trntranslationlanguage> = this
    }

    // Database Columns

    actual val numericLanguageID by trntranslationlanguages.numericLanguageID
    actual val languageID by trntranslationlanguages.languageID
    actual val languageName by trntranslationlanguages.languageName


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is trntranslationlanguage)
            return false
        return numericLanguageID == other.numericLanguageID
    }


    actual override fun hashCode() = numericLanguageID


    actual override fun toString() = languageName
}

