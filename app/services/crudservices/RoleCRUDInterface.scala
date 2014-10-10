package services.crudservices

import people.Role

/**
 * Created by joseph on 2014/10/09.
 */
trait RoleCRUDInterface
{
    def create (role :Role) : Role
}
