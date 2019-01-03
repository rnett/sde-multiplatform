
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

@Serializable(with = crpactivity.Companion::class)
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
operator fun crpactivity.Companion.get(id: Int) = getItem(id)
operator fun crpactivity.Companion.invoke() = allItems()


