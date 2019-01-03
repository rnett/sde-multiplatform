
package com.rnett.ligraph.eve.sde.data


import org.jetbrains.exposed.dao.IntIdTable

object invcontroltowerresources :
    IntIdTable("invcontroltowerresources", "controlTowerTypeID\" << 8 | \"resourceTypeID") {
    // Database Columns

    val controlTowerTypeID = integer("controlTowerTypeID")//.primaryKey(1)
    val resourceTypeID = integer("resourceTypeID")//.primaryKey(2)
    val purpose = integer("purpose")
    val quantity = integer("quantity")
    val minSecurityLevel = double("minSecurityLevel")
    val factionID = integer("factionID")
}




