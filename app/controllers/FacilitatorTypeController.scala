package controllers

/**
 * Created by akhona on 2014/10/10.
 */

import domain.people.Facilitator
import models.{FacilitatorModel, FacilitatorTypeModel}
import people.FacilitatorType
import play.api.libs.json.Json
import play.api.mvc._
import services.crudservices.{FacilitatorTypeCRUD, FacilitatorTypeCRUDInterface}
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object FacilitatorTypeController extends Controller{
  implicit val adminWrites = Json.writes[FacilitatorType]
  implicit val facsWrites = Json.writes[Facilitator]

  def create( fac: String, convo: String ) = Action.async(parse.json)
  {
    request =>
      val input = request.body
      val chanModel = Json.fromJson[FacilitatorTypeModel](input).get
      val chanzoModel = Json.fromJson[FacilitatorModel](input).get
      val admin = chanModel.getDomain()
      val chanzo = chanzoModel.getDomain()
      val obj: FacilitatorTypeCRUDInterface = new FacilitatorTypeCRUD
      val res = obj.create(chanzo, admin)
      val other = admin.copy(id = convo)
      val otherz = chanzo.copy(id = fac)
      val results: Future[FacilitatorType] = Future{res}
      results.map(resu => Ok(Json.toJson(resu)))
  }

  def update( chan: String, id: String ) = Action.async(parse.json)
  {
    request =>
      val input = request.body
      val chanModel = Json.fromJson[FacilitatorTypeModel](input).get
      val chanzoModel = Json.fromJson[FacilitatorModel](input).get
      val admin = chanModel.getDomain()
      //val chanzo = chanzoModel.getDomain()
      val obj: FacilitatorTypeCRUDInterface = new FacilitatorTypeCRUD
      val res = obj.update(chan, id)
      val results: Future[String] = Future{res.toString}
      results.map(result => Ok(Json.toJson(result)))
  }

  def delete(id:String) = Action{

    val obj: FacilitatorTypeCRUDInterface = new FacilitatorTypeCRUD
    val res = obj.delete(id)
    Ok("Deleted")
  }

  def read(id: String, description: String ) = Action
  {
    val obj: FacilitatorTypeCRUDInterface = new FacilitatorTypeCRUD
    //val admin = chanModel.getDomain()
    val res = obj.read(description, id)
    val json = Json.toJson(res)
    Ok(json)
  }

}
