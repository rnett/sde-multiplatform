package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable

object skinmaterials : IntIdTable("skinmaterials", "skinMaterialID") {
    // Database Columns

    val skinMaterialID = integer("skinMaterialID").primaryKey()
    val displayNameID = integer("displayNameID")
    val materialSetID = integer("materialSetID")
}


actual class skinmaterial(val myId: EntityID<Int>) : IntEntity(myId) {

    @Serializer(skinmaterial::class)
    actual companion object : IntEntityClass<skinmaterial>(skinmaterials), KSerializer<skinmaterial> {
        actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("skinmaterial") {
            init {
                addElement("skinMaterialID")
                addElement("displayNameID")
                addElement("materialSetID")
            }
        }

        actual override fun serialize(output: Encoder, obj: skinmaterial) {
            val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.skinMaterialID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.displayNameID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.materialSetID.toString().toUtf8Bytes())
            )
            compositeOutput.endStructure(descriptor)
        }

        actual override fun deserialize(input: Decoder): skinmaterial {
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
                throw SerializationException("Id 'skinMaterialID' @ index 0 not found")
            else
                return skinmaterial[id]
        }

        actual fun serializer(): KSerializer<skinmaterial> = this
    }

    // Database Columns

    actual val skinMaterialID by skinmaterials.skinMaterialID
    actual val displayNameID by skinmaterials.displayNameID
    actual val materialSetID by skinmaterials.materialSetID


    // Helper Methods

    actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is skinmaterial)
            return false
        return skinMaterialID == other.skinMaterialID
    }


    actual override fun hashCode() = skinMaterialID


}

