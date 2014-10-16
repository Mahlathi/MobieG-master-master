package services.crudservices

import domain.people.Facilitator
import domain.stuff.Speciality
import repository.SpecialityRepository.SpecialityRepository

/**
 * Created by alex on 2014/10/09.
 */
trait SpecialityCRUDInterface {

  def create( fac: Facilitator, spec: Speciality ): Speciality
  def read(name: String, id: String): List[SpecialityRepository#TableElementType]
  def update( desc: String, id: String)
  def delete(id: String)
}
