package services.crudservices

import domain.people.Facilitator
import domain.stuff.Speciality
import repository.FacilitatorRepository.FacilitatorRepository
import repository.SpecialityRepository.SpecialityRepository

import scala.slick.lifted.TableQuery
import scala.slick.driver.MySQLDriver.simple._
/**
 * Created by akhona on 2014/10/02.
 */
class SpecialityCRUD {
  val specsd = TableQuery[SpecialityRepository]
  val facilitator = TableQuery[FacilitatorRepository]



  Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession { implicit session =>

    //Creating tables
    //specsd.ddl.create


    def create( fac: Facilitator, spec: Speciality ) =
    {
       val other = facilitator.insert(fac)
       val valo = specsd.insert(spec)
    }

    //Testing for extraction
    def Read(name: String, id: String) =
      specsd foreach { case (count: Speciality) =>
     }

    def Update( desc: String, id: String) =
    {
      specsd.filter(_.id === id).map(_.description).update(desc)
      specsd foreach { case ( chann: Speciality ) =>

      }
    }

    def Delete(id: String) =
    {
      specsd.filter(_.id === id).delete
      facilitator.filter(_.id === id).delete
      specsd foreach { case (chann: Speciality) =>

      }
    }
  }
}
