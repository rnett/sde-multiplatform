
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

@Serializable(with = crpnpcdivision.Companion::class)
expect class crpnpcdivision {
    val divisionID: Int
    val divisionName: String
    val description: String
    val leaderType: String

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
    override fun toString(): String

    @Serializer(crpnpcdivision::class)
    companion object : KSerializer<crpnpcdivision> {
        fun getItem(id: Int): crpnpcdivision
        fun allItems(): List<crpnpcdivision>


        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: crpnpcdivision)

        override fun deserialize(input: Decoder): crpnpcdivision

        fun serializer(): KSerializer<crpnpcdivision>
    }
}
operator fun crpnpcdivision.Companion.get(id: Int) = getItem(id)
operator fun crpnpcdivision.Companion.invoke() = allItems()


