package services.crudservices

import domain.people.Facilitator
import people.FacilitatorType
import repository.FacilitatorRepository.FacilitatorRepository
import repository.FacilitatorTypeRepository.FacilitatorTypeRepository

import scala.slick.lifted.TableQuery
import scala.slick.driver.MySQLDriver.simple._
/**
 * Created by akhona on 2014/10/02.
 */
class FacilitatorTypeCRUD extends FacilitatorTypeCRUDInterface {
  val facirepo = TableQuery[FacilitatorTypeRepository]
  val facilitator = TableQuery[FacilitatorRepository]

  override def create(fac: Facilitator, typ: FacilitatorType): FacilitatorType = {
    Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession { implicit session =>

      val other = facilitator.insert(fac)
      val valo = facirepo.insert(typ)
    }
    typ
  }

  override def read(descri: String, id: String) = {
    Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession { implicit session =>

      facirepo foreach { case (count: FacilitatorType) =>
      }
    }
  }

  override def update(desc: String, id: String) = {
    Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession { implicit session =>

      facirepo.filter(_.id === id).map(_.description).update(desc)
      facirepo foreach { case (chann: FacilitatorType) =>

      }
    }
  }

  override def delete(id: String) = {
    Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession { implicit session =>

      facirepo.filter(_.id === id).delete
      facilitator.filter(_.id === id).delete
      facirepo foreach { case (chann: FacilitatorType) =>

      }
    }
  }



  Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession { implicit session =>

    //Creating tables
    //facirepo.ddl.create


     def create( fac: Facilitator, typ: FacilitatorType ) = {
        val other = facilitator.insert(fac)
       val valo = facirepo.insert(typ)
    }

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
  }
}
