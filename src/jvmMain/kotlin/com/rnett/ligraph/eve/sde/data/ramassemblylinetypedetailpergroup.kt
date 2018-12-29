
package com.rnett.ligraph.eve.sde.data


import org.jetbrains.exposed.dao.IntIdTable

object ramassemblylinetypedetailpergroups :
    IntIdTable("ramassemblylinetypedetailpergroup", "assemblyLineTypeID\" << 8 | \"groupID") {
    // Database Columns

    val assemblyLineTypeID = integer("assemblyLineTypeID").primaryKey(1)
    val groupID = integer("groupID").primaryKey(2)
    val timeMultiplier = double("timeMultiplier")
    val materialMultiplier = double("materialMultiplier")
    val costMultiplier = double("costMultiplier")
}




