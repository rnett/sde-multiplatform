
package com.rnett.ligraph.eve.sde.data


import org.jetbrains.exposed.dao.IntIdTable

object planetschematicspinmaps : IntIdTable("planetschematicspinmap", "schematicID\" << 8 | \"pinTypeID") {
    // Database Columns

    val schematicID = integer("schematicID").primaryKey(1)
    val pinTypeID = integer("pinTypeID").primaryKey(2)
}




