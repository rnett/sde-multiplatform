
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

@Serializable(with = warcombatzone.Companion::class)
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
        fun getItem(id: Int): warcombatzone
        fun allItems(): List<warcombatzone>


        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: warcombatzone)

        override fun deserialize(input: Decoder): warcombatzone

        fun serializer(): KSerializer<warcombatzone>
    }
}

operator fun warcombatzone.Companion.get(id: Int) = getItem(id)
operator fun warcombatzone.Companion.invoke() = allItems()


