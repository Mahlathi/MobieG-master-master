package controllers

/**
 * Created by akhona on 2014/10/01.
 */

import people.Person
import play.api.mvc._
import play.api.libs.json._
import repository.PersonRepository.PersonRepository
import services.getAllFacilitatorsInt
import services.impl.getAllFacilitatorsImpl

object ListFacilitatorsController extends Controller{

  var facList: List[PersonRepository#TableElementType] = null

  val testthree: getAllFacilitatorsInt = new getAllFacilitatorsImpl

  facList = testthree.getAll()
  //val newOther = facList.map( p => p.firstname )

  implicit val facsWrites = Json.writes[Person]

  def listFacilitators = Action{

    val json = Json.toJson(facList)
    Ok(json)
  }

  def index = Action {

      Ok(views.html.index("All is well!"))

  }
}
