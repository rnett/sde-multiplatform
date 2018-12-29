
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

@Serializable(with = crpnpccorporation.Companion::class)
expect class crpnpccorporation {
    val corporationID: Int
    val size: Char
    val extent: Char
    val solarSystemID: Int
    val investorID1: Int
    val investorShares1: Int
    val investorID2: Int
    val investorShares2: Int
    val investorID3: Int
    val investorShares3: Int
    val investorID4: Int
    val investorShares4: Int
    val friendID: Int
    val enemyID: Int
    val publicShares: Int
    val initialPrice: Int
    val minSecurity: Double
    val scattered: Boolean
    val fringe: Int
    val corridor: Int
    val hub: Int
    val border: Int
    val factionID: Int
    val sizeFactor: Double
    val stationCount: Int
    val stationSystemCount: Int
    val description: String
    val iconID: Int

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int

    @Serializer(crpnpccorporation::class)
    companion object : KSerializer<crpnpccorporation> {
        fun getItem(id: Int): crpnpccorporation
        fun allItems(): List<crpnpccorporation>


        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: crpnpccorporation)

        override fun deserialize(input: Decoder): crpnpccorporation

        fun serializer(): KSerializer<crpnpccorporation>
    }
}

operator fun crpnpccorporation.Companion.get(id: Int) = getItem(id)
operator fun crpnpccorporation.Companion.invoke() = allItems()


