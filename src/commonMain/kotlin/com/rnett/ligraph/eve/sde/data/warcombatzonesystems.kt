
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

@Serializable(with = warcombatzonesystem.Companion::class)
expect class warcombatzonesystem {
    val solarSystemID: Int
    val combatZoneID: Int

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int

    @Serializer(warcombatzonesystem::class)
    companion object : KSerializer<warcombatzonesystem> {
        fun getItem(id: Int): warcombatzonesystem
        fun allItems(): List<warcombatzonesystem>


        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: warcombatzonesystem)

        override fun deserialize(input: Decoder): warcombatzonesystem

        fun serializer(): KSerializer<warcombatzonesystem>
    }
}

operator fun warcombatzonesystem.Companion.get(id: Int) = getItem(id)
operator fun warcombatzonesystem.Companion.invoke() = allItems()


