package services.crudservices

import people.Role
import repository.RoleRepository.RoleRepository

import scala.slick.lifted.TableQuery
import scala.slick.driver.MySQLDriver.simple._
/**
 * Created by akhona on 2014/10/02.
 */
class RoleCRUD {
  val role = TableQuery[RoleRepository]




  Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession { implicit session =>

    //Creating tables
    // role.ddl.create


    //info("Creating a Care Plan")
    //val chan = Role("14", "assistant", "Very easy")

    //val valo = role.insert(chan)


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


    Read("Hotness sanas", "14")

    Update("Hotness sana", "14")

    Delete("14")

  }
}
