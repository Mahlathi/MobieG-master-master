package services.crudservices

import domain.people.Facilitator
import domain.stuff.Conversation
import repository.ConversationRepository.ConversationRepository
import repository.FacilitatorRepository.FacilitatorRepository

import scala.slick.lifted.TableQuery
import scala.slick.driver.MySQLDriver.simple._
/**
 * Created by akhona on 2014/10/02.
 */
class ConversationCRUD extends ConversationCRUDInterface{
  val convorepo = TableQuery[ConversationRepository]
  val facilitator = TableQuery[FacilitatorRepository]

  override def create( fac: Facilitator, convo: Conversation ): Conversation= {
    Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession { implicit session =>

      val other = facilitator.insert(fac)
      val valo = convorepo.insert(convo)
    }
    convo
  }

  override def read(name: String, id: String) : List[ConversationRepository#TableElementType] ={
    Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession { implicit session =>

     val repo = convorepo.list
     val input = repo.filter( p => p.message == name && p.id == id )
     input
    }
  }

  override def update( desc: String, id: String) =
  {
    Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession { implicit session =>

      convorepo.filter(_.id === id).map(_.message).update(desc)
    }
  }

  override def delete(id: String) =
  {
    Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession { implicit session =>

      convorepo.filter(_.id === id).delete
      facilitator.filter(_.id === id).delete
    }
  }
}


