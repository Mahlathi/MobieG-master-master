package domain.stuff

import play.api.libs.json.Json

/**
 * Created by akhona on 2014/09/25.
 */
case class ConversationMessage (id:String, message:String, conversationId:String, memberId:String, facilitatorId:String)

object ConversationMessages{
  implicit lazy val conversationmessagefmt = Json.format[ConversationMessage]
}