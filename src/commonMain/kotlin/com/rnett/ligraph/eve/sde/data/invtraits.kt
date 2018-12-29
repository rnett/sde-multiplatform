
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

@Serializable(with = invtrait.Companion::class)
expect class invtrait {
    val traitID: Int
    val typeID: Int
    val skillID: Int
    val bonus: Double
    val bonusText: String
    val unitID: Int

    val type: invtype
    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int

    @Serializer(invtrait::class)
    companion object : KSerializer<invtrait> {
        fun getItem(id: Int): invtrait
        fun allItems(): List<invtrait>

        fun getType(item: invtrait): invtype


        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: invtrait)

        override fun deserialize(input: Decoder): invtrait

        fun serializer(): KSerializer<invtrait>
    }
}

operator fun invtrait.Companion.get(id: Int) = getItem(id)
operator fun invtrait.Companion.invoke() = allItems()


