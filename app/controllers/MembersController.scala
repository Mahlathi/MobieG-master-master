package controllers

/**
 * Created by akhona on 2014/10/10.
 */

import domain.people.Facilitator
import models.FacilitatorModel
import models.crudmodels.MembersModel
import people.Members
import play.api.libs.json.Json
import play.api.mvc._
import services.crudservices.{MembersCRUD, MembersCRUDInterface}
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object MembersController extends Controller{
  implicit val adminWrites = Json.writes[Members]
  implicit val facsWrites = Json.writes[Facilitator]

  def create( mem: String, fac: String ) = Action.async(parse.json)
  {
    request =>
      val input = request.body
      val chanModel = Json.fromJson[MembersModel](input).get
      val chanzoModel = Json.fromJson[FacilitatorModel](input).get
      val admin = chanModel.getDomain
      val chanzo = chanzoModel.getDomain()
      val obj: MembersCRUDInterface = new MembersCRUD
      val res = obj.create(admin, chanzo)
      val other = admin.copy(id = mem)
      val otherz = chanzo.copy(id = fac)
      val results: Future[Members] = Future{res}
      results.map(resu => Ok(Json.toJson(resu)))
  }

  def update( chan: String ) = Action.async(parse.json)
  {
    request =>
      val input = request.body
      val chanModel = Json.fromJson[MembersModel](input).get
      val chanzoModel = Json.fromJson[FacilitatorModel](input).get
      val admin = chanModel.getDomain
      //val chanzo = chanzoModel.getDomain()
      val obj: MembersCRUDInterface = new MembersCRUD
      val res = obj.update(admin.facilitatorId, admin.id)
      val results: Future[String] = Future{res.toString}
      results.map(result => Ok(Json.toJson(result)))
  }

  def delete(id:String) = Action{

    val obj: MembersCRUDInterface = new MembersCRUD
    val res = obj.delete(id)
    Ok("Deleted")
  }

  def read(id: String, otherid: String ) = Action
  {
    val obj: MembersCRUDInterface = new MembersCRUD
    //val admin = chanModel.getDomain()
    val res = obj.read(otherid, id)
    val json = Json.toJson(res)
    Ok(json)
  }
}
