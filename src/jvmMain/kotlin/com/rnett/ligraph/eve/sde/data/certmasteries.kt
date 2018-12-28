package com.rnett.ligraph.eve.sde.data


import org.jetbrains.exposed.sql.Table

object certmasteries : Table("certmasteries") {
    // Database Columns

    val typeID = integer("typeID")
    val masteryLevel = integer("masteryLevel")
    val certID = integer("certID")
}




