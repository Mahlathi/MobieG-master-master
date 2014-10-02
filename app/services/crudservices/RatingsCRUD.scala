package services.crudservices

import domain.stuff.Ratings
import repository.FacilitatorRepository.FacilitatorRepository
import repository.RatingRepository.RatingRepository
import scala.slick.driver.MySQLDriver.simple._
import scala.slick.lifted.TableQuery

/**
 * Created by akhona on 2014/10/02.
 */
class RatingsCRUD {
  val ratrepo = TableQuery[RatingRepository]
  val facilitator = TableQuery[FacilitatorRepository]



  Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession { implicit session =>

    //Creating tables
    //ratrepo.ddl.create


    //info("Creating a Care Plan")


    //val fac = Facilitator("13")

    //val chan = Ratings("42", 7, "Well does it son", fac.id)

    //val other = facilitator.insert(fac)

    //val valo = ratrepo.insert(chan)


    //Testing for extraction
    def Read(name: String, id: String) =
      ratrepo foreach { case (count: Ratings) =>

      }

    def Update( desc: String, id: String) =
    {
      ratrepo.filter(_.id === id).map(_.comment).update(desc)
      ratrepo foreach { case ( chann: Ratings ) =>

      }
    }

    def Delete(id: String) =
    {
      ratrepo.filter(_.id === id).delete
      facilitator.filter(_.id === id).delete
      ratrepo foreach { case (chann: Ratings) =>

      }
    }


    Read("You tried mate", "42")

    Update("You tried mate", "42")

    Delete("42")

  }
}
