package controllers

/**
 * Created by akhona on 2014/10/14.
 */

import models.RoleModel
import people.Role
import services.crudservices.{RoleCRUDInterface, RoleCRUD}

import scala.concurrent.Future
import play.api.libs.json.Json
import play.api.mvc._
import scala.concurrent.ExecutionContext.Implicits.global

object RoleController extends Controller{
  implicit val roleWrites = Json.writes[Role]

  def create( mem: String ) = Action.async(parse.json)
  {
    request =>
      val input = request.body
      val chanModel = Json.fromJson[RoleModel](input).get
      val admin = chanModel.getDomain()
      val obj: RoleCRUDInterface = new RoleCRUD
      val res = obj.create(admin)
      val other = admin.copy(roleId = mem)
      val results: Future[Role] = Future{res}
      results.map(resu => Ok(Json.toJson(resu)))
  }

  def update( chan: String, id: String ) = Action.async(parse.json)
  {
    request =>
      val input = request.body
      val chanModel = Json.fromJson[RoleModel](input).get
      val admin = chanModel.getDomain()
      val obj: RoleCRUDInterface = new RoleCRUD
      val res = obj.update(chan, id)
      val results: Future[String] = Future{res.toString}
      results.map(result => Ok(Json.toJson(result)))
  }

  def delete(id:String) = Action{

    val obj: RoleCRUDInterface = new RoleCRUD
    val res = obj.delete(id)
    Ok("Deleted")
  }

  def read(id: String, otherid: String ) = Action
  {
    val obj: RoleCRUDInterface = new RoleCRUD
    //val admin = chanModel.getDomain()
    val res = obj.read(otherid, id)
    val json = Json.toJson(res)
    Ok(json)
  }
}
