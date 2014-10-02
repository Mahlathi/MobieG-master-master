package services.crudservices

import domain.stuff.Conversation
import repository.ConversationRepository.ConversationRepository
import repository.FacilitatorRepository.FacilitatorRepository

import scala.slick.lifted.TableQuery
import scala.slick.driver.MySQLDriver.simple._
/**
 * Created by akhona on 2014/10/02.
 */
class ConversationCRUD {
  val convorepo = TableQuery[ConversationRepository]
  val facilitator = TableQuery[FacilitatorRepository]



  Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession { implicit session =>

    //Creating tables
    // convorepo.ddl.create


    //info("Creating conversations")
    //val fac = Facilitator("15")



    //val chan = Conversation("12", "Winners win all the time", "4")


    //val other = facilitator.insert(fac)
    //val valo = convorepo.insert(chan)


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


    Read("Hotness sanas", "22")

    Update("Hotnesss sana", "22")

    Delete("22")

  }
}


