package controllers

import models.{AdminModel, FacilitatorModel}
import models.crudmodels.{MembersModel, PersonModel}
import people.{Admin, Person}
import play.api.libs.json.Json
import play.api.mvc.Controller
import play.api.mvc._
import services.PersonServices
import services.crudservices.{PersonCRUD, PersonCRUDInterface}
import services.impl.PersonServiceImpl
import scala.concurrent.Future


/**
 * Created by joseph on 2014/10/09.
 */
object PersonController extends Controller
{
    implicit  val personWrites = Json.writes[Person]

  def create() = Action.async(parse.json)
  {
    request =>

      val input = request.body

      val personModel = Json.fromJson[PersonModel](input).get
      val memberModel = Json.fromJson[MembersModel](input).get
      val facilitatorModel = Json.fromJson[FacilitatorModel](input).get
      val adminModel = Json.fromJson[AdminModel](input).get

      val person = personModel.getDomain()
      val member = memberModel.getDomain()
      val facil = facilitatorModel.getDomain()
      val admin = adminModel.getDomain()


      val persn : PersonCRUDInterface = new  PersonCRUD
      val creatingPerson = persn.create(facil,member,admin,person)

      val result : Future[Admin] = Future{admin}
      result.map(result => Ok(Json.toJson(result)))

  }

  def personById(id : String) = Action//.async()
  {
    val objPerson : PersonServices = new PersonServiceImpl
    val all = objPerson.getPersonWithId(id)
    val what = Json.toJson(all)
    Ok(what)
  }


}
