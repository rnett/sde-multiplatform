package com.rnett.ligraph.eve.sde.data


import org.jetbrains.exposed.dao.IntIdTable

object crpnpccorporationresearchfields :
    IntIdTable("crpnpccorporationresearchfields", "skillID\" << 8 | \"corporationID") {
    // Database Columns

    val skillID = integer("skillID").primaryKey(1)
    val corporationID = integer("corporationID").primaryKey(2)
}




