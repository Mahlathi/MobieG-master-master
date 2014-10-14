package services.crudservices

import domain.people.Facilitator
import people.Members

/**
 * Created by alex on 2014/10/09.
 */
trait MembersCRUDInterface {

  def create( mem: Members, fac: Facilitator ): Members
  def read(others: String, id: String)
  def update( desc: String, id: String)
  def delete(id: String)

}
