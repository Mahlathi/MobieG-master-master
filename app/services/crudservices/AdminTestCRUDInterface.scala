package services.crudservices

import people.Admin
import repository.AdminRepository.AdminRepository

/**
 * Created by akhona on 2014/10/07.
 */
trait AdminTestCRUDInterface {

  def create( admin: Admin ): Admin
  def update(id: String): String
  def read(id: String): List[AdminRepository#TableElementType]
  def delete(id: String): String


}
