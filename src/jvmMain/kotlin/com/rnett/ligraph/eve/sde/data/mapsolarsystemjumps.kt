
package com.rnett.ligraph.eve.sde.data


import org.jetbrains.exposed.dao.IntIdTable

object mapsolarsystemjumps : IntIdTable("mapsolarsystemjumps", "fromSolarSystemID\" << 8 | \"toSolarSystemID") {
    // Database Columns

    val fromRegionID = integer("fromRegionID")
    val fromConstellationID = integer("fromConstellationID")
    val fromSolarSystemID = integer("fromSolarSystemID")//.primaryKey(1)
    val toSolarSystemID = integer("toSolarSystemID")//.primaryKey(2)
    val toConstellationID = integer("toConstellationID")
    val toRegionID = integer("toRegionID")
}




