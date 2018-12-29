
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

expect class mapsolarsystem {
    val regionID: Int
    val constellationID: Int
    val solarSystemID: Int
    val solarSystemName: String
    val x: Double
    val y: Double
    val z: Double
    val xMin: Double
    val xMax: Double
    val yMin: Double
    val yMax: Double
    val zMin: Double
    val zMax: Double
    val luminosity: Double
    val border: Boolean
    val fringe: Boolean
    val corridor: Boolean
    val hub: Boolean
    val international: Boolean
    val regional: Boolean
    val constellation: Boolean
    val security: Double
    val factionID: Int
    val radius: Double
    val sunTypeID: Int
    val securityClass: String

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
    override fun toString(): String

    @Serializer(mapsolarsystem::class)
    companion object : KSerializer<mapsolarsystem> {
        fun getItem(id: Int): mapsolarsystem
        fun allItems(): List<mapsolarsystem>
        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: mapsolarsystem)

        override fun deserialize(input: Decoder): mapsolarsystem

        fun serializer(): KSerializer<mapsolarsystem>
    }
}

