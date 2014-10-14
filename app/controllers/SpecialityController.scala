package controllers

/**
 * Created by akhona on 2014/10/14.
 */

import domain.people.Facilitator
import domain.stuff.Speciality
import models.FacilitatorModel
import models.crudmodels.SpecialityModel
import services.crudservices.{SpecialityCRUD, SpecialityCRUDInterface}

import scala.concurrent.Future
import play.api.libs.json.Json
import play.api.mvc._
import scala.concurrent.ExecutionContext.Implicits.global

object SpecialityController extends Controller{
  implicit val roleWrites = Json.writes[Speciality]
  implicit val adminWrites = Json.writes[Facilitator]

  def create( mem: String, fac: String ) = Action.async(parse.json)
  {
    request =>
      val input = request.body
      val chanModel = Json.fromJson[SpecialityModel](input).get
      val admin = chanModel.getDomain()
      val chanzoModel = Json.fromJson[FacilitatorModel](input).get
      val chanzo = chanzoModel.getDomain()
      val obj: SpecialityCRUDInterface = new SpecialityCRUD
      val res = obj.create(chanzo, admin)
      val other = admin.copy(id = mem)
      val results: Future[Speciality] = Future{res}
      results.map(resu => Ok(Json.toJson(resu)))
  }

  def update( chan: String, id: String ) = Action.async(parse.json)
  {
    request =>
      val input = request.body
      val chanModel = Json.fromJson[SpecialityModel](input).get
      val admin = chanModel.getDomain()
      val obj: SpecialityCRUDInterface = new SpecialityCRUD
      val res = obj.update(chan, id)
      val results: Future[String] = Future{res.toString}
      results.map(result => Ok(Json.toJson(result)))
  }

  def delete(id:String) = Action{

    val obj: SpecialityCRUDInterface = new SpecialityCRUD
    val res = obj.delete(id)
    Ok("Deleted")
  }

  def read(id: String, otherid: String ) = Action
  {
    val obj: SpecialityCRUDInterface = new SpecialityCRUD
    //val admin = chanModel.getDomain()
    val res = obj.read(otherid, id)
    val json = Json.toJson(res)
    Ok(json)
  }
}
