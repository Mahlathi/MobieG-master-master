package services.crudservices


import people.Admin
import repository.AdminRepository.AdminRepository
import repository.ConversationMessageRepository.ConversationMessageRepository
import repository.MemberEncountersRepository.MemberEncountersRepository
import scala.slick.driver.MySQLDriver.simple._
import scala.slick.lifted.TableQuery

/**
 * Created by akhona on 2014/10/02.
 */
class AdminCRUD {
  val adminrepo = TableQuery[AdminRepository]
  val memEncounterrepo = TableQuery[MemberEncountersRepository]
  val conversationMessage = TableQuery[ConversationMessageRepository]



  Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession { implicit session =>

    //Creating tables
    //admin.ddl.create

    //Inserting
    //info("Creating Admin")
    //val admins = Admin("12")

    //val valo = adminrepo.insert(admins)
    //memEncounterrepo.ddl.create

    // val insertMemEncounter = MemberEncounter("104","23 September 2014 20:00","23 September 2014 21:00","4","5")

    // val valo = memEncounterrepo.insert(insertMemEncounter)

    //conversationMessage.ddl.create
    //val insertConversationMess = ConversationMessage("1","","11","5","4")
    //val valo = conversationMessage.insert(insertConversationMess)

    //Testing for extraction
    def Read(id: String) =
      adminrepo foreach { case (count: Admin) =>

      }

    def Update(id: String) = {

      adminrepo.filter(_.id === id).map(_.id).update(id)
      adminrepo foreach { case (chann: Admin) =>

      }
    }


    def Delete(id: String) = {
      adminrepo.filter(_.id === id).delete
      adminrepo foreach { case (chann: Admin) =>


      }
    }


    Read("12")

    Update("12")

    Delete("12")


}
}
