
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

@Serializable(with = staservice.Companion::class)
expect class staservice {
    val serviceID: Int
    val serviceName: String
    val description: String

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
    override fun toString(): String

    @Serializer(staservice::class)
    companion object : KSerializer<staservice> {
        fun getItem(id: Int): staservice
        fun allItems(): List<staservice>


        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: staservice)

        override fun deserialize(input: Decoder): staservice

        fun serializer(): KSerializer<staservice>
    }
}
operator fun staservice.Companion.get(id: Int) = getItem(id)
operator fun staservice.Companion.invoke() = allItems()


