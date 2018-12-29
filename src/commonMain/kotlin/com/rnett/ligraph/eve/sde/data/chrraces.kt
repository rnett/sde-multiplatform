
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

@Serializable(with = chrrace.Companion::class)
expect class chrrace {
    val raceID: Int
    val raceName: String
    val description: String
    val iconID: Int
    val shortDescription: String

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
    override fun toString(): String

    @Serializer(chrrace::class)
    companion object : KSerializer<chrrace> {
        fun getItem(id: Int): chrrace
        fun allItems(): List<chrrace>


        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: chrrace)

        override fun deserialize(input: Decoder): chrrace

        fun serializer(): KSerializer<chrrace>
    }
}

operator fun chrrace.Companion.get(id: Int) = getItem(id)
operator fun chrrace.Companion.invoke() = allItems()


