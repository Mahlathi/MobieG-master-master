package repository

import domain.stuff.ConversationMessage

import scala.slick.driver.MySQLDriver.simple._

/**
 * Created by akhona on 2014/09/25.
 */
object ConversationMessageRepository {
  class ConversationMessageRepository(tag: Tag) extends Table[ConversationMessage](tag, "ConversationMessage"){

    def id = column[String]("CONVERSATIONMESSAGE_ID", O.PrimaryKey)
    def message = column[String]("MESSAGE")
    def conversation_id = column[String]("CONVERSATION_ID")
    def members_id = column[String]("MEMBER_ID")
    def facilitator_id = column[String]("FACILITATOR_ID")


    def * = (id, message, conversation_id, members_id, facilitator_id) <> (ConversationMessage.tupled, ConversationMessage.unapply)
  }

  val conversationMessage = TableQuery[ConversationMessageRepository]
}
