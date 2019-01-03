
package com.rnett.ligraph.eve.sde.data


import org.jetbrains.exposed.dao.IntIdTable

object industryactivityproducts :
	IntIdTable("industryactivityproducts", "typeID\" << 8 | \"activityID\" << 16 | \"productTypeID") {
	// Database Columns

	val typeID = integer("typeID")//.primaryKey(1)
	val activityID = integer("activityID")//.primaryKey(2)
	val productTypeID = integer("productTypeID")//.primaryKey(3)
	val quantity = integer("quantity")
}




