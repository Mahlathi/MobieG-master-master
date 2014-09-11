package domain.stuff

import play.api.libs.json.Json

/**
 * Created by alex on 2014/09/02.
 */
case class Conversation(id:String, message:String, facilitatorId:String)

object Conversations {
  implicit lazy val conversationfmt = Json.format[Conversation]
}
