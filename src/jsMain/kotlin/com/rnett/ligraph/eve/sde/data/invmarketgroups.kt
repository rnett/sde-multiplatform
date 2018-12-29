
package com.rnett.ligraph.eve.sde.data


import com.rnett.kframe.data.callEndpoint
import com.rnett.ligraph.eve.sde.requestClient
import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

@Serializable(with = invmarketgroup.Companion::class)
actual data class invmarketgroup(
	actual val marketGroupID: Int,
	actual val parentGroupID: Int,
	actual val marketGroupName: String,
	actual val description: String,
	actual val iconID: Int,
	actual val hasTypes: Boolean
) {
	actual val parentGroup: invmarketgroup get() = getParentGroup(this)
	actual val invmarketgroups_rk: List<invmarketgroup> get() = getInvmarketgroups_rk(this)
	actual val invtypes_rk: List<invtype> get() = getInvtypes_rk(this)


	actual override fun equals(other: Any?): Boolean {
		if (other == null || other !is invmarketgroup)
			return false
		return marketGroupID == other.marketGroupID
	}


	actual override fun hashCode() = marketGroupID


	actual override fun toString() = marketGroupName

	@Serializer(invmarketgroup::class)
	actual companion object : KSerializer<invmarketgroup> {
		actual fun getItem(id: Int): invmarketgroup = callEndpoint(this::getItem, requestClient, id)
		actual fun allItems(): List<invmarketgroup> = callEndpoint(this::allItems, requestClient)

		actual fun getParentGroup(item: invmarketgroup): invmarketgroup =
			callEndpoint(this::getParentGroup, requestClient, item)

		actual fun getInvmarketgroups_rk(item: invmarketgroup): List<invmarketgroup> =
			callEndpoint(this::getInvmarketgroups_rk, requestClient, item)

		actual fun getInvtypes_rk(item: invmarketgroup): List<invtype> =
			callEndpoint(this::getInvtypes_rk, requestClient, item)

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
			var temp_marketGroupID: Int? = null
			var temp_parentGroupID: Int? = null
			var temp_marketGroupName: String? = null
			var temp_description: String? = null
			var temp_iconID: Int? = null
			var temp_hasTypes: Boolean? = null
			loop@ while (true) {
				when (val i = inp.decodeElementIndex(descriptor)) {
					CompositeDecoder.READ_DONE -> break@loop
					0 -> temp_marketGroupID = stringFromUtf8Bytes(
						HexConverter.parseHexBinary(
							inp.decodeStringElement(
								descriptor,
								i
							)
						)
					).toInt()
					1 -> temp_parentGroupID = stringFromUtf8Bytes(
						HexConverter.parseHexBinary(
							inp.decodeStringElement(
								descriptor,
								i
							)
						)
					).toInt()
					2 -> temp_marketGroupName = stringFromUtf8Bytes(
						HexConverter.parseHexBinary(
							inp.decodeStringElement(
								descriptor,
								i
							)
						)
					).toString()
					3 -> temp_description = stringFromUtf8Bytes(
						HexConverter.parseHexBinary(
							inp.decodeStringElement(
								descriptor,
								i
							)
						)
					).toString()
					4 -> temp_iconID = stringFromUtf8Bytes(
						HexConverter.parseHexBinary(
							inp.decodeStringElement(
								descriptor,
								i
							)
						)
					).toInt()
					5 -> temp_hasTypes = stringFromUtf8Bytes(
						HexConverter.parseHexBinary(
							inp.decodeStringElement(
								descriptor,
								i
							)
						)
					).toBoolean()
					else -> if (i < descriptor.elementsCount) continue@loop else throw SerializationException("Unknown index $i")
				}
			}

			inp.endStructure(descriptor)

			return invmarketgroup(
				temp_marketGroupID ?: throw SerializationException("Missing value for marketGroupID"),
				temp_parentGroupID ?: throw SerializationException("Missing value for parentGroupID"),
				temp_marketGroupName ?: throw SerializationException("Missing value for marketGroupName"),
				temp_description ?: throw SerializationException("Missing value for description"),
				temp_iconID ?: throw SerializationException("Missing value for iconID"),
				temp_hasTypes ?: throw SerializationException("Missing value for hasTypes")
			)
		}

		actual fun serializer(): KSerializer<invmarketgroup> = this
	}
}

