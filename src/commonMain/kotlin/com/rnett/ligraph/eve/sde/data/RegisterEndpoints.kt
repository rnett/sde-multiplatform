
package com.rnett.ligraph.eve.sde.data


import com.rnett.kframe.data.EndpointManager
import com.rnett.kframe.data.addEndpoint
import com.rnett.ligraph.eve.sde.data.agtagent
import com.rnett.ligraph.eve.sde.data.agtagenttype
import com.rnett.ligraph.eve.sde.data.certcert
import com.rnett.ligraph.eve.sde.data.chrancestry
import com.rnett.ligraph.eve.sde.data.chrattribute
import com.rnett.ligraph.eve.sde.data.chrbloodline
import com.rnett.ligraph.eve.sde.data.chrfaction
import com.rnett.ligraph.eve.sde.data.chrrace
import com.rnett.ligraph.eve.sde.data.crpactivity
import com.rnett.ligraph.eve.sde.data.crpnpccorporation
import com.rnett.ligraph.eve.sde.data.crpnpcdivision
import com.rnett.ligraph.eve.sde.data.dgmattributecategory
import com.rnett.ligraph.eve.sde.data.dgmattributetype
import com.rnett.ligraph.eve.sde.data.dgmeffect
import com.rnett.ligraph.eve.sde.data.dgmexpression
import com.rnett.ligraph.eve.sde.data.evegraphic
import com.rnett.ligraph.eve.sde.data.eveicon
import com.rnett.ligraph.eve.sde.data.eveunit
import com.rnett.ligraph.eve.sde.data.industryblueprint
import com.rnett.ligraph.eve.sde.data.invcategory
import com.rnett.ligraph.eve.sde.data.invcontroltowerresourcepurpose
import com.rnett.ligraph.eve.sde.data.invflag
import com.rnett.ligraph.eve.sde.data.invgroup
import com.rnett.ligraph.eve.sde.data.invitem
import com.rnett.ligraph.eve.sde.data.invmarketgroup
import com.rnett.ligraph.eve.sde.data.invmetagroup
import com.rnett.ligraph.eve.sde.data.invmetatype
import com.rnett.ligraph.eve.sde.data.invname
import com.rnett.ligraph.eve.sde.data.invposition
import com.rnett.ligraph.eve.sde.data.invtrait
import com.rnett.ligraph.eve.sde.data.invtype
import com.rnett.ligraph.eve.sde.data.invtypereaction
import com.rnett.ligraph.eve.sde.data.invuniquename
import com.rnett.ligraph.eve.sde.data.invvolume
import com.rnett.ligraph.eve.sde.data.mapcelestialstatistic
import com.rnett.ligraph.eve.sde.data.mapconstellation
import com.rnett.ligraph.eve.sde.data.mapdenormalize
import com.rnett.ligraph.eve.sde.data.mapjump
import com.rnett.ligraph.eve.sde.data.maplandmark
import com.rnett.ligraph.eve.sde.data.maplocationscene
import com.rnett.ligraph.eve.sde.data.maplocationwormholeclass
import com.rnett.ligraph.eve.sde.data.mapregion
import com.rnett.ligraph.eve.sde.data.mapsolarsystem
import com.rnett.ligraph.eve.sde.data.mapuniverse
import com.rnett.ligraph.eve.sde.data.planetschematic
import com.rnett.ligraph.eve.sde.data.ramactivity
import com.rnett.ligraph.eve.sde.data.ramassemblylinetype
import com.rnett.ligraph.eve.sde.data.skin
import com.rnett.ligraph.eve.sde.data.skinlicense
import com.rnett.ligraph.eve.sde.data.skinmaterial
import com.rnett.ligraph.eve.sde.data.staoperation
import com.rnett.ligraph.eve.sde.data.staservice
import com.rnett.ligraph.eve.sde.data.stastation
import com.rnett.ligraph.eve.sde.data.stastationtype
import com.rnett.ligraph.eve.sde.data.trntranslation
import com.rnett.ligraph.eve.sde.data.trntranslationcolumn
import com.rnett.ligraph.eve.sde.data.trntranslationlanguage
import com.rnett.ligraph.eve.sde.data.warcombatzone
import com.rnett.ligraph.eve.sde.data.warcombatzonesystem
import kotlinx.serialization.internal.IntSerializer
import kotlinx.serialization.internal.LongSerializer
import kotlinx.serialization.list

fun registerEndpoints() {
	EndpointManager.addEndpoint(agtagent.Companion::getItem, agtagent, IntSerializer)
	EndpointManager.addEndpoint(agtagent.Companion::allItems, agtagent.list)

	EndpointManager.addEndpoint(agtagenttype.Companion::getItem, agtagenttype, IntSerializer)
	EndpointManager.addEndpoint(agtagenttype.Companion::allItems, agtagenttype.list)

	EndpointManager.addEndpoint(certcert.Companion::getItem, certcert, IntSerializer)
	EndpointManager.addEndpoint(certcert.Companion::allItems, certcert.list)

	EndpointManager.addEndpoint(chrancestry.Companion::getItem, chrancestry, IntSerializer)
	EndpointManager.addEndpoint(chrancestry.Companion::allItems, chrancestry.list)

	EndpointManager.addEndpoint(chrattribute.Companion::getItem, chrattribute, IntSerializer)
	EndpointManager.addEndpoint(chrattribute.Companion::allItems, chrattribute.list)

	EndpointManager.addEndpoint(chrbloodline.Companion::getItem, chrbloodline, IntSerializer)
	EndpointManager.addEndpoint(chrbloodline.Companion::allItems, chrbloodline.list)

	EndpointManager.addEndpoint(chrfaction.Companion::getItem, chrfaction, IntSerializer)
	EndpointManager.addEndpoint(chrfaction.Companion::allItems, chrfaction.list)

	EndpointManager.addEndpoint(chrrace.Companion::getItem, chrrace, IntSerializer)
	EndpointManager.addEndpoint(chrrace.Companion::allItems, chrrace.list)

	EndpointManager.addEndpoint(crpactivity.Companion::getItem, crpactivity, IntSerializer)
	EndpointManager.addEndpoint(crpactivity.Companion::allItems, crpactivity.list)

	EndpointManager.addEndpoint(crpnpccorporation.Companion::getItem, crpnpccorporation, IntSerializer)
	EndpointManager.addEndpoint(crpnpccorporation.Companion::allItems, crpnpccorporation.list)

	EndpointManager.addEndpoint(crpnpcdivision.Companion::getItem, crpnpcdivision, IntSerializer)
	EndpointManager.addEndpoint(crpnpcdivision.Companion::allItems, crpnpcdivision.list)

	EndpointManager.addEndpoint(dgmattributecategory.Companion::getItem, dgmattributecategory, IntSerializer)
	EndpointManager.addEndpoint(dgmattributecategory.Companion::allItems, dgmattributecategory.list)

	EndpointManager.addEndpoint(dgmattributetype.Companion::getItem, dgmattributetype, IntSerializer)
	EndpointManager.addEndpoint(dgmattributetype.Companion::allItems, dgmattributetype.list)
	EndpointManager.addEndpoint(dgmattributetype.Companion::getDgmexpressia, dgmexpression.list, dgmattributetype)

	EndpointManager.addEndpoint(dgmeffect.Companion::getItem, dgmeffect, IntSerializer)
	EndpointManager.addEndpoint(dgmeffect.Companion::allItems, dgmeffect.list)

	EndpointManager.addEndpoint(dgmexpression.Companion::getItem, dgmexpression, IntSerializer)
	EndpointManager.addEndpoint(dgmexpression.Companion::allItems, dgmexpression.list)
	EndpointManager.addEndpoint(dgmexpression.Companion::getExpressionAttribute, dgmattributetype, dgmexpression)
	EndpointManager.addEndpoint(dgmexpression.Companion::getExpressionGroup, invgroup, dgmexpression)
	EndpointManager.addEndpoint(dgmexpression.Companion::getExpressionType, invtype, dgmexpression)

	EndpointManager.addEndpoint(evegraphic.Companion::getItem, evegraphic, IntSerializer)
	EndpointManager.addEndpoint(evegraphic.Companion::allItems, evegraphic.list)

	EndpointManager.addEndpoint(eveicon.Companion::getItem, eveicon, IntSerializer)
	EndpointManager.addEndpoint(eveicon.Companion::allItems, eveicon.list)

	EndpointManager.addEndpoint(eveunit.Companion::getItem, eveunit, IntSerializer)
	EndpointManager.addEndpoint(eveunit.Companion::allItems, eveunit.list)

	EndpointManager.addEndpoint(industryblueprint.Companion::getItem, industryblueprint, IntSerializer)
	EndpointManager.addEndpoint(industryblueprint.Companion::allItems, industryblueprint.list)

	EndpointManager.addEndpoint(invcategory.Companion::getItem, invcategory, IntSerializer)
	EndpointManager.addEndpoint(invcategory.Companion::allItems, invcategory.list)
	EndpointManager.addEndpoint(invcategory.Companion::getInvgroups_rk, invgroup.list, invcategory)

	EndpointManager.addEndpoint(
		invcontroltowerresourcepurpose.Companion::getItem,
		invcontroltowerresourcepurpose,
		IntSerializer
	)
	EndpointManager.addEndpoint(invcontroltowerresourcepurpose.Companion::allItems, invcontroltowerresourcepurpose.list)

	EndpointManager.addEndpoint(invflag.Companion::getItem, invflag, IntSerializer)
	EndpointManager.addEndpoint(invflag.Companion::allItems, invflag.list)

	EndpointManager.addEndpoint(invgroup.Companion::getItem, invgroup, IntSerializer)
	EndpointManager.addEndpoint(invgroup.Companion::allItems, invgroup.list)
	EndpointManager.addEndpoint(invgroup.Companion::getCategory, invcategory, invgroup)
	EndpointManager.addEndpoint(invgroup.Companion::getDgmexpressia, dgmexpression.list, invgroup)
	EndpointManager.addEndpoint(invgroup.Companion::getInvtypes_rk, invtype.list, invgroup)

	EndpointManager.addEndpoint(invitem.Companion::getItem, invitem, IntSerializer)
	EndpointManager.addEndpoint(invitem.Companion::allItems, invitem.list)

	EndpointManager.addEndpoint(invmarketgroup.Companion::getItem, invmarketgroup, IntSerializer)
	EndpointManager.addEndpoint(invmarketgroup.Companion::allItems, invmarketgroup.list)
	EndpointManager.addEndpoint(invmarketgroup.Companion::getParentGroup, invmarketgroup, invmarketgroup)
	EndpointManager.addEndpoint(invmarketgroup.Companion::getInvmarketgroups_rk, invmarketgroup.list, invmarketgroup)
	EndpointManager.addEndpoint(invmarketgroup.Companion::getInvtypes_rk, invtype.list, invmarketgroup)

	EndpointManager.addEndpoint(invmetagroup.Companion::getItem, invmetagroup, IntSerializer)
	EndpointManager.addEndpoint(invmetagroup.Companion::allItems, invmetagroup.list)

	EndpointManager.addEndpoint(invmetatype.Companion::getItem, invmetatype, IntSerializer)
	EndpointManager.addEndpoint(invmetatype.Companion::allItems, invmetatype.list)

	EndpointManager.addEndpoint(invname.Companion::getItem, invname, IntSerializer)
	EndpointManager.addEndpoint(invname.Companion::allItems, invname.list)

	EndpointManager.addEndpoint(invposition.Companion::getItem, invposition, IntSerializer)
	EndpointManager.addEndpoint(invposition.Companion::allItems, invposition.list)

	EndpointManager.addEndpoint(invtrait.Companion::getItem, invtrait, IntSerializer)
	EndpointManager.addEndpoint(invtrait.Companion::allItems, invtrait.list)
	EndpointManager.addEndpoint(invtrait.Companion::getType, invtype, invtrait)

	EndpointManager.addEndpoint(invtypereaction.Companion::getItem, invtypereaction, IntSerializer)
	EndpointManager.addEndpoint(invtypereaction.Companion::allItems, invtypereaction.list)

	EndpointManager.addEndpoint(invtype.Companion::getItem, invtype, IntSerializer)
	EndpointManager.addEndpoint(invtype.Companion::allItems, invtype.list)
	EndpointManager.addEndpoint(invtype.Companion::getGroup, invgroup, invtype)
	EndpointManager.addEndpoint(invtype.Companion::getMarketGroup, invmarketgroup, invtype)
	EndpointManager.addEndpoint(invtype.Companion::getDgmexpressia, dgmexpression.list, invtype)
	EndpointManager.addEndpoint(invtype.Companion::getInvtraits_rk, invtrait.list, invtype)

	EndpointManager.addEndpoint(invuniquename.Companion::getItem, invuniquename, IntSerializer)
	EndpointManager.addEndpoint(invuniquename.Companion::allItems, invuniquename.list)

	EndpointManager.addEndpoint(invvolume.Companion::getItem, invvolume, IntSerializer)
	EndpointManager.addEndpoint(invvolume.Companion::allItems, invvolume.list)

	EndpointManager.addEndpoint(mapcelestialstatistic.Companion::getItem, mapcelestialstatistic, IntSerializer)
	EndpointManager.addEndpoint(mapcelestialstatistic.Companion::allItems, mapcelestialstatistic.list)

	EndpointManager.addEndpoint(mapconstellation.Companion::getItem, mapconstellation, IntSerializer)
	EndpointManager.addEndpoint(mapconstellation.Companion::allItems, mapconstellation.list)
	EndpointManager.addEndpoint(mapconstellation.Companion::getRegion, mapregion, mapconstellation)
	EndpointManager.addEndpoint(
		mapconstellation.Companion::getMapsolarsystems_rk,
		mapsolarsystem.list,
		mapconstellation
	)

	EndpointManager.addEndpoint(mapdenormalize.Companion::getItem, mapdenormalize, IntSerializer)
	EndpointManager.addEndpoint(mapdenormalize.Companion::allItems, mapdenormalize.list)

	EndpointManager.addEndpoint(mapjump.Companion::getItem, mapjump, IntSerializer)
	EndpointManager.addEndpoint(mapjump.Companion::allItems, mapjump.list)

	EndpointManager.addEndpoint(maplandmark.Companion::getItem, maplandmark, IntSerializer)
	EndpointManager.addEndpoint(maplandmark.Companion::allItems, maplandmark.list)

	EndpointManager.addEndpoint(maplocationscene.Companion::getItem, maplocationscene, IntSerializer)
	EndpointManager.addEndpoint(maplocationscene.Companion::allItems, maplocationscene.list)

	EndpointManager.addEndpoint(maplocationwormholeclass.Companion::getItem, maplocationwormholeclass, IntSerializer)
	EndpointManager.addEndpoint(maplocationwormholeclass.Companion::allItems, maplocationwormholeclass.list)

	EndpointManager.addEndpoint(mapregion.Companion::getItem, mapregion, IntSerializer)
	EndpointManager.addEndpoint(mapregion.Companion::allItems, mapregion.list)
	EndpointManager.addEndpoint(mapregion.Companion::getMapconstellatia, mapconstellation.list, mapregion)
	EndpointManager.addEndpoint(mapregion.Companion::getMapsolarsystems_rk, mapsolarsystem.list, mapregion)

	EndpointManager.addEndpoint(mapsolarsystem.Companion::getItem, mapsolarsystem, IntSerializer)
	EndpointManager.addEndpoint(mapsolarsystem.Companion::allItems, mapsolarsystem.list)
	EndpointManager.addEndpoint(mapsolarsystem.Companion::getConstellation_fk, mapconstellation, mapsolarsystem)
	EndpointManager.addEndpoint(mapsolarsystem.Companion::getRegion, mapregion, mapsolarsystem)

	EndpointManager.addEndpoint(mapuniverse.Companion::getItem, mapuniverse, IntSerializer)
	EndpointManager.addEndpoint(mapuniverse.Companion::allItems, mapuniverse.list)

	EndpointManager.addEndpoint(planetschematic.Companion::getItem, planetschematic, IntSerializer)
	EndpointManager.addEndpoint(planetschematic.Companion::allItems, planetschematic.list)

	EndpointManager.addEndpoint(ramactivity.Companion::getItem, ramactivity, IntSerializer)
	EndpointManager.addEndpoint(ramactivity.Companion::allItems, ramactivity.list)

	EndpointManager.addEndpoint(ramassemblylinetype.Companion::getItem, ramassemblylinetype, IntSerializer)
	EndpointManager.addEndpoint(ramassemblylinetype.Companion::allItems, ramassemblylinetype.list)

	EndpointManager.addEndpoint(skinlicense.Companion::getItem, skinlicense, IntSerializer)
	EndpointManager.addEndpoint(skinlicense.Companion::allItems, skinlicense.list)

	EndpointManager.addEndpoint(skinmaterial.Companion::getItem, skinmaterial, IntSerializer)
	EndpointManager.addEndpoint(skinmaterial.Companion::allItems, skinmaterial.list)

	EndpointManager.addEndpoint(skin.Companion::getItem, skin, IntSerializer)
	EndpointManager.addEndpoint(skin.Companion::allItems, skin.list)

	EndpointManager.addEndpoint(staoperation.Companion::getItem, staoperation, IntSerializer)
	EndpointManager.addEndpoint(staoperation.Companion::allItems, staoperation.list)

	EndpointManager.addEndpoint(staservice.Companion::getItem, staservice, IntSerializer)
	EndpointManager.addEndpoint(staservice.Companion::allItems, staservice.list)

	EndpointManager.addEndpoint(stastation.Companion::getItem, stastation, LongSerializer)
	EndpointManager.addEndpoint(stastation.Companion::allItems, stastation.list)

	EndpointManager.addEndpoint(stastationtype.Companion::getItem, stastationtype, IntSerializer)
	EndpointManager.addEndpoint(stastationtype.Companion::allItems, stastationtype.list)

	EndpointManager.addEndpoint(trntranslationcolumn.Companion::getItem, trntranslationcolumn, IntSerializer)
	EndpointManager.addEndpoint(trntranslationcolumn.Companion::allItems, trntranslationcolumn.list)

	EndpointManager.addEndpoint(trntranslationlanguage.Companion::getItem, trntranslationlanguage, IntSerializer)
	EndpointManager.addEndpoint(trntranslationlanguage.Companion::allItems, trntranslationlanguage.list)

	EndpointManager.addEndpoint(trntranslation.Companion::getItem, trntranslation, IntSerializer)
	EndpointManager.addEndpoint(trntranslation.Companion::allItems, trntranslation.list)

	EndpointManager.addEndpoint(warcombatzone.Companion::getItem, warcombatzone, IntSerializer)
	EndpointManager.addEndpoint(warcombatzone.Companion::allItems, warcombatzone.list)

	EndpointManager.addEndpoint(warcombatzonesystem.Companion::getItem, warcombatzonesystem, IntSerializer)
	EndpointManager.addEndpoint(warcombatzonesystem.Companion::allItems, warcombatzonesystem.list)
	
}
