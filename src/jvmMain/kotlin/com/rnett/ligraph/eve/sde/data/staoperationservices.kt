
package com.rnett.ligraph.eve.sde.data


import org.jetbrains.exposed.dao.IntIdTable

object staoperationservices : IntIdTable("staoperationservices", "operationID\" << 8 | \"serviceID") {
    // Database Columns

    val operationID = integer("operationID")//.primaryKey(1)
    val serviceID = integer("serviceID")//.primaryKey(2)
}




