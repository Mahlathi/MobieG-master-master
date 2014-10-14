package services.crudservices

import domain.people.Facilitator
import people.{Person, Admin, Members}

/**
 * Created by alex on 2014/10/09.
 */
trait PersonCRUDInterface {

  def create( fac: Facilitator, mem: Members, adm: Admin, perc: Person )
  def read(name: String, id: String)
  def update( desc: String, id: String)
  def delete(id: String)
}
