
package com.rnett.ligraph.eve.sde.data


import org.jetbrains.exposed.dao.IntIdTable

object dgmtypeattributes : IntIdTable("dgmtypeattributes", "typeID\" << 8 | \"attributeID") {
    // Database Columns

    val typeID = integer("typeID").primaryKey(1)
    val attributeID = integer("attributeID").primaryKey(2)
    val valueInt = integer("valueInt")
    val valueFloat = double("valueFloat")
}




