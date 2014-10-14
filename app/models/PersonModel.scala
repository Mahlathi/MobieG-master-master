package models.crudmodels

import people.Person
import play.api.libs.json.Json

/**
 * Created by alex on 2014/10/08.
 */
case class PersonModel(id:String,
                  title:String,
                  firstname:String,
                  surname:String,
                  othername:String,
                  username:String,
                  password:String,
                  email:String,
                  adminId:String,
                  facilitatorId:String,
                  membersId:String
                   ){

  def getDomain(): Person = PersonModel.domain(this)
}

object PersonModel{
  implicit lazy val personfmt = Json.format[PersonModel]

  def domain(model: PersonModel) ={
    Person(model.id, model.title, model.firstname, model.surname, model.othername, model.username, model.password, model.email, model.adminId, model.facilitatorId, model.membersId)
  }



}
