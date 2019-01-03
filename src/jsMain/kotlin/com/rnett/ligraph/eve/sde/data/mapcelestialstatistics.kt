
package com.rnett.ligraph.eve.sde.data


import com.rnett.kframe.data.callEndpoint
import com.rnett.ligraph.eve.sde.requestClient
import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl

@Serializable(with = mapcelestialstatistic.Companion::class)
actual data class mapcelestialstatistic(
    actual val celestialID: Int,
    actual val temperature: Double,
    actual val spectralClass: String,
    actual val luminosity: Double,
    actual val age: Double,
    actual val life: Double,
    actual val orbitRadius: Double,
    actual val eccentricity: Double,
    actual val massDust: Double,
    actual val massGas: Double,
    actual val fragmented: Boolean,
    actual val density: Double,
    actual val surfaceGravity: Double,
    actual val escapeVelocity: Double,
    actual val orbitPeriod: Double,
    actual val rotationRate: Double,
    actual val locked: Boolean,
    actual val pressure: Double,
    actual val radius: Double,
    actual val mass: Int
) {


    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is mapcelestialstatistic)
            return false
        return celestialID == other.celestialID
    }


    actual override fun hashCode() = celestialID


    @Serializer(mapcelestialstatistic::class)
    actual companion object : KSerializer<mapcelestialstatistic> {
        actual fun getItem(id: Int): mapcelestialstatistic = callEndpoint(this::getItem, requestClient, id)
        actual fun allItems(): List<mapcelestialstatistic> = callEndpoint(this::allItems, requestClient)


        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("mapcelestialstatistic") {
            init {
                addElement("celestialID")
                addElement("temperature")
                addElement("spectralClass")
                addElement("luminosity")
                addElement("age")
                addElement("life")
                addElement("orbitRadius")
                addElement("eccentricity")
                addElement("massDust")
                addElement("massGas")
                addElement("fragmented")
                addElement("density")
                addElement("surfaceGravity")
                addElement("escapeVelocity")
                addElement("orbitPeriod")
                addElement("rotationRate")
                addElement("locked")
                addElement("pressure")
                addElement("radius")
                addElement("mass")
            }
        }

        actual override fun serialize(output: Encoder, obj: mapcelestialstatistic) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.celestialID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.temperature.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.spectralClass.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.luminosity.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                4,
                HexConverter.printHexBinary(obj.age.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                5,
                HexConverter.printHexBinary(obj.life.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                6,
                HexConverter.printHexBinary(obj.orbitRadius.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                7,
                HexConverter.printHexBinary(obj.eccentricity.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                8,
                HexConverter.printHexBinary(obj.massDust.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                9,
                HexConverter.printHexBinary(obj.massGas.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                10,
                HexConverter.printHexBinary(obj.fragmented.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                11,
                HexConverter.printHexBinary(obj.density.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                12,
                HexConverter.printHexBinary(obj.surfaceGravity.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                13,
                HexConverter.printHexBinary(obj.escapeVelocity.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                14,
                HexConverter.printHexBinary(obj.orbitPeriod.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                15,
                HexConverter.printHexBinary(obj.rotationRate.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                16,
                HexConverter.printHexBinary(obj.locked.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                17,
                HexConverter.printHexBinary(obj.pressure.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                18,
                HexConverter.printHexBinary(obj.radius.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                19,
                HexConverter.printHexBinary(obj.mass.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): mapcelestialstatistic {
            val inp: CompositeDecoder = input.beginStructure(descriptor)
            var temp_celestialID: Int? = null
            var temp_temperature: Double? = null
            var temp_spectralClass: String? = null
            var temp_luminosity: Double? = null
            var temp_age: Double? = null
            var temp_life: Double? = null
            var temp_orbitRadius: Double? = null
            var temp_eccentricity: Double? = null
            var temp_massDust: Double? = null
            var temp_massGas: Double? = null
            var temp_fragmented: Boolean? = null
            var temp_density: Double? = null
            var temp_surfaceGravity: Double? = null
            var temp_escapeVelocity: Double? = null
            var temp_orbitPeriod: Double? = null
            var temp_rotationRate: Double? = null
            var temp_locked: Boolean? = null
            var temp_pressure: Double? = null
            var temp_radius: Double? = null
            var temp_mass: Int? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> temp_celestialID =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    1 -> temp_temperature = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    2 -> temp_spectralClass = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toString()
                    3 -> temp_luminosity = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    4 -> temp_age = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    5 -> temp_life = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    6 -> temp_orbitRadius = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    7 -> temp_eccentricity = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    8 -> temp_massDust = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    9 -> temp_massGas = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    10 -> temp_fragmented = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toBoolean()
                    11 -> temp_density = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    12 -> temp_surfaceGravity = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    13 -> temp_escapeVelocity = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    14 -> temp_orbitPeriod = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    15 -> temp_rotationRate = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    16 -> temp_locked = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toBoolean()
                    17 -> temp_pressure = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    18 -> temp_radius = stringFromUtf8Bytes(
                        HexConverter.parseHexBinary(
                            inp.decodeStringElement(
                                descriptor,
                                i
                            )
                        )
                    ).toDouble()
                    19 -> temp_mass =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    else -> if (i < descriptor.elementsCount) continue@loop else throw SerializationException("Unknown index $i")
                }
            }

            inp.endStructure(descriptor)

            return mapcelestialstatistic(
                temp_celestialID ?: throw SerializationException("Missing value for celestialID"),
                temp_temperature ?: throw SerializationException("Missing value for temperature"),
                temp_spectralClass ?: throw SerializationException("Missing value for spectralClass"),
                temp_luminosity ?: throw SerializationException("Missing value for luminosity"),
                temp_age ?: throw SerializationException("Missing value for age"),
                temp_life ?: throw SerializationException("Missing value for life"),
                temp_orbitRadius ?: throw SerializationException("Missing value for orbitRadius"),
                temp_eccentricity ?: throw SerializationException("Missing value for eccentricity"),
                temp_massDust ?: throw SerializationException("Missing value for massDust"),
                temp_massGas ?: throw SerializationException("Missing value for massGas"),
                temp_fragmented ?: throw SerializationException("Missing value for fragmented"),
                temp_density ?: throw SerializationException("Missing value for density"),
                temp_surfaceGravity ?: throw SerializationException("Missing value for surfaceGravity"),
                temp_escapeVelocity ?: throw SerializationException("Missing value for escapeVelocity"),
                temp_orbitPeriod ?: throw SerializationException("Missing value for orbitPeriod"),
                temp_rotationRate ?: throw SerializationException("Missing value for rotationRate"),
                temp_locked ?: throw SerializationException("Missing value for locked"),
                temp_pressure ?: throw SerializationException("Missing value for pressure"),
                temp_radius ?: throw SerializationException("Missing value for radius"),
                temp_mass ?: throw SerializationException("Missing value for mass")
            )
        }

        actual fun serializer(): KSerializer<mapcelestialstatistic> = this
    }
}

