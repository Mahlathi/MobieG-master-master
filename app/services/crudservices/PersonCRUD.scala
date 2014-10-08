package services.crudservices

import domain.people.Facilitator
import people.{Admin, Members, Person}
import repository.AdminRepository.AdminRepository
import repository.FacilitatorRepository.FacilitatorRepository
import repository.MembersRepository.MembersRepository
import repository.PersonRepository.PersonRepository
import scala.slick.driver.MySQLDriver.simple._
import scala.slick.lifted.TableQuery

/**
 * Created by akhona on 2014/10/02.
 */
class PersonCRUD {
  val admin = TableQuery[AdminRepository]
  val facilitator = TableQuery[FacilitatorRepository]
  val memrepo = TableQuery[MembersRepository]
  val peeps = TableQuery[PersonRepository]


  Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession { implicit session =>

    //Creating tables
    //peeps.ddl.create

     def create( fac: Facilitator, mem: Members, adm: Admin, perc: Person ) = {

        val one = facilitator.insert(fac)

        val two = memrepo.insert(mem)

        val three = admin.insert(adm)

        val four = peeps.insert(perc)
     }

    //Testing for extraction
    def Read(name: String, id: String) =
      peeps foreach { case (count: Person) =>



      }

    def Update( desc: String, id: String) =
    {
      peeps.filter(_.id === id).map(_.firstname).update(desc)
      peeps foreach { case ( chann: Person ) =>

      }
    }

    def Delete(id: String) =
    {
      peeps.filter(_.id === id).delete
      admin.filter(_.id === id).delete
      memrepo.filter(_.id === id).delete
      facilitator.filter(_.id === id).delete
      peeps foreach { case (chann: Person) =>

      }
    }
  }
}
