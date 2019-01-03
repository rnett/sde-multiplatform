
package com.rnett.ligraph.eve.sde.data


import org.jetbrains.exposed.dao.IntIdTable

object industryactivityprobabilities :
    IntIdTable("industryactivityprobabilities", "typeID\" << 8 | \"activityID\" << 16 | \"productTypeID") {
    // Database Columns

    val typeID = integer("typeID")//.primaryKey(1)
    val activityID = integer("activityID")//.primaryKey(2)
    val productTypeID = integer("productTypeID")//.primaryKey(3)
    val probability = decimal("probability", 3, 2)
}




