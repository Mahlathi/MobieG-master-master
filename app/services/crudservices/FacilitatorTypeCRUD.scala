package services.crudservices

import people.FacilitatorType
import repository.FacilitatorRepository.FacilitatorRepository
import repository.FacilitatorTypeRepository.FacilitatorTypeRepository

import scala.slick.lifted.TableQuery
import scala.slick.driver.MySQLDriver.simple._
/**
 * Created by akhona on 2014/10/02.
 */
class FacilitatorTypeCRUD {
  val facirepo = TableQuery[FacilitatorTypeRepository]
  val facilitator = TableQuery[FacilitatorRepository]



  Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession { implicit session =>

    //Creating tables
    //facirepo.ddl.create


    //info("Creating a Care Plan")

    //        val fac = Facilitator("126")

    //       val chan = FacilitatorType("147", "Medical", "Help with any medical probelm", fac.id)



    //     val other = facilitator.insert(fac)

    //   val valo = facirepo.insert(chan)

    //val fac = Facilitator("121")

    //val chan = FacilitatorType("144", "John", "Spoken word", fac.id)



    //val other = facilitator.insert(fac)

    // val valo = facirepo.insert(chan)

    //assert(results.size == 2)

    //Testing for extraction
    def Read(descri: String, id: String) =
      facirepo foreach { case (count: FacilitatorType) =>



      }



    def Update(desc: String, id: String) = {
      facirepo.filter(_.id === id).map(_.description).update(desc)
      facirepo foreach { case (chann: FacilitatorType) =>

      }
    }



    def Delete(id: String) = {
      facirepo.filter(_.id === id).delete
      facilitator.filter(_.id === id).delete
      facirepo foreach { case (chann: FacilitatorType) =>

      }
    }


    Read("Spoken word", "144")

    Update("Spoken word", "144")


    Delete("144")


  }
}
