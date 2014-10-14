package services.crudservices

import domain.people.Facilitator
import people.Members
import repository.FacilitatorRepository.FacilitatorRepository
import repository.MembersRepository.MembersRepository

import scala.slick.lifted.TableQuery

/**
 * Created by akhona on 2014/10/02.
 */
import scala.slick.driver.MySQLDriver.simple._

class MembersCRUD extends MembersCRUDInterface{
  val memrepo = TableQuery[MembersRepository]
  val facilitator = TableQuery[FacilitatorRepository]

  override def create( mem: Members, fac: Facilitator ): Members= {
    Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession { implicit session =>

      val other = facilitator.insert(fac)
      val valo = memrepo.insert(mem)
    }
    mem
  }

  override def read(others: String, id: String) = {
    Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession { implicit session =>

      memrepo foreach { case (count: Members) =>

      }
    }
  }

  override def update( desc: String, id: String) =
  {
    Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession { implicit session =>

      memrepo.filter(_.id === id).map(_.facilitator_id).update(desc)
      memrepo foreach { case (chann: Members) =>

      }
    }
  }

  override def delete(id: String) =
  {
    Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession { implicit session =>

      memrepo.filter(_.id === id).delete
      facilitator.filter(_.id === id).delete
      memrepo foreach { case (chann: Members) =>

      }
    }
  }


  Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession { implicit session =>

    //Creating tables
    //  memrepo.ddl.create

    def create( mem: Members, fac: Facilitator ) = {

           val other = facilitator.insert(fac)
           val valo = memrepo.insert(mem)
    }

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
  }
}
