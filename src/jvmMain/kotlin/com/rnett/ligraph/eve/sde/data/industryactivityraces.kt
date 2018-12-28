package com.rnett.ligraph.eve.sde.data


import org.jetbrains.exposed.sql.Table

object industryactivityraces : Table("industryactivityraces") {
    // Database Columns

    val typeID = integer("typeID")
    val activityID = integer("activityID")
    val productTypeID = integer("productTypeID")
    val raceID = integer("raceID")
}




