
package com.rnett.ligraph.eve.sde.data


import org.jetbrains.exposed.dao.IntIdTable

object crpnpccorporationtrades : IntIdTable("crpnpccorporationtrades", "corporationID\" << 8 | \"typeID") {
    // Database Columns

    val corporationID = integer("corporationID").primaryKey(1)
    val typeID = integer("typeID").primaryKey(2)
}




