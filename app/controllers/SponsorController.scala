package controllers

/**
 * Created by akhona on 2014/10/14.
 */

import domain.people.Facilitator
import domain.stuff.{Speciality, Channel, Sponsor}
import models.{ChannelModel, FacilitatorModel}
import models.crudmodels.{SpecialityModel, SponsorModel}
import services.crudservices.Impl.SponsorCRUD
import services.crudservices.SponsorCRUDInterface

import scala.concurrent.Future
import play.api.libs.json.Json
import play.api.mvc._
import scala.concurrent.ExecutionContext.Implicits.global

object SponsorController extends Controller{
  implicit val roleWrites = Json.writes[Sponsor]
  implicit val facsWrites = Json.writes[Facilitator]
  implicit val chanWrites = Json.writes[Channel]
  implicit val specialityWrites = Json.writes[Speciality]

  def create( Sponsor: String ) = Action.async(parse.json)
  {
    request =>
      val input = request.body
      val chanModel = Json.fromJson[SponsorModel](input).get
      val admin = chanModel.getDomain()
      val chanzoModel = Json.fromJson[FacilitatorModel](input).get
      val chanzo = chanzoModel.getDomain()
      val chanModela = Json.fromJson[SpecialityModel](input).get
      val admina = chanModela.getDomain()
      val chanzoModelb = Json.fromJson[ChannelModel](input).get
      val chanzos = chanzoModelb.getDomain()
      val obj: SponsorCRUDInterface = new SponsorCRUD
      val res = obj.create(chanzo,chanzos, admina, admin)
      //val other = admin.copy(id = spo)
      val results: Future[Sponsor] = Future{res}
      results.map(resu => Ok(Json.toJson(resu)))
  }

  /**def update( chan: String, id: String ) = Action.async(parse.json)
  {
    request =>
      val input = request.body
      val chanModel = Json.fromJson[SponsorModel](input).get
      val chanzoModel = Json.fromJson[FacilitatorModel](input).get
      val admin = chanModel.getDomain
      //val chanzo = chanzoModel.getDomain()
      val obj: SponsorCRUDInterface = new SponsorCRUD
      val res = obj.update(chan, id)
      val results: Future[String] = Future{res.toString}
      results.map(result => Ok(Json.toJson(result)))
  }

  def read(id: String, otherid: String ) = Action
  {
    val obj: SponsorCRUDInterface = new SponsorCRUD
    //val admin = chanModel.getDomain()
    val res = obj.read(otherid, id)
    val json = Json.toJson(res)
    Ok(json)
  }

  def delete(id:String) = Action{

    val obj: SponsorCRUDInterface = new SponsorCRUD
    val res = obj.delete(id)
    Ok("Deleted")
  }**/
}
