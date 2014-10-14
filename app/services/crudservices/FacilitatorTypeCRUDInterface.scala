package services.crudservices

import domain.people.Facilitator
import people.FacilitatorType

/**
 * Created by alex on 2014/10/09.
 */
trait FacilitatorTypeCRUDInterface {

  def create( fac: Facilitator, typ: FacilitatorType ): FacilitatorType
  def read(descri: String, id: String)
  def update(desc: String, id: String)
  def delete(id: String)

}
