
package com.rnett.ligraph.eve.sde.data


import org.jetbrains.exposed.dao.IntIdTable

object industryactivities : IntIdTable("industryactivity", "typeID\" << 8 | \"activityID") {
    // Database Columns

    val typeID = integer("typeID").primaryKey(1)
    val activityID = integer("activityID").primaryKey(2)
    val time = integer("time")
}




