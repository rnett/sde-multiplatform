
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

@Serializable(with = invgroup.Companion::class)
expect class invgroup {
	val groupID: Int
	val categoryID: Int
	val groupName: String
	val iconID: Int
	val useBasePrice: Boolean
	val anchored: Boolean
	val anchorable: Boolean
	val fittableNonSingleton: Boolean
	val published: Boolean

	val category: invcategory
	val dgmexpressia: List<dgmexpression>
	val invtypes_rk: List<invtype>
	override fun equals(other: Any?): Boolean
	override fun hashCode(): Int
	override fun toString(): String

	@Serializer(invgroup::class)
	companion object : KSerializer<invgroup> {
		fun getItem(id: Int): invgroup
		fun allItems(): List<invgroup>

		fun getCategory(item: invgroup): invcategory

		fun getDgmexpressia(item: invgroup): List<dgmexpression>
		fun getInvtypes_rk(item: invgroup): List<invtype>

		override val descriptor: SerialDescriptor

		override fun serialize(output: Encoder, obj: invgroup)

		override fun deserialize(input: Decoder): invgroup

		fun serializer(): KSerializer<invgroup>
	}
}

operator fun invgroup.Companion.get(id: Int) = getItem(id)
operator fun invgroup.Companion.invoke() = allItems()


