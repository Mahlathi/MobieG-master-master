package services.crudservices

import people.Role
import repository.RoleRepository.RoleRepository

/**
 * Created by joseph on 2014/10/09.
 */
trait RoleCRUDInterface
{
    def create (role :Role) : Role
    def read(name: String, id: String): List[RoleRepository#TableElementType]
    def update( desc: String, id: String)
    def delete(id: String)
}
