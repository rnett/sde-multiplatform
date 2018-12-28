package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

expect class stastation {
    val stationID: Long
    val security: Double
    val dockingCostPerVolume: Double
    val maxShipVolumeDockable: Double
    val officeRentalCost: Int
    val operationID: Int
    val stationTypeID: Int
    val corporationID: Int
    val solarSystemID: Int
    val constellationID: Int
    val regionID: Int
    val stationName: String
    val x: Double
    val y: Double
    val z: Double
    val reprocessingEfficiency: Double
    val reprocessingStationsTake: Double
    val reprocessingHangarFlag: Int

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
    override fun toString(): String

    @Serializer(stastation::class)
    companion object : KSerializer<stastation> {
        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: stastation)

        override fun deserialize(input: Decoder): stastation

        fun serializer(): KSerializer<stastation>
    }
}

