
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

expect class invmetagroup {
    val metaGroupID: Int
    val metaGroupName: String
    val description: String
    val iconID: Int

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
    override fun toString(): String

    @Serializer(invmetagroup::class)
    companion object : KSerializer<invmetagroup> {
        fun getItem(id: Int): invmetagroup
        fun allItems(): List<invmetagroup>
        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: invmetagroup)

        override fun deserialize(input: Decoder): invmetagroup

        fun serializer(): KSerializer<invmetagroup>
    }
}

