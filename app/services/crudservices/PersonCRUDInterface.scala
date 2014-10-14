package services.crudservices

import domain.people.Facilitator
import people.{Person, Admin, Members}
import repository.PersonRepository.PersonRepository

/**
 * Created by alex on 2014/10/09.
 */
trait PersonCRUDInterface {

  def create( fac: Facilitator, mem: Members, adm: Admin, perc: Person ): Person
  def read(name: String, id: String): List[PersonRepository#TableElementType]
  def update( desc: String, id: String)
  def delete(id: String)
}
