package services.crudservices

import people.Role
import repository.RoleRepository.RoleRepository

import scala.slick.lifted.TableQuery
import scala.slick.driver.MySQLDriver.simple._
/**
 * Created by akhona on 2014/10/02.
 */
class RoleCRUD extends RoleCRUDInterface{
  val role = TableQuery[RoleRepository]

  override def create( rol: Role ): Role = {
    Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession { implicit session =>

      val valo = role.insert(rol)
    }
    rol
  }

  //Testing for extraction
  override def read(name: String, id: String): List[RoleRepository#TableElementType] = {
    Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession { implicit session =>

     val repo = role.list
     val input = repo.filter(p => p.description == name && p.roleId == id)
     input
    }
  }

  override def update( desc: String, id: String) =
  {
    Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession { implicit session =>

      role.filter(_.id === id).map(_.description).update(desc)

    }
  }

  override def delete(id: String) =
  {
    Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession { implicit session =>

      role.filter(_.id === id).delete

    }
  }
}
