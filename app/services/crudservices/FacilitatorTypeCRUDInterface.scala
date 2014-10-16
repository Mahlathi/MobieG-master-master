package services.crudservices

import domain.people.Facilitator
import people.FacilitatorType
import repository.FacilitatorTypeRepository.FacilitatorTypeRepository

/**
 * Created by alex on 2014/10/09.
 */
trait FacilitatorTypeCRUDInterface {

  def create( fac: Facilitator, typ: FacilitatorType ): FacilitatorType
  def read(descri: String, id: String): List[FacilitatorTypeRepository#TableElementType]
  def update(desc: String, id: String)
  def delete(id: String)

}
