package controllers

import domain.stuff.Sponsor
import play.api.mvc.{Action, Controller}
import repository.SponsorRepository.SponsorRepository
import play.api.libs.json.Json
import services.getAllSponsorInt
import services.impl.getAllSponsorImpl

/**
 * Created by Joseph on 2014/10/13.
 */
object SponsorController extends Controller
{
    var sponsorList : List[SponsorRepository#TableElementType] = null
    var sponObj : getAllSponsorInt = new getAllSponsorImpl

  implicit val sponRead = Json.reads[Sponsor]

  def listSponsors() = Action
  {
    val all = sponObj.getusersponsor()
    val json = Json.toJson(all)
    Ok(json)
  }
}
