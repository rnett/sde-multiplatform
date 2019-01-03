
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*

@Serializable(with = dgmeffect.Companion::class)
expect class dgmeffect {
    val effectID: Int
    val effectName: String
    val effectCategory: Int
    val preExpression: Int
    val postExpression: Int
    val description: String
    val guid: String
    val iconID: Int
    val isOffensive: Boolean
    val isAssistance: Boolean
    val durationAttributeID: Int
    val trackingSpeedAttributeID: Int
    val dischargeAttributeID: Int
    val rangeAttributeID: Int
    val falloffAttributeID: Int
    val disallowAutoRepeat: Boolean
    val published: Boolean
    val displayName: String
    val isWarpSafe: Boolean
    val rangeChance: Boolean
    val electronicChance: Boolean
    val propulsionChance: Boolean
    val distribution: Int
    val sfxName: String
    val npcUsageChanceAttributeID: Int
    val npcActivationChanceAttributeID: Int
    val fittingUsageChanceAttributeID: Int
    val modifierInfo: String

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int

    @Serializer(dgmeffect::class)
    companion object : KSerializer<dgmeffect> {
        fun getItem(id: Int): dgmeffect
        fun allItems(): List<dgmeffect>


        override val descriptor: SerialDescriptor

        override fun serialize(output: Encoder, obj: dgmeffect)

        override fun deserialize(input: Decoder): dgmeffect

        fun serializer(): KSerializer<dgmeffect>
    }
}
operator fun dgmeffect.Companion.get(id: Int) = getItem(id)
operator fun dgmeffect.Companion.invoke() = allItems()


