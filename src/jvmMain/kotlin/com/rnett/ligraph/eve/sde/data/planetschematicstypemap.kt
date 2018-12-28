package com.rnett.ligraph.eve.sde.data


import org.jetbrains.exposed.dao.IntIdTable

object planetschematicstypemaps : IntIdTable("planetschematicstypemap", "schematicID\" << 8 | \"typeID") {
    // Database Columns

    val schematicID = integer("schematicID").primaryKey(1)
    val typeID = integer("typeID").primaryKey(2)
    val quantity = integer("quantity")
    val isInput = bool("isInput")
}




