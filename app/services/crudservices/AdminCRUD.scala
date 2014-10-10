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
class AdminCRUD extends AdminTestCRUDInterface{
  val adminrepo = TableQuery[AdminRepository]
  val memEncounterrepo = TableQuery[MemberEncountersRepository]
  val conversationMessage = TableQuery[ConversationMessageRepository]


  override def create( admin: Admin ): Admin={
    Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession { implicit session =>

      val valo = adminrepo.insert(admin)
    }
    admin
  }

  Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession { implicit session =>

    //Creating tables
    //admin.ddl.create

    //Inserting

    //Testing for extraction
    def Read(id: String) =
      adminrepo foreach { case (count: Admin) =>
        if(count.id == id )
        {


        }
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
  }
}
