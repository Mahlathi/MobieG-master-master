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

  override def read(name: String, id: String) = {
    Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession { implicit session =>

      convorepo foreach { case (count: Conversation) =>

      }
    }
  }

  override def update( desc: String, id: String) =
  {
    Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession { implicit session =>

      convorepo.filter(_.id === id).map(_.message).update(desc)
      convorepo foreach { case (chann: Conversation) =>

      }
    }
  }

  override def delete(id: String) =
  {
    Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession { implicit session =>

      convorepo.filter(_.id === id).delete
      facilitator.filter(_.id === id).delete
      convorepo foreach { case (chann: Conversation) =>

      }
    }
  }

  /*Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession { implicit session =>

    //Creating tables
    // convorepo.ddl.create


    def create( fac: Facilitator, convo: Conversation ) = {
      val other = facilitator.insert(fac)
      val valo = convorepo.insert(convo)
    }

    //Testing for extraction
    def Read(name: String, id: String) =
      convorepo foreach { case (count: Conversation) =>

      }

    def Update( desc: String, id: String) =
    {
      convorepo.filter(_.id === id).map(_.message).update(desc)
      convorepo foreach { case ( chann: Conversation ) =>

      }
    }

    def Delete(id: String) =
    {
      convorepo.filter(_.id === id).delete
      facilitator.filter(_.id === id).delete
      convorepo foreach { case (chann: Conversation) =>

      }
    }
  }*/
}


