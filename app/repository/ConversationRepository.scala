package repository

import repository.FacilitatorRepository.FacilitatorRepository

import scala.slick.driver.MySQLDriver.simple._
import scala.slick.lifted.{ProvenShape, ForeignKeyQuery}

/**
 * Created by joseph on 2014/09/08.
 */
object ConversationRepository
{
    class Conversation(tag:Tag) extends Table[(String, String, String)](tag,"Conversation")
    {
      def id = column[String]("CONVERSATION_ID", O.PrimaryKey)
      def message = column[String]("CONVERSATION_MESSAGE")
      def facilitatorID = column[String]("CONVERSATION_FACILITATORID")

      def * = (id, message, facilitatorID)

      //override def * : ProvenShape[(String, String, String)] = (id, message, facilitatorID)


      def facilitator = foreignKey("FAC_FK", facilitatorID, TableQuery[FacilitatorRepository])(_.id)
    }

  val conversation = TableQuery[Conversation]
}
