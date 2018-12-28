package com.rnett.ligraph.eve.sde.data


import org.jetbrains.exposed.dao.IntIdTable

object agtresearchagents : IntIdTable("agtresearchagents", "agentID\" << 8 | \"typeID") {
    // Database Columns

    val agentID = integer("agentID").primaryKey(1)
    val typeID = integer("typeID").primaryKey(2)
}




