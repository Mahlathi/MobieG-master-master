package services.crudservices

import domain.people.Facilitator
import domain.stuff.Ratings
import repository.FacilitatorRepository.FacilitatorRepository
import repository.RatingRepository.RatingRepository
import scala.slick.driver.MySQLDriver.simple._
import scala.slick.lifted.TableQuery

/**
 * Created by akhona on 2014/10/02.
 */
class RatingsCRUD extends RatingsCRUDInterface{
  val ratrepo = TableQuery[RatingRepository]
  val facilitator = TableQuery[FacilitatorRepository]

  override def create( fac: Facilitator, rat: Ratings ): Ratings ={
    Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession { implicit session =>

      val other = facilitator.insert(fac)

      val valo = ratrepo.insert(rat)
    }
    rat
  }

  //Testing for extraction
  override def read(name: String, id: String) = {
    Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession { implicit session =>

      ratrepo foreach { case (count: Ratings) =>

      }
    }
  }

  override def update( desc: String, id: String) =
  {
    Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession { implicit session =>

      ratrepo.filter(_.id === id).map(_.comment).update(desc)
      ratrepo foreach { case (chann: Ratings) =>

      }
    }
  }

  override def delete(id: String) =
  {
    Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession { implicit session =>

      ratrepo.filter(_.id === id).delete
      facilitator.filter(_.id === id).delete
      ratrepo foreach { case (chann: Ratings) =>

      }
    }
  }


  Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession { implicit session =>

    //Creating tables
    //ratrepo.ddl.create

    def create( fac: Facilitator, rat: Ratings ) =
    {
      val other = facilitator.insert(fac)

      val valo = ratrepo.insert(rat)
    }

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
  }
}
