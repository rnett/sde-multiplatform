
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

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

