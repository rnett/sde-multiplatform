
package com.rnett.ligraph.eve.sde.data


import org.jetbrains.exposed.dao.IntIdTable

object dgmtypeeffects : IntIdTable("dgmtypeeffects", "typeID\" << 8 | \"effectID") {
    // Database Columns

    val typeID = integer("typeID")//.primaryKey(1)
    val effectID = integer("effectID")//.primaryKey(2)
    val isDefault = bool("isDefault")
}




