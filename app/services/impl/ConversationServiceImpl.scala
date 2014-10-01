package services.impl

import repository.ConversationRepository.ConversationRepository
import services.ConversationService
import scala.slick.driver.MySQLDriver.simple._
import scala.slick.lifted.TableQuery
/**
 * Created by joseph on 2014/09/24.
 */
class ConversationServiceImpl extends ConversationService
{
  val convoRepo = TableQuery[ConversationRepository]

  override def getAllConversationsOfFacilitator(facID: String): List[ConversationRepository#TableElementType] =
  {
    Database.forURL("jdbc:mysql://localhost:3306/test", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession
    {
      implicit session =>

        val convoList = convoRepo.list.filter( _.facilitatorId == facID )
        convoList
    }
  }
}
