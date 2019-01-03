
package com.rnett.ligraph.eve.sde.data


import org.jetbrains.exposed.dao.IntIdTable

object crpnpccorporationdivisions : IntIdTable("crpnpccorporationdivisions", "corporationID\" << 8 | \"divisionID") {
	// Database Columns

	val corporationID = integer("corporationID")//.primaryKey(1)
	val divisionID = integer("divisionID")//.primaryKey(2)
	val size = integer("size")
}




