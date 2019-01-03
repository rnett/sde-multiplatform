
package com.rnett.ligraph.eve.sde.data


import com.rnett.kframe.data.callEndpoint
import com.rnett.ligraph.eve.sde.requestClient
import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

@Serializable(with = mapsolarsystem.Companion::class)
actual data class mapsolarsystem(
    actual val regionID: Int,
    actual val constellationID: Int,
    actual val solarSystemID: Int,
    actual val solarSystemName: String,
    actual val x: Double,
    actual val y: Double,
    actual val z: Double,
    actual val xMin: Double,
    actual val xMax: Double,
    actual val yMin: Double,
    actual val yMax: Double,
    actual val zMin: Double,
    actual val zMax: Double,
    actual val luminosity: Double,
    actual val border: Boolean,
    actual val fringe: Boolean,
    actual val corridor: Boolean,
    actual val hub: Boolean,
    actual val international: Boolean,
    actual val regional: Boolean,
    actual val constellation: Boolean,
    actual val security: Double,
    actual val factionID: Int,
    actual val radius: Double,
    actual val sunTypeID: Int,
    actual val securityClass: String
) {
    actual val constellation_fk: mapconstellation get() = getConstellation_fk(this)
    actual val region: mapregion get() = getRegion(this)


    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is mapsolarsystem)
            return false
        return solarSystemID == other.solarSystemID
    }


    actual override fun hashCode() = solarSystemID


    actual override fun toString() = solarSystemName

    @Serializer(mapsolarsystem::class)
    actual companion object : KSerializer<mapsolarsystem> {
        actual fun getItem(id: Int): mapsolarsystem = callEndpoint(this::getItem, requestClient, id)
        actual fun allItems(): List<mapsolarsystem> = callEndpoint(this::allItems, requestClient)

        actual fun getConstellation_fk(item: mapsolarsystem): mapconstellation =
            callEndpoint(this::getConstellation_fk, requestClient, item)

        actual fun getRegion(item: mapsolarsystem): mapregion = callEndpoint(this::getRegion, requestClient, item)


        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("mapsolarsystem") {
            init {
                addElement("regionID")
                addElement("constellationID")
                addElement("solarSystemID")
                addElement("solarSystemName")
                addElement("x")
                addElement("y")
                addElement("z")
                addElement("xMin")
                addElement("xMax")
                addElement("yMin")
                addElement("yMax")
                addElement("zMin")
                addElement("zMax")
                addElement("luminosity")
                addElement("border")
                addElement("fringe")
                addElement("corridor")
                addElement("hub")
                addElement("international")
                addElement("regional")
                addElement("constellation")
                addElement("security")
                addElement("factionID")
                addElement("radius")
                addElement("sunTypeID")
                addElement("securityClass")
            }
        }

        actual override fun serialize(output: Encoder, obj: mapsolarsystem) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.regionID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.constellationID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.solarSystemID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.solarSystemName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                4,
                HexConverter.printHexBinary(obj.x.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                5,
                HexConverter.printHexBinary(obj.y.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                6,
                HexConverter.printHexBinary(obj.z.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                7,
                HexConverter.printHexBinary(obj.xMin.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                8,
                HexConverter.printHexBinary(obj.xMax.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                9,
                HexConverter.printHexBinary(obj.yMin.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                10,
                HexConverter.printHexBinary(obj.yMax.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                11,
                HexConverter.printHexBinary(obj.zMin.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                12,
                HexConverter.printHexBinary(obj.zMax.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                13,
                HexConverter.printHexBinary(obj.luminosity.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                14,
                HexConverter.printHexBinary(obj.border.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                15,
                HexConverter.printHexBinary(obj.fringe.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                16,
                HexConverter.printHexBinary(obj.corridor.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                17,
                HexConverter.printHexBinary(obj.hub.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                18,
                HexConverter.printHexBinary(obj.international.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                19,
                HexConverter.printHexBinary(obj.regional.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                20,
                HexConverter.printHexBinary(obj.constellation.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                21,
                HexConverter.printHexBinary(obj.security.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                22,
                HexConverter.printHexBinary(obj.factionID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                23,
                HexConverter.printHexBinary(obj.radius.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                24,
                HexConverter.printHexBinary(obj.sunTypeID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                25,
                HexConverter.printHexBinary(obj.securityClass.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): mapsolarsystem {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var temp_regionID: Int? = null
            var temp_constellationID: Int? = null
            var temp_solarSystemID: Int? = null
            var temp_solarSystemName: String? = null
            var temp_x: Double? = null
            var temp_y: Double? = null
            var temp_z: Double? = null
            var temp_xMin: Double? = null
            var temp_xMax: Double? = null
            var temp_yMin: Double? = null
            var temp_yMax: Double? = null
            var temp_zMin: Double? = null
            var temp_zMax: Double? = null
            var temp_luminosity: Double? = null
            var temp_border: Boolean? = null
            var temp_fringe: Boolean? = null
            var temp_corridor: Boolean? = null
            var temp_hub: Boolean? = null
            var temp_international: Boolean? = null
            var temp_regional: Boolean? = null
            var temp_constellation: Boolean? = null
            var temp_security: Double? = null
            var temp_factionID: Int? = null
            var temp_radius: Double? = null
            var temp_sunTypeID: Int? = null
            var temp_securityClass: String? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> temp_regionID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    1 -> temp_constellationID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    2 -> temp_solarSystemID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    3 -> temp_solarSystemName = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    4 -> temp_x = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    5 -> temp_y = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    6 -> temp_z = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    7 -> temp_xMin = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    8 -> temp_xMax = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    9 -> temp_yMin = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    10 -> temp_yMax = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    11 -> temp_zMin = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    12 -> temp_zMax = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    13 -> temp_luminosity = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    14 -> temp_border = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toBoolean()
                    15 -> temp_fringe = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toBoolean()
                    16 -> temp_corridor = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toBoolean()
                    17 -> temp_hub = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toBoolean()
                    18 -> temp_international = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toBoolean()
                    19 -> temp_regional = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toBoolean()
                    20 -> temp_constellation = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toBoolean()
                    21 -> temp_security = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    22 -> temp_factionID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    23 -> temp_radius = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    24 -> temp_sunTypeID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    25 -> temp_securityClass = stringFromUtf8Bytes(
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

            return mapsolarsystem(
                temp_regionID ?: throw SerializationException("Missing value for regionID"),
                temp_constellationID ?: throw SerializationException("Missing value for constellationID"),
                temp_solarSystemID ?: throw SerializationException("Missing value for solarSystemID"),
                temp_solarSystemName ?: throw SerializationException("Missing value for solarSystemName"),
                temp_x ?: throw SerializationException("Missing value for x"),
                temp_y ?: throw SerializationException("Missing value for y"),
                temp_z ?: throw SerializationException("Missing value for z"),
                temp_xMin ?: throw SerializationException("Missing value for xMin"),
                temp_xMax ?: throw SerializationException("Missing value for xMax"),
                temp_yMin ?: throw SerializationException("Missing value for yMin"),
                temp_yMax ?: throw SerializationException("Missing value for yMax"),
                temp_zMin ?: throw SerializationException("Missing value for zMin"),
                temp_zMax ?: throw SerializationException("Missing value for zMax"),
                temp_luminosity ?: throw SerializationException("Missing value for luminosity"),
                temp_border ?: throw SerializationException("Missing value for border"),
                temp_fringe ?: throw SerializationException("Missing value for fringe"),
                temp_corridor ?: throw SerializationException("Missing value for corridor"),
                temp_hub ?: throw SerializationException("Missing value for hub"),
                temp_international ?: throw SerializationException("Missing value for international"),
                temp_regional ?: throw SerializationException("Missing value for regional"),
                temp_constellation ?: throw SerializationException("Missing value for constellation"),
                temp_security ?: throw SerializationException("Missing value for security"),
                temp_factionID ?: throw SerializationException("Missing value for factionID"),
                temp_radius ?: throw SerializationException("Missing value for radius"),
                temp_sunTypeID ?: throw SerializationException("Missing value for sunTypeID"),
                temp_securityClass ?: throw SerializationException("Missing value for securityClass")
            )
        }

        actual fun serializer(): KSerializer<mapsolarsystem> = this
    }
}

