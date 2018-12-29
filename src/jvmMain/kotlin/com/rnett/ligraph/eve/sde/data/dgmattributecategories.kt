
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.transactions.transaction

object dgmattributecategories : IntIdTable("dgmattributecategories", "categoryID") {
    // Database Columns

    val categoryID = integer("categoryID").primaryKey()
    val categoryName = varchar("categoryName", 50)
    val categoryDescription = varchar("categoryDescription", 200)
}


@Serializable(with = dgmattributecategory.Companion::class)
actual class dgmattributecategory(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(dgmattributecategory::class)
    actual companion object : IntEntityClass<dgmattributecategory>(dgmattributecategories),
        KSerializer<dgmattributecategory> {
        actual fun getItem(id: Int) = transaction { super.get(id) }
        actual fun allItems() = transaction { super.all().toList() }
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
                throw SerializationException("Id 'categoryID' @ index 0 not found")
            else
                return dgmattributecategory[id]
        }

        actual fun serializer(): KSerializer<dgmattributecategory> = this
    }

    // Database Columns

    actual val categoryID by dgmattributecategories.categoryID
    actual val categoryName by dgmattributecategories.categoryName
    actual val categoryDescription by dgmattributecategories.categoryDescription


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is dgmattributecategory)
            return false
        return categoryID == other.categoryID
    }


    actual override fun hashCode() = categoryID


    actual override fun toString() = categoryName
}

