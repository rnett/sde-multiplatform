package com.rnett.ligraph.eve.sde.data


import org.jetbrains.exposed.dao.IntIdTable

object mapconstellationjumps : IntIdTable("mapconstellationjumps", "fromConstellationID\" << 8 | \"toConstellationID") {
    // Database Columns

    val fromRegionID = integer("fromRegionID")
    val fromConstellationID = integer("fromConstellationID").primaryKey(1)
    val toConstellationID = integer("toConstellationID").primaryKey(2)
    val toRegionID = integer("toRegionID")
}




