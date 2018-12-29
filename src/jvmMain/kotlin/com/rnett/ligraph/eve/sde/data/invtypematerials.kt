
package com.rnett.ligraph.eve.sde.data


import org.jetbrains.exposed.dao.IntIdTable

object invtypematerials : IntIdTable("invtypematerials", "typeID\" << 8 | \"materialTypeID") {
    // Database Columns

    val typeID = integer("typeID").primaryKey(1)
    val materialTypeID = integer("materialTypeID").primaryKey(2)
    val quantity = integer("quantity")
}




