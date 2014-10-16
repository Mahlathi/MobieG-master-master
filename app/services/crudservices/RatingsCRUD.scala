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
  override def read(name: String, id: String): List[RatingRepository#TableElementType] = {
    Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession { implicit session =>

     val repo = ratrepo.list
     val input = repo.filter( p=> p.id == id && p.comment == name )
      input
    }
  }

  override def update( desc: String, id: String) =
  {
    Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession { implicit session =>

      ratrepo.filter(_.id === id).map(_.comment).update(desc)

    }
  }

  override def delete(id: String) =
  {
    Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession { implicit session =>

      ratrepo.filter(_.id === id).delete
      facilitator.filter(_.id === id).delete

    }
  }
}
