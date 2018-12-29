
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

expect class chrbloodline {
    val bloodlineID: Int
    val bloodlineName: String
    val raceID: Int
    val description: String
    val maleDescription: String
    val femaleDescription: String
    val shipTypeID: Int
    val corporationID: Int
    val perception: Int
    val willpower: Int
    val charisma: Int
    val memory: Int
    val intelligence: Int
    val iconID: Int
    val shortDescription: String
    val shortMaleDescription: String
    val shortFemaleDescription: String

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
    override fun toString(): String

    @Serializer(chrbloodline::class)
    companion object : KSerializer<chrbloodline> {
        fun getItem(id: Int): chrbloodline
        fun allItems(): List<chrbloodline>
        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: chrbloodline)

        override fun deserialize(input: Decoder): chrbloodline

        fun serializer(): KSerializer<chrbloodline>
    }
}

