package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

expect class warcombatzone {
    val combatZoneID: Int
    val combatZoneName: String
    val factionID: Int
    val centerSystemID: Int
    val description: String

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
    override fun toString(): String

    @Serializer(warcombatzone::class)
    companion object : KSerializer<warcombatzone> {
        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: warcombatzone)

        override fun deserialize(input: Decoder): warcombatzone

        fun serializer(): KSerializer<warcombatzone>
    }
}

