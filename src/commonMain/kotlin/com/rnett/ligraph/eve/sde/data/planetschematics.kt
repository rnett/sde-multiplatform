
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

@Serializable(with = planetschematic.Companion::class)
expect class planetschematic {
    val schematicID: Int
    val schematicName: String
    val cycleTime: Int

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
    override fun toString(): String

    @Serializer(planetschematic::class)
    companion object : KSerializer<planetschematic> {
        fun getItem(id: Int): planetschematic
        fun allItems(): List<planetschematic>


        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: planetschematic)

        override fun deserialize(input: Decoder): planetschematic

        fun serializer(): KSerializer<planetschematic>
    }
}
operator fun planetschematic.Companion.get(id: Int) = getItem(id)
operator fun planetschematic.Companion.invoke() = allItems()


