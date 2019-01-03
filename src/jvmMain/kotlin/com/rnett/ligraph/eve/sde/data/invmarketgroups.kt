
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

object invmarketgroups : IntIdTable("invmarketgroups", "marketGroupID") {
	// Database Columns

    val marketGroupID = integer("marketGroupID")//.primaryKey()
	val parentGroupID = integer("parentGroupID")
	val marketGroupName = varchar("marketGroupName", 100)
	val description = varchar("description", 3000)
	val iconID = integer("iconID")
	val hasTypes = bool("hasTypes")


	// Foreign/Imported Keys (One to Many)

	val parentGroup = reference("parentGroupID", invmarketgroups)


	// Referencing/Exported Keys (One to Many)

	// 2 keys.  Not present in object
}


@Serializable(with = invmarketgroup.Companion::class)
actual class invmarketgroup(val myId: EntityID<Int>) : IntEntity(myId) {

	@Serializer(invmarketgroup::class)
    actual companion object : IntEntityClass<invmarketgroup>(invmarketgroups), KSerializer<invmarketgroup> {
        actual fun getItem(id: Int) = transaction { super.get(id) }
        actual fun allItems() = transaction { super.all().toList() }
        actual fun getParentGroup(item: invmarketgroup): invmarketgroup = transaction { item.parentGroup }
        actual fun getInvmarketgroups_rk(item: invmarketgroup): List<invmarketgroup> =
            transaction { item.invmarketgroups_rk }

        actual fun getInvtypes_rk(item: invmarketgroup): List<invtype> = transaction { item.invtypes_rk }
		actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("invmarketgroup") {
            init {
				addElement("marketGroupID")
				addElement("parentGroupID")
				addElement("marketGroupName")
				addElement("description")
				addElement("iconID")
				addElement("hasTypes")
			}
		}

		actual override fun serialize(output: Encoder, obj: invmarketgroup) {
			val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.marketGroupID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.parentGroupID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.marketGroupName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.description.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                4,
                HexConverter.printHexBinary(obj.iconID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                5,
                HexConverter.printHexBinary(obj.hasTypes.toString().toUtf8Bytes())
            )
			compositeOutput.endStructure(descriptor)
		}

		actual override fun deserialize(input: Decoder): invmarketgroup {
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
				throw SerializationException("Id 'marketGroupID' @ index 0 not found")
			else
				return invmarketgroup[id]
		}

		actual fun serializer(): KSerializer<invmarketgroup> = this
	}

	// Database Columns

	actual val marketGroupID by invmarketgroups.marketGroupID
	actual val parentGroupID by invmarketgroups.parentGroupID
	actual val marketGroupName by invmarketgroups.marketGroupName
	actual val description by invmarketgroups.description
	actual val iconID by invmarketgroups.iconID
	actual val hasTypes by invmarketgroups.hasTypes


	// Foreign/Imported Keys (One to Many)

	actual val parentGroup: invmarketgroup by invmarketgroup referencedOn invmarketgroups.parentGroup


	// Referencing/Exported Keys (One to Many)

	val _invmarketgroups_rk: SizedIterable<invmarketgroup> by invmarketgroup referrersOn invmarketgroups.parentGroup
	actual val invmarketgroups_rk: List<invmarketgroup> get() = _invmarketgroups_rk.toList()

	val _invtypes_rk: SizedIterable<invtype> by invtype referrersOn invtypes.marketGroup
	actual val invtypes_rk: List<invtype> get() = _invtypes_rk.toList()



	// Helper Methods

	actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is invmarketgroup)
			return false
		return marketGroupID == other.marketGroupID
	}


    actual override fun hashCode() = marketGroupID


	actual override fun toString() = marketGroupName
}

