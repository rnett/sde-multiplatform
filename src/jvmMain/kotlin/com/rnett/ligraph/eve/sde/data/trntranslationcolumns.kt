
package com.rnett.ligraph.eve.sde.data


import kotlinx.serialization.*
import kotlinx.serialization.internal.HexConverter
import kotlinx.serialization.internal.SerialClassDescImpl
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.transactions.transaction

object trntranslationcolumns : IntIdTable("trntranslationcolumns", "tcID") {
	// Database Columns

	val tcGroupID = integer("tcGroupID")
    val tcID = integer("tcID")//.primaryKey()
	val tableNameCol = varchar("tableName", 256)
	val columnName = varchar("columnName", 128)
	val masterID = varchar("masterID", 128)
}


@Serializable(with = trntranslationcolumn.Companion::class)
actual class trntranslationcolumn(val myId: EntityID<Int>) : IntEntity(myId) {

	@Serializer(trntranslationcolumn::class)
    actual companion object : IntEntityClass<trntranslationcolumn>(trntranslationcolumns),
        KSerializer<trntranslationcolumn> {
        actual fun getItem(id: Int) = transaction { super.get(id) }
        actual fun allItems() = transaction { super.all().toList() }
		actual override val descriptor: SerialDescriptor = object : SerialClassDescImpl("trntranslationcolumn") {
            init {
				addElement("tcGroupID")
				addElement("tcID")
				addElement("tableName")
				addElement("columnName")
				addElement("masterID")
			}
		}

		actual override fun serialize(output: Encoder, obj: trntranslationcolumn) {
			val compositeOutput: CompositeEncoder = output.beginStructure(descriptor)
            compositeOutput.encodeStringElement(
                descriptor,
                0,
                HexConverter.printHexBinary(obj.tcGroupID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                1,
                HexConverter.printHexBinary(obj.tcID.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                2,
                HexConverter.printHexBinary(obj.tableName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                3,
                HexConverter.printHexBinary(obj.columnName.toString().toUtf8Bytes())
            )
            compositeOutput.encodeStringElement(
                descriptor,
                4,
                HexConverter.printHexBinary(obj.masterID.toString().toUtf8Bytes())
            )
			compositeOutput.endStructure(descriptor)
		}

		actual override fun deserialize(input: Decoder): trntranslationcolumn {
			val inp: CompositeDecoder = input.beginStructure(descriptor)
			var id: Int? = null
			loop@ while (true) {
				when (val i = inp.decodeElementIndex(descriptor)) {
					CompositeDecoder.READ_DONE -> break@loop
                    1 -> id =
                        stringFromUtf8Bytes(HexConverter.parseHexBinary(inp.decodeStringElement(descriptor, i))).toInt()
					else -> if (i < descriptor.elementsCount) continue@loop else throw SerializationException("Unknown index $i")
				}
			}

			inp.endStructure(descriptor)
            if (id == null)
				throw SerializationException("Id 'tcID' @ index 1 not found")
			else
				return trntranslationcolumn[id]
		}

		actual fun serializer(): KSerializer<trntranslationcolumn> = this
	}

	// Database Columns

	actual val tcGroupID by trntranslationcolumns.tcGroupID
	actual val tcID by trntranslationcolumns.tcID
	actual val tableName by trntranslationcolumns.tableNameCol
	actual val columnName by trntranslationcolumns.columnName
	actual val masterID by trntranslationcolumns.masterID


	// Helper Methods

	actual override fun equals(other: Any?): Boolean {
        if (other == null || other !is trntranslationcolumn)
			return false
		return tcID == other.tcID
	}


    actual override fun hashCode() = tcID


}

