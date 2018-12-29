
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

expect class crpactivity {
	val activityID: Int
	val activityName: String
	val description: String

	override fun equals(other: Any?): Boolean
	override fun hashCode(): Int
	override fun toString(): String

	@Serializer(crpactivity::class)
	companion object : KSerializer<crpactivity> {
		fun getItem(id: Int): crpactivity
		fun allItems(): List<crpactivity>
		override val descriptor: SerialDescriptor

		override fun serialize(output: Encoder, obj: crpactivity)

		override fun deserialize(input: Decoder): crpactivity

		fun serializer(): KSerializer<crpactivity>
	}
}

