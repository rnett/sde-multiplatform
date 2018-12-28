package com.rnett.ligraph.eve.sde.data


import org.jetbrains.exposed.dao.IntIdTable

object invcontrabandtypes : IntIdTable("invcontrabandtypes", "factionID\" << 8 | \"typeID") {
    // Database Columns

    val factionID = integer("factionID").primaryKey(1)
    val typeID = integer("typeID").primaryKey(2)
    val standingLoss = double("standingLoss")
    val confiscateMinSec = double("confiscateMinSec")
    val fineByValue = double("fineByValue")
    val attackMinSec = double("attackMinSec")
}




