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

object CreateAdminController extends Controller
{

    //val adm: AdminCRUD = new AdminCRUD

    implicit val adminWrites = Json.writes[Admin]

    def create( adms: String) = Action.async(parse.json)
    {
          request =>
          val input = request.body
          val adminModel = Json.fromJson[AdminModel](input).get
          val admin = adminModel.getDomain()
          val adm: AdminTestCRUDInterface = new AdminCRUD
          val res = adm.create(admin)
          //println(" DO We have the ID!!!", res.id)
          val results: Future[Admin] = Future{res}
//        val results = adm.create(admin)

          results.map(result => Ok(

          Json.toJson(result)))

    }

}
