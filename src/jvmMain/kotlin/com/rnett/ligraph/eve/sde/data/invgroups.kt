
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

object invgroups : IntIdTable("invgroups", "groupID") {
    // Database Columns

    val groupID = integer("groupID")//.primaryKey()
    val categoryID = integer("categoryID")
    val groupName = varchar("groupName", 100)
    val iconID = integer("iconID")
    val useBasePrice = bool("useBasePrice")
    val anchored = bool("anchored")
    val anchorable = bool("anchorable")
    val fittableNonSingleton = bool("fittableNonSingleton")
    val published = bool("published")


    // Foreign/Imported Keys (One to Many)

    val category = reference("categoryID", invcategories)


    // Referencing/Exported Keys (One to Many)

    // 2 keys.  Not present in object
}


@Serializable(with = invgroup.Companion::class)
actual class invgroup(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(invgroup::class)
    actual companion object : IntEntityClass<invgroup>(invgroups), KSerializer<invgroup> {
        actual fun getItem(id: Int) = transaction { super.get(id) }
        actual fun allItems() = transaction { super.all().toList() }
        actual fun getCategory(item: invgroup): invcategory = transaction { item.category }
        actual fun getDgmexpressia(item: invgroup): List<dgmexpression> = transaction { item.dgmexpressia }
        actual fun getInvtypes_rk(item: invgroup): List<invtype> = transaction { item.invtypes_rk }
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("invgroup") {
            init {
                addElement("groupID")
                addElement("categoryID")
                addElement("groupName")
                addElement("iconID")
                addElement("useBasePrice")
                addElement("anchored")
                addElement("anchorable")
                addElement("fittableNonSingleton")
                addElement("published")
            }
        }

        actual override fun serialize(output: Encoder, obj: invgroup) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.groupID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.categoryID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.groupName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.iconID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                4,
                HexConverter.printHexBinary(obj.useBasePrice.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                5,
                HexConverter.printHexBinary(obj.anchored.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                6,
                HexConverter.printHexBinary(obj.anchorable.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                7,
                HexConverter.printHexBinary(obj.fittableNonSingleton.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                8,
                HexConverter.printHexBinary(obj.published.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): invgroup {
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
                throw SerializationException("Id 'groupID' @ index 0 not found")
            else
                return invgroup[id]
        }

        actual fun serializer(): KSerializer<invgroup> = this
    }

    // Database Columns

    actual val groupID by invgroups.groupID
    actual val categoryID by invgroups.categoryID
    actual val groupName by invgroups.groupName
    actual val iconID by invgroups.iconID
    actual val useBasePrice by invgroups.useBasePrice
    actual val anchored by invgroups.anchored
    actual val anchorable by invgroups.anchorable
    actual val fittableNonSingleton by invgroups.fittableNonSingleton
    actual val published by invgroups.published


    // Foreign/Imported Keys (One to Many)

    actual val category: invcategory by invcategory referencedOn invgroups.category


    // Referencing/Exported Keys (One to Many)

    val _dgmexpressia: SizedIterable<dgmexpression> by dgmexpression referrersOn dgmexpressions.expressionGroup
    actual val dgmexpressia: List<dgmexpression> get() = _dgmexpressia.toList()

    val _invtypes_rk: SizedIterable<invtype> by invtype referrersOn invtypes.group
    actual val invtypes_rk: List<invtype> get() = _invtypes_rk.toList()


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is invgroup)
            return false
        return groupID == other.groupID
    }


    actual override fun hashCode() = groupID


    actual override fun toString() = groupName
}

