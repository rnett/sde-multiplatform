package com.rnett.ligraph.eve.sde.data


import org.jetbrains.exposed.dao.IntIdTable

object mapregionjumps : IntIdTable("mapregionjumps", "fromRegionID\" << 8 | \"toRegionID") {
    // Database Columns

    val fromRegionID = integer("fromRegionID").primaryKey(1)
    val toRegionID = integer("toRegionID").primaryKey(2)
}




