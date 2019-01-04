
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

object invtypes : IntIdTable("invtypes", "typeID") {
	// Database Columns

	val typeID = integer("typeID")//.primaryKey()
	val groupID = integer("groupID")
	val typeName = varchar("typeName", 100)
	val description = text("description")
	val mass = double("mass")
	val volume = double("volume")
	val capacity = double("capacity")
	val portionSize = integer("portionSize")
	val raceID = integer("raceID").nullable()
	val basePrice = decimal("basePrice", 19, 4).nullable()
	val published = bool("published")
	val marketGroupID = integer("marketGroupID").nullable()
	val iconID = integer("iconID").nullable()
	val soundID = integer("soundID").nullable()
	val graphicID = integer("graphicID")


	// Foreign/Imported Keys (One to Many)

	val group = reference("groupID", invgroups)
	val marketGroup = optReference("marketGroupID", invmarketgroups)


	// Referencing/Exported Keys (One to Many)

	// 2 keys.  Not present in object
}


@Serializable(with = invtype.Companion::class)
actual class invtype(val myId: EntityID<Int>) : IntEntity(myId) {

	@Serializer(invtype::class)
	actual companion object : IntEntityClass<invtype>(invtypes), KSerializer<invtype> {
		actual fun getItem(id: Int) = transaction { super.get(id) }
		actual fun allItems() = transaction { super.all().toList() }
		actual fun getGroup(item: invtype): invgroup = transaction { item.group }
		actual fun getMarketGroup(item: invtype): invmarketgroup? = transaction { item.marketGroup }
		actual fun getDgmexpressia(item: invtype): List<dgmexpression> = transaction { item.dgmexpressia }
		actual fun getInvtraits_rk(item: invtype): List<invtrait> = transaction { item.invtraits_rk }
		actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("invtype") {
			init {
				addElement("typeID")
				addElement("groupID")
				addElement("typeName")
				addElement("description")
				addElement("mass")
				addElement("volume")
				addElement("capacity")
				addElement("portionSize")
				addElement("raceID")
				addElement("basePrice")
				addElement("published")
				addElement("marketGroupID")
				addElement("iconID")
				addElement("soundID")
				addElement("graphicID")
			}
		}

		actual override fun serialize(output: Encoder, obj: invtype) {
			val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
			compositeOutput.encodeStringElement(
				descriptor,
				0,
				HexConverter.printHexBinary(obj.typeID.toString().toUtf8Bytes())
			)
			compositeOutput.encodeStringElement(
				descriptor,
				1,
				HexConverter.printHexBinary(obj.groupID.toString().toUtf8Bytes())
			)
			compositeOutput.encodeStringElement(
				descriptor,
				2,
				HexConverter.printHexBinary(obj.typeName.toString().toUtf8Bytes())
			)
			compositeOutput.encodeStringElement(
				descriptor,
				3,
				HexConverter.printHexBinary(obj.description.toString().toUtf8Bytes())
			)
			compositeOutput.encodeStringElement(
				descriptor,
				4,
				HexConverter.printHexBinary(obj.mass.toString().toUtf8Bytes())
			)
			compositeOutput.encodeStringElement(
				descriptor,
				5,
				HexConverter.printHexBinary(obj.volume.toString().toUtf8Bytes())
			)
			compositeOutput.encodeStringElement(
				descriptor,
				6,
				HexConverter.printHexBinary(obj.capacity.toString().toUtf8Bytes())
			)
			compositeOutput.encodeStringElement(
				descriptor,
				7,
				HexConverter.printHexBinary(obj.portionSize.toString().toUtf8Bytes())
			)
			compositeOutput.encodeStringElement(
				descriptor,
				8,
				HexConverter.printHexBinary(obj.raceID.toString().toUtf8Bytes())
			)
			compositeOutput.encodeStringElement(
				descriptor,
				9,
				HexConverter.printHexBinary(obj.basePrice.toString().toUtf8Bytes())
			)
			compositeOutput.encodeStringElement(
				descriptor,
				10,
				HexConverter.printHexBinary(obj.published.toString().toUtf8Bytes())
			)
			compositeOutput.encodeStringElement(
				descriptor,
				11,
				HexConverter.printHexBinary(obj.marketGroupID.toString().toUtf8Bytes())
			)
			compositeOutput.encodeStringElement(
				descriptor,
				12,
				HexConverter.printHexBinary(obj.iconID.toString().toUtf8Bytes())
			)
			compositeOutput.encodeStringElement(
				descriptor,
				13,
				HexConverter.printHexBinary(obj.soundID.toString().toUtf8Bytes())
			)
			compositeOutput.encodeStringElement(
				descriptor,
				14,
				HexConverter.printHexBinary(obj.graphicID.toString().toUtf8Bytes())
			)
			compositeOutput.endStructure(descriptor)
		}

		actual override fun deserialize(input: Decoder): invtype {
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
				throw SerializationException("Id 'typeID' @ index 0 not found")
			else
				return invtype[id]
		}

		actual fun serializer(): KSerializer<invtype> = this
	}

	// Database Columns

	actual val typeID by invtypes.typeID
	actual val groupID by invtypes.groupID
	actual val typeName by invtypes.typeName
	actual val description by invtypes.description
	actual val mass by invtypes.mass
	actual val volume by invtypes.volume
	actual val capacity by invtypes.capacity
	actual val portionSize by invtypes.portionSize
	actual val raceID by invtypes.raceID
	val basePriceBD by invtypes.basePrice
	actual val basePrice
		get() = basePriceBD?.toDouble()

	actual val published by invtypes.published
	actual val marketGroupID by invtypes.marketGroupID
	actual val iconID by invtypes.iconID
	actual val soundID by invtypes.soundID
	actual val graphicID by invtypes.graphicID


	// Foreign/Imported Keys (One to Many)

	actual val group: invgroup by invgroup referencedOn invtypes.group
	actual val marketGroup: invmarketgroup? by invmarketgroup optionalReferencedOn invtypes.marketGroup


	// Referencing/Exported Keys (One to Many)

	val _dgmexpressia: SizedIterable<dgmexpression> by dgmexpression referrersOn dgmexpressions.expressionType
	actual val dgmexpressia: List<dgmexpression> get() = _dgmexpressia.toList()

	val _invtraits_rk: SizedIterable<invtrait> by invtrait referrersOn invtraits.type
	actual val invtraits_rk: List<invtrait> get() = _invtraits_rk.toList()



	// Helper Methods

	actual override fun equals(other: Any?): Boolean {
		if (other == null || other !is invtype)
			return false
		return typeID == other.typeID
	}


	actual override fun hashCode() = typeID 


	actual override fun toString() = typeName
}

