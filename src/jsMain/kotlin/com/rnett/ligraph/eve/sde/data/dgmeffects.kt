
package com.rnett.ligraph.eve.sde.data


import com.rnett.kframe.data.callEndpoint
import com.rnett.ligraph.eve.sde.requestClient
import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

@Serializable(with = dgmeffect.Companion::class)
actual data class dgmeffect(
    actual val effectID: Int,
    actual val effectName: String,
    actual val effectCategory: Int,
    actual val preExpression: Int,
    actual val postExpression: Int,
    actual val description: String,
    actual val guid: String,
    actual val iconID: Int,
    actual val isOffensive: Boolean,
    actual val isAssistance: Boolean,
    actual val durationAttributeID: Int,
    actual val trackingSpeedAttributeID: Int,
    actual val dischargeAttributeID: Int,
    actual val rangeAttributeID: Int,
    actual val falloffAttributeID: Int,
    actual val disallowAutoRepeat: Boolean,
    actual val published: Boolean,
    actual val displayName: String,
    actual val isWarpSafe: Boolean,
    actual val rangeChance: Boolean,
    actual val electronicChance: Boolean,
    actual val propulsionChance: Boolean,
    actual val distribution: Int,
    actual val sfxName: String,
    actual val npcUsageChanceAttributeID: Int,
    actual val npcActivationChanceAttributeID: Int,
    actual val fittingUsageChanceAttributeID: Int,
    actual val modifierInfo: String
) {


    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is dgmeffect)
            return false
        return effectID == other.effectID
    }


    actual override fun hashCode() = effectID


    @Serializer(dgmeffect::class)
    actual companion object : KSerializer<dgmeffect> {
        actual fun getItem(id: Int): dgmeffect = callEndpoint(this::getItem, requestClient, id)
        actual fun allItems(): List<dgmeffect> = callEndpoint(this::allItems, requestClient)


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
            var temp_effectID: Int? = null
            var temp_effectName: String? = null
            var temp_effectCategory: Int? = null
            var temp_preExpression: Int? = null
            var temp_postExpression: Int? = null
            var temp_description: String? = null
            var temp_guid: String? = null
            var temp_iconID: Int? = null
            var temp_isOffensive: Boolean? = null
            var temp_isAssistance: Boolean? = null
            var temp_durationAttributeID: Int? = null
            var temp_trackingSpeedAttributeID: Int? = null
            var temp_dischargeAttributeID: Int? = null
            var temp_rangeAttributeID: Int? = null
            var temp_falloffAttributeID: Int? = null
            var temp_disallowAutoRepeat: Boolean? = null
            var temp_published: Boolean? = null
            var temp_displayName: String? = null
            var temp_isWarpSafe: Boolean? = null
            var temp_rangeChance: Boolean? = null
            var temp_electronicChance: Boolean? = null
            var temp_propulsionChance: Boolean? = null
            var temp_distribution: Int? = null
            var temp_sfxName: String? = null
            var temp_npcUsageChanceAttributeID: Int? = null
            var temp_npcActivationChanceAttributeID: Int? = null
            var temp_fittingUsageChanceAttributeID: Int? = null
            var temp_modifierInfo: String? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> temp_effectID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    1 -> temp_effectName = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    2 -> temp_effectCategory =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    3 -> temp_preExpression =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    4 -> temp_postExpression =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    5 -> temp_description = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    6 -> temp_guid = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    7 -> temp_iconID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    8 -> temp_isOffensive = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toBoolean()
                    9 -> temp_isAssistance = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toBoolean()
                    10 -> temp_durationAttributeID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    11 -> temp_trackingSpeedAttributeID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    12 -> temp_dischargeAttributeID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    13 -> temp_rangeAttributeID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    14 -> temp_falloffAttributeID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    15 -> temp_disallowAutoRepeat = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toBoolean()
                    16 -> temp_published = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toBoolean()
                    17 -> temp_displayName = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    18 -> temp_isWarpSafe = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toBoolean()
                    19 -> temp_rangeChance = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toBoolean()
                    20 -> temp_electronicChance = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toBoolean()
                    21 -> temp_propulsionChance = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toBoolean()
                    22 -> temp_distribution =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    23 -> temp_sfxName = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    24 -> temp_npcUsageChanceAttributeID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    25 -> temp_npcActivationChanceAttributeID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    26 -> temp_fittingUsageChanceAttributeID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    27 -> temp_modifierInfo = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    else -> if (i < descriptor.elementsCount) continue@loop else throw SerializationException("Unknown index $i")
                }
            }

            inp.endStructure(descriptor)

            return dgmeffect(
                temp_effectID ?: throw SerializationException("Missing value for effectID"),
                temp_effectName ?: throw SerializationException("Missing value for effectName"),
                temp_effectCategory ?: throw SerializationException("Missing value for effectCategory"),
                temp_preExpression ?: throw SerializationException("Missing value for preExpression"),
                temp_postExpression ?: throw SerializationException("Missing value for postExpression"),
                temp_description ?: throw SerializationException("Missing value for description"),
                temp_guid ?: throw SerializationException("Missing value for guid"),
                temp_iconID ?: throw SerializationException("Missing value for iconID"),
                temp_isOffensive ?: throw SerializationException("Missing value for isOffensive"),
                temp_isAssistance ?: throw SerializationException("Missing value for isAssistance"),
                temp_durationAttributeID ?: throw SerializationException("Missing value for durationAttributeID"),
                temp_trackingSpeedAttributeID
                    ?: throw SerializationException("Missing value for trackingSpeedAttributeID"),
                temp_dischargeAttributeID ?: throw SerializationException("Missing value for dischargeAttributeID"),
                temp_rangeAttributeID ?: throw SerializationException("Missing value for rangeAttributeID"),
                temp_falloffAttributeID ?: throw SerializationException("Missing value for falloffAttributeID"),
                temp_disallowAutoRepeat ?: throw SerializationException("Missing value for disallowAutoRepeat"),
                temp_published ?: throw SerializationException("Missing value for published"),
                temp_displayName ?: throw SerializationException("Missing value for displayName"),
                temp_isWarpSafe ?: throw SerializationException("Missing value for isWarpSafe"),
                temp_rangeChance ?: throw SerializationException("Missing value for rangeChance"),
                temp_electronicChance ?: throw SerializationException("Missing value for electronicChance"),
                temp_propulsionChance ?: throw SerializationException("Missing value for propulsionChance"),
                temp_distribution ?: throw SerializationException("Missing value for distribution"),
                temp_sfxName ?: throw SerializationException("Missing value for sfxName"),
                temp_npcUsageChanceAttributeID
                    ?: throw SerializationException("Missing value for npcUsageChanceAttributeID"),
                temp_npcActivationChanceAttributeID
                    ?: throw SerializationException("Missing value for npcActivationChanceAttributeID"),
                temp_fittingUsageChanceAttributeID
                    ?: throw SerializationException("Missing value for fittingUsageChanceAttributeID"),
                temp_modifierInfo ?: throw SerializationException("Missing value for modifierInfo")
            )
        }

        actual fun serializer(): KSerializer<dgmeffect> = this
    }
}

