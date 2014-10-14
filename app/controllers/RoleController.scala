package controllers

import models.RoleModel
import people.Role
import services.RoleServices
import services.crudservices.{RoleCRUDInterface, RoleCRUD}
import services.impl.RoleServiceImpl

import scala.concurrent.ExecutionContext.Implicits.global
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}

import scala.concurrent.Future

/**
 * Created by joseph on 2014/10/07.
 */
object RoleController extends Controller
{
  implicit val roleWrites = Json.writes[Role]

  def create( adms : String) = Action.async(parse.json)
  {
    request =>
      val input = request.body
      val roleModel = Json.fromJson[RoleModel](input).get
      val roleDom = roleModel.getDomain()
      val rl : RoleCRUDInterface = new RoleCRUD
      val role = rl.create(roleDom)
      val results: Future[Role] = Future{role}
      results.map(result=>Ok(Json.toJson(result)))
  }

  def roleById(id :String)  = Action//.async//(parse.json)
  {
    //request =>
      val objRole : RoleServices = new RoleServiceImpl
      val all = objRole.roleById(id)
    val what = Json.toJson(all)
    Ok(what)

     // all //map(rol => Ok(Json.toJson(rol)))
  }

  def listAllRoles() = Action//.async
   {
    //request =>
        val objRole : RoleServices = new RoleServiceImpl
        val all = objRole.allServices()
        val what = Json.toJson(all)
        Ok(what)
    //all map ( rol => {
    //Ok (Json.toJson(rol))
    //})
   }

}
