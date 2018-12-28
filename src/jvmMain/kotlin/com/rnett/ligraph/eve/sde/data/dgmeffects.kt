package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable

object dgmeffects : IntIdTable("dgmeffects", "effectID") {
    // Database Columns

    val effectID = integer("effectID").primaryKey()
    val effectName = varchar("effectName", 400)
    val effectCategory = integer("effectCategory")
    val preExpression = integer("preExpression")
    val postExpression = integer("postExpression")
    val description = varchar("description", 1000)
    val guid = varchar("guid", 60)
    val iconID = integer("iconID")
    val isOffensive = bool("isOffensive")
    val isAssistance = bool("isAssistance")
    val durationAttributeID = integer("durationAttributeID")
    val trackingSpeedAttributeID = integer("trackingSpeedAttributeID")
    val dischargeAttributeID = integer("dischargeAttributeID")
    val rangeAttributeID = integer("rangeAttributeID")
    val falloffAttributeID = integer("falloffAttributeID")
    val disallowAutoRepeat = bool("disallowAutoRepeat")
    val published = bool("published")
    val displayName = varchar("displayName", 100)
    val isWarpSafe = bool("isWarpSafe")
    val rangeChance = bool("rangeChance")
    val electronicChance = bool("electronicChance")
    val propulsionChance = bool("propulsionChance")
    val distribution = integer("distribution")
    val sfxName = varchar("sfxName", 20)
    val npcUsageChanceAttributeID = integer("npcUsageChanceAttributeID")
    val npcActivationChanceAttributeID = integer("npcActivationChanceAttributeID")
    val fittingUsageChanceAttributeID = integer("fittingUsageChanceAttributeID")
    val modifierInfo = text("modifierInfo")
}


actual class dgmeffect(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(dgmeffect::class)
    actual companion object : IntEntityClass<dgmeffect>(dgmeffects), KSerializer<dgmeffect> {
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("dgmeffect") {
            init {
                addElement("effectID")
                addElement("effectName")
                addElement("effectCategory")
                addElement("preExpression")
                addElement("postExpression")
                addElement("description")
                addElement("guid")
                addElement("iconID")
                addElement("isOffensive")
                addElement("isAssistance")
                addElement("durationAttributeID")
                addElement("trackingSpeedAttributeID")
                addElement("dischargeAttributeID")
                addElement("rangeAttributeID")
                addElement("falloffAttributeID")
                addElement("disallowAutoRepeat")
                addElement("published")
                addElement("displayName")
                addElement("isWarpSafe")
                addElement("rangeChance")
                addElement("electronicChance")
                addElement("propulsionChance")
                addElement("distribution")
                addElement("sfxName")
                addElement("npcUsageChanceAttributeID")
                addElement("npcActivationChanceAttributeID")
                addElement("fittingUsageChanceAttributeID")
                addElement("modifierInfo")
            }
        }

        actual override fun serialize(output: Encoder, obj: dgmeffect) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.effectID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.effectName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.effectCategory.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.preExpression.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                4,
                HexConverter.printHexBinary(obj.postExpression.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                5,
                HexConverter.printHexBinary(obj.description.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                6,
                HexConverter.printHexBinary(obj.guid.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                7,
                HexConverter.printHexBinary(obj.iconID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                8,
                HexConverter.printHexBinary(obj.isOffensive.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                9,
                HexConverter.printHexBinary(obj.isAssistance.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                10,
                HexConverter.printHexBinary(obj.durationAttributeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                11,
                HexConverter.printHexBinary(obj.trackingSpeedAttributeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                12,
                HexConverter.printHexBinary(obj.dischargeAttributeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                13,
                HexConverter.printHexBinary(obj.rangeAttributeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                14,
                HexConverter.printHexBinary(obj.falloffAttributeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                15,
                HexConverter.printHexBinary(obj.disallowAutoRepeat.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                16,
                HexConverter.printHexBinary(obj.published.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                17,
                HexConverter.printHexBinary(obj.displayName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                18,
                HexConverter.printHexBinary(obj.isWarpSafe.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                19,
                HexConverter.printHexBinary(obj.rangeChance.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                20,
                HexConverter.printHexBinary(obj.electronicChance.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                21,
                HexConverter.printHexBinary(obj.propulsionChance.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                22,
                HexConverter.printHexBinary(obj.distribution.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                23,
                HexConverter.printHexBinary(obj.sfxName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                24,
                HexConverter.printHexBinary(obj.npcUsageChanceAttributeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                25,
                HexConverter.printHexBinary(obj.npcActivationChanceAttributeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                26,
                HexConverter.printHexBinary(obj.fittingUsageChanceAttributeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                27,
                HexConverter.printHexBinary(obj.modifierInfo.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): dgmeffect {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var id: Int? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> id = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toInt()
                    else -> if (i < descriptor.elementsCount) continue@loop else throw SerializationException("Unknown index $i")
                }
            }

            inp.endStructure(descriptor)
            if (id == null)
                throw SerializationException("Id 'effectID' @ index 0 not found")
            else
                return dgmeffect[id]
        }

        actual fun serializer(): KSerializer<dgmeffect> = this
    }

    // Database Columns

    actual val effectID by dgmeffects.effectID
    actual val effectName by dgmeffects.effectName
    actual val effectCategory by dgmeffects.effectCategory
    actual val preExpression by dgmeffects.preExpression
    actual val postExpression by dgmeffects.postExpression
    actual val description by dgmeffects.description
    actual val guid by dgmeffects.guid
    actual val iconID by dgmeffects.iconID
    actual val isOffensive by dgmeffects.isOffensive
    actual val isAssistance by dgmeffects.isAssistance
    actual val durationAttributeID by dgmeffects.durationAttributeID
    actual val trackingSpeedAttributeID by dgmeffects.trackingSpeedAttributeID
    actual val dischargeAttributeID by dgmeffects.dischargeAttributeID
    actual val rangeAttributeID by dgmeffects.rangeAttributeID
    actual val falloffAttributeID by dgmeffects.falloffAttributeID
    actual val disallowAutoRepeat by dgmeffects.disallowAutoRepeat
    actual val published by dgmeffects.published
    actual val displayName by dgmeffects.displayName
    actual val isWarpSafe by dgmeffects.isWarpSafe
    actual val rangeChance by dgmeffects.rangeChance
    actual val electronicChance by dgmeffects.electronicChance
    actual val propulsionChance by dgmeffects.propulsionChance
    actual val distribution by dgmeffects.distribution
    actual val sfxName by dgmeffects.sfxName
    actual val npcUsageChanceAttributeID by dgmeffects.npcUsageChanceAttributeID
    actual val npcActivationChanceAttributeID by dgmeffects.npcActivationChanceAttributeID
    actual val fittingUsageChanceAttributeID by dgmeffects.fittingUsageChanceAttributeID
    actual val modifierInfo by dgmeffects.modifierInfo


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is dgmeffect)
            return false
        return effectID == other.effectID
    }


    actual override fun hashCode() = effectID


}

