package services.crudservices

import domain.people.Facilitator
import domain.stuff.Speciality

/**
 * Created by alex on 2014/10/09.
 */
trait SpecialityCRUDInterface {

  def create( fac: Facilitator, spec: Speciality ): Speciality
  def read(name: String, id: String)
  def update( desc: String, id: String)
  def delete(id: String)
}
