
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

@Serializable(with = invmarketgroup.Companion::class)
expect class invmarketgroup {
	val marketGroupID: Int
	val parentGroupID: Int
	val marketGroupName: String
	val description: String
	val iconID: Int
	val hasTypes: Boolean

	val parentGroup: invmarketgroup
	val invmarketgroups_rk: List<invmarketgroup>
	val invtypes_rk: List<invtype>
	override fun equals(other: Any?): Boolean
	override fun hashCode(): Int
	override fun toString(): String

	@Serializer(invmarketgroup::class)
	companion object : KSerializer<invmarketgroup> {
		fun getItem(id: Int): invmarketgroup
		fun allItems(): List<invmarketgroup>

		fun getParentGroup(item: invmarketgroup): invmarketgroup

		fun getInvmarketgroups_rk(item: invmarketgroup): List<invmarketgroup>
		fun getInvtypes_rk(item: invmarketgroup): List<invtype>

		override val descriptor: SerialDescriptor

		override fun serialize(output: Encoder, obj: invmarketgroup)

		override fun deserialize(input: Decoder): invmarketgroup

		fun serializer(): KSerializer<invmarketgroup>
	}
}

operator fun invmarketgroup.Companion.get(id: Int) = getItem(id)
operator fun invmarketgroup.Companion.invoke() = allItems()


