package controllers

/**
 * Created by akhona on 2014/10/02.
 */

import models.AdminModel
import people.Admin
import play.api.libs.json._
import play.api.mvc._
import services.crudservices.{AdminTestCRUDInterface, AdminCRUD}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object AdminController extends Controller {

    implicit val adminWrites = Json.writes[Admin]

    def create( adms: String) = Action.async(parse.json)
    {
          request =>
          val input = request.body
          //print("Body",input)
          val adminModel = Json.fromJson[AdminModel](input).get
          val admin = adminModel.getDomain()
          val adm: AdminTestCRUDInterface = new AdminCRUD
          val res = adm.create(admin)
          val other = admin.copy(id = adms)
          val results: Future[Admin] = Future{res}
          results.map(result => Ok(Json.toJson(result)))
    }

  def update( adms: String) = Action.async(parse.json)
  {
    request =>
      val input = request.body
      //print("Body",input)
      val adminModel = Json.fromJson[AdminModel](input).get
      val admin = adminModel.getDomain()
      val adm: AdminTestCRUDInterface = new AdminCRUD
      val other = admin.copy(id = adms)
      val res = adm.update(adms)
      val results: Future[String] = Future{res.toString}
      results.map(result => Ok(Json.toJson(result)))
  }


  def delete(id:String) = Action{

      val adm: AdminTestCRUDInterface = new AdminCRUD
      val res = adm.delete(id)
      Ok("Deleted")
  }

  def read(id: String ) = Action
  {
    val adm: AdminTestCRUDInterface = new AdminCRUD
    val res = adm.read(id)
    val json = Json.toJson(res)
    Ok(json)
  }

}
