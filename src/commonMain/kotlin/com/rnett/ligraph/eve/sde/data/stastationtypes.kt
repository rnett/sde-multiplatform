
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

expect class stastationtype {
    val stationTypeID: Int
    val dockEntryX: Double
    val dockEntryY: Double
    val dockEntryZ: Double
    val dockOrientationX: Double
    val dockOrientationY: Double
    val dockOrientationZ: Double
    val operationID: Int
    val officeSlots: Int
    val reprocessingEfficiency: Double
    val conquerable: Boolean

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int

    @Serializer(stastationtype::class)
    companion object : KSerializer<stastationtype> {
        fun getItem(id: Int): stastationtype
        fun allItems(): List<stastationtype>
        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: stastationtype)

        override fun deserialize(input: Decoder): stastationtype

        fun serializer(): KSerializer<stastationtype>
    }
}

