package controllers

/**
 * Created by akhona on 2014/10/10.
 */

import domain.people.Facilitator
import domain.stuff.Ratings
import models.{FacilitatorModel, RatingsModel}
import services.crudservices.{RatingsCRUDInterface, RatingsCRUD}

import scala.concurrent.Future
import play.api.libs.json.Json
import play.api.mvc._
import scala.concurrent.ExecutionContext.Implicits.global

object RatingsController extends Controller{
  implicit val adminWrites = Json.writes[Ratings]
  implicit val facsWrites = Json.writes[Facilitator]

  def create( mem: String, fac: String ) = Action.async(parse.json)
  {
    request =>
      val input = request.body
      val chanModel = Json.fromJson[RatingsModel](input).get
      val chanzoModel = Json.fromJson[FacilitatorModel](input).get
      val admin = chanModel.geDomain()
      val chanzo = chanzoModel.getDomain()
      val obj: RatingsCRUDInterface = new RatingsCRUD
      val res = obj.create(chanzo, admin)
      val other = admin.copy(id = mem)
      val otherz = chanzo.copy(id = fac)
      val results: Future[Ratings] = Future{res}
      results.map(resu => Ok(Json.toJson(resu)))
  }

  def update( chan: String, id: String ) = Action.async(parse.json)
  {
    request =>
      val input = request.body
      val chanModel = Json.fromJson[RatingsModel](input).get
      val chanzoModel = Json.fromJson[FacilitatorModel](input).get
      val admin = chanModel.geDomain()
      //val chanzo = chanzoModel.getDomain()
      val obj: RatingsCRUDInterface = new RatingsCRUD
      val res = obj.update(chan, id)
      val results: Future[String] = Future{res.toString}
      results.map(result => Ok(Json.toJson(result)))
  }

  def delete(id:String) = Action{

    val obj: RatingsCRUDInterface = new RatingsCRUD
    val res = obj.delete(id)
    Ok("Deleted")
  }

  def read(id: String, otherid: String ) = Action
  {
    val obj: RatingsCRUDInterface = new RatingsCRUD
    //val admin = chanModel.getDomain()
    val res = obj.read(otherid, id)
    val json = Json.toJson(res)
    Ok(json)
  }

}
