package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

expect class skinlicense {
    val licenseTypeID: Int
    val duration: Int
    val skinID: Int

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int

    @Serializer(skinlicense::class)
    companion object : KSerializer<skinlicense> {
        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: skinlicense)

        override fun deserialize(input: Decoder): skinlicense

        fun serializer(): KSerializer<skinlicense>
    }
}

