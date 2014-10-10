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
class PersonCRUD extends  PersonCRUDInterface
{
  val admin = TableQuery[AdminRepository]
  val facilitator = TableQuery[FacilitatorRepository]
  val memrepo = TableQuery[MembersRepository]
  val peeps = TableQuery[PersonRepository]

    //Creating tables
    //peeps.ddl.create


  override def create(fac: Facilitator, mem: Members, adm: Admin, perc: Person) =
    {
      Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession
      {
        implicit session =>
          val one = facilitator.insert(fac)

          val two = memrepo.insert(mem)

          val three = admin.insert(adm)

          val four = peeps.insert(perc)
      }
    }

  override def update(desc: String, id: String): Unit =
    {
      Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession {
        implicit session =>
          peeps.filter(_.id === id).map(_.firstname).update(desc)
          peeps foreach {
            case (chann: Person) =>

          }
      }
    }

  override def delete(id: String): Unit =
  {
    Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession {
      implicit session =>
        peeps.filter(_.id === id).delete
        admin.filter(_.id === id).delete
        memrepo.filter(_.id === id).delete
        facilitator.filter(_.id === id).delete
        peeps foreach { case (chann: Person) =>

        }
    }
  }

  override def read(name: String, id: String): Unit =
  {
    peeps foreach
      {
        case (count: Person) =>
      }
  }

}
