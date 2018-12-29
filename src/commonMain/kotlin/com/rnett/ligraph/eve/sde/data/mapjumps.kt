
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

@Serializable(with = mapjump.Companion::class)
expect class mapjump {
    val stargateID: Int
    val destinationID: Int

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int

    @Serializer(mapjump::class)
    companion object : KSerializer<mapjump> {
        fun getItem(id: Int): mapjump
        fun allItems(): List<mapjump>


        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: mapjump)

        override fun deserialize(input: Decoder): mapjump

        fun serializer(): KSerializer<mapjump>
    }
}

operator fun mapjump.Companion.get(id: Int) = getItem(id)
operator fun mapjump.Companion.invoke() = allItems()


