
package com.rnett.ligraph.eve.sde.data


import org.jetbrains.exposed.dao.IntIdTable

object ramassemblylinetypedetailpercategories :
    IntIdTable("ramassemblylinetypedetailpercategory", "assemblyLineTypeID\" << 8 | \"categoryID") {
    // Database Columns

    val assemblyLineTypeID = integer("assemblyLineTypeID").primaryKey(1)
    val categoryID = integer("categoryID").primaryKey(2)
    val timeMultiplier = double("timeMultiplier")
    val materialMultiplier = double("materialMultiplier")
    val costMultiplier = double("costMultiplier")
}




