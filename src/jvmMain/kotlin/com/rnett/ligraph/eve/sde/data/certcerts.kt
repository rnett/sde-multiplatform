
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.transactions.transaction

object certcerts : IntIdTable("certcerts", "certID") {
    // Database Columns

    val certID = integer("certID").primaryKey()
    val description = text("description")
    val groupID = integer("groupID")
    val name = varchar("name", 255)
}


@Serializable(with = certcert.Companion::class)
actual class certcert(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(certcert::class)
    actual companion object : IntEntityClass<certcert>(certcerts), KSerializer<certcert> {
        actual fun getItem(id: Int) = transaction { super.get(id) }
        actual fun allItems() = transaction { super.all().toList() }
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("certcert") {
            init {
                addElement("certID")
                addElement("description")
                addElement("groupID")
                addElement("name")
            }
        }

        actual override fun serialize(output: Encoder, obj: certcert) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.certID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.description.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.groupID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.name.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): certcert {
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
                throw SerializationException("Id 'certID' @ index 0 not found")
            else
                return certcert[id]
        }

        actual fun serializer(): KSerializer<certcert> = this
    }

    // Database Columns

    actual val certID by certcerts.certID
    actual val description by certcerts.description
    actual val groupID by certcerts.groupID
    actual val name by certcerts.name


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is certcert)
            return false
        return certID == other.certID
    }


    actual override fun hashCode() = certID


    actual override fun toString() = name
}

