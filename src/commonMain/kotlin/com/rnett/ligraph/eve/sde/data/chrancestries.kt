package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

expect class chrancestry {
    val ancestryID: Int
    val ancestryName: String
    val bloodlineID: Int
    val description: String
    val perception: Int
    val willpower: Int
    val charisma: Int
    val memory: Int
    val intelligence: Int
    val iconID: Int
    val shortDescription: String

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
    override fun toString(): String

    @Serializer(chrancestry::class)
    companion object : KSerializer<chrancestry> {
        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: chrancestry)

        override fun deserialize(input: Decoder): chrancestry

        fun serializer(): KSerializer<chrancestry>
    }
}

