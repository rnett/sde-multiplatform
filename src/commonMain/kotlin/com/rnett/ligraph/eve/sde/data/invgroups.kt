
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

expect class invgroup {
    val groupID: Int
    val categoryID: Int
    val groupName: String
    val iconID: Int
    val useBasePrice: Boolean
    val anchored: Boolean
    val anchorable: Boolean
    val fittableNonSingleton: Boolean
    val published: Boolean

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
    override fun toString(): String

    @Serializer(invgroup::class)
    companion object : KSerializer<invgroup> {
        fun getItem(id: Int): invgroup
        fun allItems(): List<invgroup>
        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: invgroup)

        override fun deserialize(input: Decoder): invgroup

        fun serializer(): KSerializer<invgroup>
    }
}

