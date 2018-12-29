
package com.rnett.ligraph.eve.sde.data


import org.jetbrains.exposed.sql.Table

object skinships : Table("skinship") {
    // Database Columns

    val skinID = integer("skinID")
    val typeID = integer("typeID")
}




