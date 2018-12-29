
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

expect class staoperation {
    val activityID: Int
    val operationID: Int
    val operationName: String
    val description: String
    val fringe: Int
    val corridor: Int
    val hub: Int
    val border: Int
    val ratio: Int
    val caldariStationTypeID: Int
    val minmatarStationTypeID: Int
    val amarrStationTypeID: Int
    val gallenteStationTypeID: Int
    val joveStationTypeID: Int

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
    override fun toString(): String

    @Serializer(staoperation::class)
    companion object : KSerializer<staoperation> {
        fun getItem(id: Int): staoperation
        fun allItems(): List<staoperation>
        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: staoperation)

        override fun deserialize(input: Decoder): staoperation

        fun serializer(): KSerializer<staoperation>
    }
}

