
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.SizedIterable
import org.jetbrains.exposed.sql.transactions.transaction

object dgmattributetypes : IntIdTable("dgmattributetypes", "attributeID") {
    // Database Columns

    val attributeID = integer("attributeID").primaryKey()
    val attributeName = varchar("attributeName", 100)
    val description = varchar("description", 1000)
    val iconID = integer("iconID")
    val defaultValue = double("defaultValue")
    val published = bool("published")
    val displayName = varchar("displayName", 150)
    val unitID = integer("unitID")
    val stackable = bool("stackable")
    val highIsGood = bool("highIsGood")
    val categoryID = integer("categoryID")


    // Referencing/Exported Keys (One to Many)

    // 1 keys.  Not present in object
}


@Serializable(with = dgmattributetype.Companion::class)
actual class dgmattributetype(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(dgmattributetype::class)
    actual companion object : IntEntityClass<dgmattributetype>(dgmattributetypes), KSerializer<dgmattributetype> {
        actual fun getItem(id: Int) = transaction { super.get(id) }
        actual fun allItems() = transaction { super.all().toList() }
        actual fun getDgmexpressia(item: dgmattributetype): List<dgmexpression> = transaction { item.dgmexpressia }
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("dgmattributetype") {
            init {
                addElement("attributeID")
                addElement("attributeName")
                addElement("description")
                addElement("iconID")
                addElement("defaultValue")
                addElement("published")
                addElement("displayName")
                addElement("unitID")
                addElement("stackable")
                addElement("highIsGood")
                addElement("categoryID")
            }
        }

        actual override fun serialize(output: Encoder, obj: dgmattributetype) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.attributeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.attributeName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.description.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.iconID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                4,
                HexConverter.printHexBinary(obj.defaultValue.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                5,
                HexConverter.printHexBinary(obj.published.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                6,
                HexConverter.printHexBinary(obj.displayName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                7,
                HexConverter.printHexBinary(obj.unitID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                8,
                HexConverter.printHexBinary(obj.stackable.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                9,
                HexConverter.printHexBinary(obj.highIsGood.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                10,
                HexConverter.printHexBinary(obj.categoryID.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): dgmattributetype {
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
                throw SerializationException("Id 'attributeID' @ index 0 not found")
            else
                return dgmattributetype[id]
        }

        actual fun serializer(): KSerializer<dgmattributetype> = this
    }

    // Database Columns

    actual val attributeID by dgmattributetypes.attributeID
    actual val attributeName by dgmattributetypes.attributeName
    actual val description by dgmattributetypes.description
    actual val iconID by dgmattributetypes.iconID
    actual val defaultValue by dgmattributetypes.defaultValue
    actual val published by dgmattributetypes.published
    actual val displayName by dgmattributetypes.displayName
    actual val unitID by dgmattributetypes.unitID
    actual val stackable by dgmattributetypes.stackable
    actual val highIsGood by dgmattributetypes.highIsGood
    actual val categoryID by dgmattributetypes.categoryID


    // Referencing/Exported Keys (One to Many)

    val _dgmexpressia: SizedIterable<dgmexpression> by dgmexpression referrersOn dgmexpressions.expressionAttribute
    actual val dgmexpressia: List<dgmexpression> get() = _dgmexpressia.toList()


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is dgmattributetype)
            return false
        return attributeID == other.attributeID
    }


    actual override fun hashCode() = attributeID


}

