package models.crudmodels

import people.FacilitatorType
import play.api.libs.json.Json

/**
 * Created by alex on 2014/10/08.
 */
case class FacilitatorTypeModel(id:String, name:String, description:String, facilitatorId:String) {
      def getDomain(): FacilitatorType = FacilitatorTypeModel.domain(this)
}

object FacilitatorTypeModel{
  implicit val facilitatortypefmt = Json.format[FacilitatorTypeModel]

  def domain(model: FacilitatorTypeModel) ={
    FacilitatorType(model.id, model.name, model.description, model.facilitatorId)
  }
}
