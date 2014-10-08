package services.crudservices

import people.Admin

/**
 * Created by akhona on 2014/10/07.
 */
trait AdminTestCRUDInterface {

  def create( admin: Admin ): Admin
}
