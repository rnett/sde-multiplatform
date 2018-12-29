
package com.rnett.ligraph.eve.sde.data


import org.jetbrains.exposed.dao.IntIdTable

object industryactivitymaterials :
    IntIdTable("industryactivitymaterials", "typeID\" << 8 | \"activityID\" << 16 | \"materialTypeID") {
    // Database Columns

    val typeID = integer("typeID").primaryKey(1)
    val activityID = integer("activityID").primaryKey(2)
    val materialTypeID = integer("materialTypeID").primaryKey(3)
    val quantity = integer("quantity")
}




