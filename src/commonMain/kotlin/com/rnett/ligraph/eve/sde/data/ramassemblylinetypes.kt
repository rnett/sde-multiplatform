
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

expect class ramassemblylinetype {
    val assemblyLineTypeID: Int
    val assemblyLineTypeName: String
    val description: String
    val baseTimeMultiplier: Double
    val baseMaterialMultiplier: Double
    val baseCostMultiplier: Double
    val volume: Double
    val activityID: Int
    val minCostPerHour: Double

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
    override fun toString(): String

    @Serializer(ramassemblylinetype::class)
    companion object : KSerializer<ramassemblylinetype> {
        fun getItem(id: Int): ramassemblylinetype
        fun allItems(): List<ramassemblylinetype>
        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: ramassemblylinetype)

        override fun deserialize(input: Decoder): ramassemblylinetype

        fun serializer(): KSerializer<ramassemblylinetype>
    }
}

