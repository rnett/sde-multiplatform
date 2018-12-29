
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

@Serializable(with = ramactivity.Companion::class)
expect class ramactivity {
    val activityID: Int
    val activityName: String
    val iconNo: String
    val description: String
    val published: Boolean

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
    override fun toString(): String

    @Serializer(ramactivity::class)
    companion object : KSerializer<ramactivity> {
        fun getItem(id: Int): ramactivity
        fun allItems(): List<ramactivity>


        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: ramactivity)

        override fun deserialize(input: Decoder): ramactivity

        fun serializer(): KSerializer<ramactivity>
    }
}

operator fun ramactivity.Companion.get(id: Int) = getItem(id)
operator fun ramactivity.Companion.invoke() = allItems()


