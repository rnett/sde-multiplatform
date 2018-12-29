
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

@Serializable(with = agtagent.Companion::class)
expect class agtagent {
    val agentID: Int
    val divisionID: Int
    val corporationID: Int
    val locationID: Int
    val level: Int
    val quality: Int
    val agentTypeID: Int
    val isLocator: Boolean

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int

    @Serializer(agtagent::class)
    companion object : KSerializer<agtagent> {
        fun getItem(id: Int): agtagent
        fun allItems(): List<agtagent>


        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: agtagent)

        override fun deserialize(input: Decoder): agtagent

        fun serializer(): KSerializer<agtagent>
    }
}

operator fun agtagent.Companion.get(id: Int) = getItem(id)
operator fun agtagent.Companion.invoke() = allItems()


