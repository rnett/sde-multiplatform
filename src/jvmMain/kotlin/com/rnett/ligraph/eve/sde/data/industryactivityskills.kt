
package com.rnett.ligraph.eve.sde.data


import org.jetbrains.exposed.sql.Table

object industryactivityskills : Table("industryactivityskills") {
    // Database Columns

    val typeID = integer("typeID")
    val activityID = integer("activityID")
    val skillID = integer("skillID")
    val level = integer("level")
}




