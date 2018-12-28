package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

expect class warcombatzonesystem {
    val solarSystemID: Int
    val combatZoneID: Int

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int

    @Serializer(warcombatzonesystem::class)
    companion object : KSerializer<warcombatzonesystem> {
        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: warcombatzonesystem)

        override fun deserialize(input: Decoder): warcombatzonesystem

        fun serializer(): KSerializer<warcombatzonesystem>
    }
}

