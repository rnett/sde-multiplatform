
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

@Serializable(with = invcategory.Companion::class)
expect class invcategory {
	val categoryID: Int
	val categoryName: String
	val iconID: Int
	val published: Boolean

    val invgroups_rk: List<invgroup>
	override fun equals(other: Any?): Boolean
	override fun hashCode(): Int
	override fun toString(): String

    @Serializer(invcategory::class)
    companion object : KSerializer<invcategory> {
		fun getItem(id: Int): invcategory
		fun allItems(): List<invcategory>


        fun getInvgroups_rk(item: invcategory): List<invgroup>

        override val descriptor: SerialDescriptor

		override fun serialize(output: Encoder, obj: invcategory)

		override fun deserialize(input: Decoder): invcategory

		fun serializer(): KSerializer<invcategory>
	}
}
operator fun invcategory.Companion.get(id: Int) = getItem(id)
operator fun invcategory.Companion.invoke() = allItems()


