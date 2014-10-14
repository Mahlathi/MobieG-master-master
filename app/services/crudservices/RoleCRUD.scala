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
  override def read(name: String, id: String) = {
    Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession { implicit session =>

      role foreach { case (count: Role) =>

      }
    }
  }

  override def update( desc: String, id: String) =
  {
    Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession { implicit session =>

      role.filter(_.id === id).map(_.description).update(desc)
      role foreach { case (chann: Role) =>

      }
    }
  }

  override def delete(id: String) =
  {
    Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession { implicit session =>

      role.filter(_.id === id).delete
      role foreach { case (chann: Role) =>

      }
    }
  }


  Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession { implicit session =>

    //Creating tables
    // role.ddl.create

    def create( rol: Role ) =
    {
       val valo = role.insert(rol)
    }

    //Testing for extraction
    def Read(name: String, id: String) =
      role foreach { case (count: Role) =>

      }

    def Update( desc: String, id: String) =
    {
      role.filter(_.id === id).map(_.description).update(desc)
      role foreach { case ( chann: Role ) =>

      }
    }

    def Delete(id: String) =
    {
      role.filter(_.id === id).delete
      role foreach { case (chann: Role) =>

      }
    }
  }
}
