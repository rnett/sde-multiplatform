
package com.rnett.ligraph.eve.sde.data


import org.jetbrains.exposed.dao.IntIdTable

object raminstallationtypecontents :
    IntIdTable("raminstallationtypecontents", "installationTypeID\" << 8 | \"assemblyLineTypeID") {
    // Database Columns

    val installationTypeID = integer("installationTypeID").primaryKey(1)
    val assemblyLineTypeID = integer("assemblyLineTypeID").primaryKey(2)
    val quantity = integer("quantity")
}




