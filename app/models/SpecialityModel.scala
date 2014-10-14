package models.crudmodels

import domain.stuff.Speciality
import play.api.libs.json.Json

/**
 * Created by alex on 2014/10/09.
 */
case class SpecialityModel(id:String, specialityName:String, specialityDescription:String, facilitatorId:String) {
      def getDomain(): Speciality = SpecialityModel.domain(this)
}

object SpecialityModel{
  implicit val specialityfmt = Json.format[SpecialityModel]

  def domain(model: SpecialityModel) ={
    Speciality(model.id, model.specialityName, model.specialityDescription, model.facilitatorId)
  }
}
