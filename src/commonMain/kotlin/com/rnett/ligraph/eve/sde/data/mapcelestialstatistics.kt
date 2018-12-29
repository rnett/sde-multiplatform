
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

expect class mapcelestialstatistic {
    val celestialID: Int
    val temperature: Double
    val spectralClass: String
    val luminosity: Double
    val age: Double
    val life: Double
    val orbitRadius: Double
    val eccentricity: Double
    val massDust: Double
    val massGas: Double
    val fragmented: Boolean
    val density: Double
    val surfaceGravity: Double
    val escapeVelocity: Double
    val orbitPeriod: Double
    val rotationRate: Double
    val locked: Boolean
    val pressure: Double
    val radius: Double
    val mass: Int

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int

    @Serializer(mapcelestialstatistic::class)
    companion object : KSerializer<mapcelestialstatistic> {
        fun getItem(id: Int): mapcelestialstatistic
        fun allItems(): List<mapcelestialstatistic>
        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: mapcelestialstatistic)

        override fun deserialize(input: Decoder): mapcelestialstatistic

        fun serializer(): KSerializer<mapcelestialstatistic>
    }
}

