
package com.rnett.ligraph.eve.sde.data


import org.jetbrains.exposed.dao.IntIdTable

object ramassemblylinestations : IntIdTable("ramassemblylinestations", "stationID\" << 8 | \"assemblyLineTypeID") {
    // Database Columns

    val stationID = integer("stationID")//.primaryKey(1)
    val assemblyLineTypeID = integer("assemblyLineTypeID")//.primaryKey(2)
    val quantity = integer("quantity")
    val stationTypeID = integer("stationTypeID")
    val ownerID = integer("ownerID")
    val solarSystemID = integer("solarSystemID")
    val regionID = integer("regionID")
}




