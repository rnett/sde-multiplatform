
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

@Serializable(with = industryblueprint.Companion::class)
expect class industryblueprint {
    val typeID: Int
    val maxProductionLimit: Int

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int

    @Serializer(industryblueprint::class)
    companion object : KSerializer<industryblueprint> {
        fun getItem(id: Int): industryblueprint
        fun allItems(): List<industryblueprint>


        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: industryblueprint)

        override fun deserialize(input: Decoder): industryblueprint

        fun serializer(): KSerializer<industryblueprint>
    }
}
operator fun industryblueprint.Companion.get(id: Int) = getItem(id)
operator fun industryblueprint.Companion.invoke() = allItems()


