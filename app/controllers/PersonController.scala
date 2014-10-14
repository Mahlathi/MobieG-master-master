package controllers

/**
 * Created by akhona on 2014/10/10.
 */

import domain.people.Facilitator
import models.{AdminModel, FacilitatorModel}
import models.crudmodels.{MembersModel, PersonModel}
import people.{Admin, Members, Person}
import play.api.libs.json.Json
import play.api.mvc._
import services.crudservices.{PersonCRUDInterface, PersonCRUD}
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object PersonController extends Controller{
  implicit val personWrites = Json.writes[Person]
  implicit val facsWrites = Json.writes[Facilitator]
  implicit val adminWrites = Json.writes[Admin]
  implicit val memberWrites = Json.writes[Members]

  def create( mem: String, adm: String, fac: String, perc: String ) = Action.async(parse.json)
  {
    request =>
      val input = request.body
      val chanModel = Json.fromJson[PersonModel](input).get
      val chanzoModel = Json.fromJson[FacilitatorModel](input).get
      val othr = Json.fromJson[AdminModel](input).get
      val thrz = Json.fromJson[MembersModel](input).get
      val admin = chanModel.getDomain
      val chanzo = chanzoModel.getDomain()
      val one = othr.getDomain()
      val two = thrz.getDomain
      val obj: PersonCRUDInterface = new PersonCRUD
      val res = obj.create(chanzo, two, one, admin)
      val other = admin.copy(id = mem)
      val othera = chanzo.copy(id = adm)
      val otherb = one.copy(id = fac)
      val otherc = two.copy(id = perc)
      val results: Future[Person] = Future{res}
      results.map(resu => Ok(Json.toJson(resu)))
  }

  def update( chan: String, id: String ) = Action.async(parse.json)
  {
    request =>
      val input = request.body
      val chanModel = Json.fromJson[MembersModel](input).get
      val chanzoModel = Json.fromJson[FacilitatorModel](input).get
      val admin = chanModel.getDomain
      //val chanzo = chanzoModel.getDomain()
      val obj: PersonCRUDInterface = new PersonCRUD
      val res = obj.update(chan, id)
      val results: Future[String] = Future{res.toString}
      results.map(result => Ok(Json.toJson(result)))
  }

  def delete(id:String) = Action{

    val obj: PersonCRUDInterface = new PersonCRUD
    val res = obj.delete(id)
    Ok("Deleted")
  }

  def read(id: String, name: String ) = Action
  {
    val obj: PersonCRUDInterface = new PersonCRUD
    //val admin = chanModel.getDomain()
    val res = obj.read(name, id)
    val json = Json.toJson(res)
    Ok(json)
  }
}
