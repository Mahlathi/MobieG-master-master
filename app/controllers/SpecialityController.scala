package controllers

import domain.stuff.Speciality
import play.api.libs.json.Json
import play.api.mvc._
import repository.SpecialityRepository.SpecialityRepository
import services.getFacilitatorSpecialityInt
import services.impl.getFacilitatorSpecialityImpl

/**
 * Created by Joseph on 2014/10/13.
 */
object SpecialityController extends Controller
{
   var  SpecList : List[SpecialityRepository#TableElementType] = null
  //for some reason repos is gone . #*!$
  val specObj : getFacilitatorSpecialityInt = new getFacilitatorSpecialityImpl

  implicit  val specJson = Json.reads[Speciality]

  def listAll() = Action
  {
    val all = specObj.getAll()
    val json = Json.toJson(all)
    Ok(json)
  }


}
