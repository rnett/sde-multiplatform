
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.transactions.transaction

object skins : IntIdTable("skins", "skinID") {
    // Database Columns

    val skinID = integer("skinID")//.primaryKey()
    val internalName = varchar("internalName", 70)
    val skinMaterialID = integer("skinMaterialID")
}


@Serializable(with = skin.Companion::class)
actual class skin(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(skin::class)
    actual companion object : IntEntityClass<skin>(skins), KSerializer<skin> {
        actual fun getItem(id: Int) = transaction { super.get(id) }
        actual fun allItems() = transaction { super.all().toList() }
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("skin") {
            init {
                addElement("skinID")
                addElement("internalName")
                addElement("skinMaterialID")
            }
        }

        actual override fun serialize(output: Encoder, obj: skin) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.skinID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.internalName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.skinMaterialID.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): skin {
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
                throw SerializationException("Id 'skinID' @ index 0 not found")
            else
                return skin[id]
        }

        actual fun serializer(): KSerializer<skin> = this
    }

    // Database Columns

    actual val skinID by skins.skinID
    actual val internalName by skins.internalName
    actual val skinMaterialID by skins.skinMaterialID


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is skin)
            return false
        return skinID == other.skinID
    }


    actual override fun hashCode() = skinID


    actual override fun toString() = internalName
}

