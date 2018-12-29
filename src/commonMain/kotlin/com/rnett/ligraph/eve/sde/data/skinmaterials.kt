
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

@Serializable(with = skinmaterial.Companion::class)
expect class skinmaterial {
    val skinMaterialID: Int
    val displayNameID: Int
    val materialSetID: Int

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int

    @Serializer(skinmaterial::class)
    companion object : KSerializer<skinmaterial> {
        fun getItem(id: Int): skinmaterial
        fun allItems(): List<skinmaterial>


        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: skinmaterial)

        override fun deserialize(input: Decoder): skinmaterial

        fun serializer(): KSerializer<skinmaterial>
    }
}

operator fun skinmaterial.Companion.get(id: Int) = getItem(id)
operator fun skinmaterial.Companion.invoke() = allItems()


