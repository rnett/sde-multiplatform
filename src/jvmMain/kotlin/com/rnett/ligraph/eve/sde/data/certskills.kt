
package com.rnett.ligraph.eve.sde.data


import org.jetbrains.exposed.sql.Table

object certskills : Table("certskills") {
    // Database Columns

    val certID = integer("certID")
    val skillID = integer("skillID")
    val certLevelInt = integer("certLevelInt")
    val skillLevel = integer("skillLevel")
    val certLevelText = varchar("certLevelText", 8)
}




