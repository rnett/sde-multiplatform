
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

@Serializable(with = invcontroltowerresourcepurpose.Companion::class)
expect class invcontroltowerresourcepurpose {
    val purpose: Int
    val purposeText: String

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int

    @Serializer(invcontroltowerresourcepurpose::class)
    companion object : KSerializer<invcontroltowerresourcepurpose> {
        fun getItem(id: Int): invcontroltowerresourcepurpose
        fun allItems(): List<invcontroltowerresourcepurpose>


        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: invcontroltowerresourcepurpose)

        override fun deserialize(input: Decoder): invcontroltowerresourcepurpose

        fun serializer(): KSerializer<invcontroltowerresourcepurpose>
    }
}

operator fun invcontroltowerresourcepurpose.Companion.get(id: Int) = getItem(id)
operator fun invcontroltowerresourcepurpose.Companion.invoke() = allItems()


