package services.crudservices

import people.Members
import repository.FacilitatorRepository.FacilitatorRepository
import repository.MembersRepository.MembersRepository

import scala.slick.lifted.TableQuery

/**
 * Created by akhona on 2014/10/02.
 */
import scala.slick.driver.MySQLDriver.simple._

class MembersCRUD {
  val memrepo = TableQuery[MembersRepository]
  val facilitator = TableQuery[FacilitatorRepository]



  Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession { implicit session =>

    //Creating tables
    //  memrepo.ddl.create


    //info("Creating a Care Plan")


    //val fac = Facilitator("100000")

    //       val chan = Members("113",fac.id)

    //     val other = facilitator.insert(fac)

    //    val valo = memrepo.insert(chan)


    //Testing for extraction
    def Read(others: String, id: String) =
      memrepo foreach { case (count: Members) =>

      }



    def Update( desc: String, id: String) =
    {
      memrepo.filter(_.id === id).map(_.facilitator_id).update(desc)
      memrepo foreach { case ( chann: Members ) =>

      }
    }



    def Delete(id: String) =
    {
      memrepo.filter(_.id === id).delete
      facilitator.filter(_.id === id).delete
      memrepo foreach { case (chann: Members) =>

      }
    }

    Read("123", "101")

    // Update("8", "61")

    //Delete("83")

  }
}
