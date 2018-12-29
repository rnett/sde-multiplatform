
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.transactions.transaction

object staservices : IntIdTable("staservices", "serviceID") {
    // Database Columns

    val serviceID = integer("serviceID").primaryKey()
    val serviceName = varchar("serviceName", 100)
    val description = varchar("description", 1000)
}



actual class staservice(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(staservice::class)
    actual companion object : IntEntityClass<staservice>(staservices), KSerializer<staservice> {
        actual fun getItem(id: Int) = transaction { super.get(id) }
        actual fun allItems() = transaction { super.all().toList() }
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("staservice") {
            init {
                addElement("serviceID")
                addElement("serviceName")
                addElement("description")
            }
        }

        actual override fun serialize(output: Encoder, obj: staservice) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.serviceID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.serviceName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.description.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): staservice {
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
                throw SerializationException("Id 'serviceID' @ index 0 not found")
            else
                return staservice[id]
        }

        actual fun serializer(): KSerializer<staservice> = this
    }

    // Database Columns

    actual val serviceID by staservices.serviceID
    actual val serviceName by staservices.serviceName
    actual val description by staservices.description


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is staservice)
            return false
        return serviceID == other.serviceID
    }


    actual override fun hashCode() = serviceID


    actual override fun toString() = serviceName
}

