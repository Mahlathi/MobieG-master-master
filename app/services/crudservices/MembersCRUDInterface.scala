package services.crudservices

import domain.people.Facilitator
import people.Members
import repository.MembersRepository.MembersRepository

/**
 * Created by alex on 2014/10/09.
 */
trait MembersCRUDInterface {

  def create( mem: Members, fac: Facilitator ): Members
  def read(others: String, id: String): List[MembersRepository#TableElementType]
  def update( desc: String, id: String)
  def delete(id: String)

}
