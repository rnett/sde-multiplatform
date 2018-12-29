
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.transactions.transaction

object mapcelestialstatistics : IntIdTable("mapcelestialstatistics", "celestialID") {
    // Database Columns

    val celestialID = integer("celestialID").primaryKey()
    val temperature = double("temperature")
    val spectralClass = varchar("spectralClass", 10)
    val luminosity = double("luminosity")
    val age = double("age")
    val life = double("life")
    val orbitRadius = double("orbitRadius")
    val eccentricity = double("eccentricity")
    val massDust = double("massDust")
    val massGas = double("massGas")
    val fragmented = bool("fragmented")
    val density = double("density")
    val surfaceGravity = double("surfaceGravity")
    val escapeVelocity = double("escapeVelocity")
    val orbitPeriod = double("orbitPeriod")
    val rotationRate = double("rotationRate")
    val locked = bool("locked")
    val pressure = double("pressure")
    val radius = double("radius")
    val mass = integer("mass")
}



actual class mapcelestialstatistic(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(mapcelestialstatistic::class)
    actual companion object : IntEntityClass<mapcelestialstatistic>(mapcelestialstatistics),
        KSerializer<mapcelestialstatistic> {
        actual fun getItem(id: Int) = transaction { super.get(id) }
        actual fun allItems() = transaction { super.all().toList() }
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
            var id: Int? = null
            loop@ while (true) {
                when (val i = inp.decodeElementIndex(descriptor)) {
                    CompositeDecoder.READ_DONE -> break@loop
                    0 -> id =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
                    else -> if (i < descriptor.elementsCount) continue@loop else throw SerializationException("Unknown index $i")
                }
            }

            inp.endStructure(descriptor)
            if (id == null)
                throw SerializationException("Id 'celestialID' @ index 0 not found")
            else
                return mapcelestialstatistic[id]
        }

        actual fun serializer(): KSerializer<mapcelestialstatistic> = this
    }

    // Database Columns

    actual val celestialID by mapcelestialstatistics.celestialID
    actual val temperature by mapcelestialstatistics.temperature
    actual val spectralClass by mapcelestialstatistics.spectralClass
    actual val luminosity by mapcelestialstatistics.luminosity
    actual val age by mapcelestialstatistics.age
    actual val life by mapcelestialstatistics.life
    actual val orbitRadius by mapcelestialstatistics.orbitRadius
    actual val eccentricity by mapcelestialstatistics.eccentricity
    actual val massDust by mapcelestialstatistics.massDust
    actual val massGas by mapcelestialstatistics.massGas
    actual val fragmented by mapcelestialstatistics.fragmented
    actual val density by mapcelestialstatistics.density
    actual val surfaceGravity by mapcelestialstatistics.surfaceGravity
    actual val escapeVelocity by mapcelestialstatistics.escapeVelocity
    actual val orbitPeriod by mapcelestialstatistics.orbitPeriod
    actual val rotationRate by mapcelestialstatistics.rotationRate
    actual val locked by mapcelestialstatistics.locked
    actual val pressure by mapcelestialstatistics.pressure
    actual val radius by mapcelestialstatistics.radius
    actual val mass by mapcelestialstatistics.mass


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is mapcelestialstatistic)
            return false
        return celestialID == other.celestialID
    }


    actual override fun hashCode() = celestialID


}

