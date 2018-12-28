package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

expect class skinmaterial {
    val skinMaterialID: Int
    val displayNameID: Int
    val materialSetID: Int

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int

    @Serializer(skinmaterial::class)
    companion object : KSerializer<skinmaterial> {
        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: skinmaterial)

        override fun deserialize(input: Decoder): skinmaterial

        fun serializer(): KSerializer<skinmaterial>
    }
}

