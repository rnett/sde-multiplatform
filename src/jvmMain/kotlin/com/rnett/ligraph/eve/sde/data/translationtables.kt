
package com.rnett.ligraph.eve.sde.data


import org.jetbrains.exposed.sql.Table

object translationtables : Table("translationtables") {
    // Database Columns

    val sourceTable = varchar("sourceTable", 200).primaryKey(1)
    val destinationTable = varchar("destinationTable", 200)
    val translatedKey = varchar("translatedKey", 200).primaryKey(2)
    val tcGroupID = integer("tcGroupID")
    val tcID = integer("tcID")
}




