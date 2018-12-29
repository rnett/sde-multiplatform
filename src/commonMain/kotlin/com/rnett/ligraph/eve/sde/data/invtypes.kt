
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

@Serializable(with = invtype.Companion::class)
expect class invtype {
	val typeID: Int
	val groupID: Int
	val typeName: String
	val description: String
	val mass: Double
	val volume: Double
	val capacity: Double
	val portionSize: Int
	val raceID: Int
	val basePrice: Double
	val published: Boolean
	val marketGroupID: Int
	val iconID: Int
	val soundID: Int
	val graphicID: Int

	val group: invgroup
	val marketGroup: invmarketgroup
	val dgmexpressia: List<dgmexpression>
	val invtraits_rk: List<invtrait>
	override fun equals(other: Any?): Boolean
	override fun hashCode(): Int
	override fun toString(): String

	@Serializer(invtype::class)
	companion object : KSerializer<invtype> {
		fun getItem(id: Int): invtype
		fun allItems(): List<invtype>

		fun getGroup(item: invtype): invgroup
		fun getMarketGroup(item: invtype): invmarketgroup

		fun getDgmexpressia(item: invtype): List<dgmexpression>
		fun getInvtraits_rk(item: invtype): List<invtrait>
		
		override val descriptor: SerialDescriptor

		override fun serialize(output: Encoder, obj: invtype)

		override fun deserialize(input: Decoder): invtype

		fun serializer(): KSerializer<invtype>
	}
}

operator fun invtype.Companion.get(id: Int) = getItem(id)
operator fun invtype.Companion.invoke() = allItems()


