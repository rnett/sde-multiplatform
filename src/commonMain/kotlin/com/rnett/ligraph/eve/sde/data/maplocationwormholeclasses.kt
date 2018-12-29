
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

@Serializable(with = maplocationwormholeclass.Companion::class)
expect class maplocationwormholeclass {
    val locationID: Int
    val wormholeClassID: Int

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int

    @Serializer(maplocationwormholeclass::class)
    companion object : KSerializer<maplocationwormholeclass> {
        fun getItem(id: Int): maplocationwormholeclass
        fun allItems(): List<maplocationwormholeclass>


        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: maplocationwormholeclass)

        override fun deserialize(input: Decoder): maplocationwormholeclass

        fun serializer(): KSerializer<maplocationwormholeclass>
    }
}

operator fun maplocationwormholeclass.Companion.get(id: Int) = getItem(id)
operator fun maplocationwormholeclass.Companion.invoke() = allItems()


