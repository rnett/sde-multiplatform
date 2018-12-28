package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

expect class invtype {
    val typeID: Int
    val groupID: Int
    val typeName: String
    val description: String
    val mass: Double
    val volume: Double
    val capacity: Double
    val portionSize: Int
    val raceID: Int
    val basePrice: Double
    val published: Boolean
    val marketGroupID: Int
    val iconID: Int
    val soundID: Int
    val graphicID: Int

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
    override fun toString(): String

    @Serializer(invtype::class)
    companion object : KSerializer<invtype> {
        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: invtype)

        override fun deserialize(input: Decoder): invtype

        fun serializer(): KSerializer<invtype>
    }
}
