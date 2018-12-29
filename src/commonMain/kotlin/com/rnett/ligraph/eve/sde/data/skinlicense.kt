
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

@Serializable(with = skinlicense.Companion::class)
expect class skinlicense {
    val licenseTypeID: Int
    val duration: Int
    val skinID: Int

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int

    @Serializer(skinlicense::class)
    companion object : KSerializer<skinlicense> {
        fun getItem(id: Int): skinlicense
        fun allItems(): List<skinlicense>


        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: skinlicense)

        override fun deserialize(input: Decoder): skinlicense

        fun serializer(): KSerializer<skinlicense>
    }
}

operator fun skinlicense.Companion.get(id: Int) = getItem(id)
operator fun skinlicense.Companion.invoke() = allItems()


