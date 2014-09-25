package people

import play.api.libs.json.Json

/**
 * Created by alex on 2014/09/02.
 */

case class Members(id:String, facilitatorId:String)

object Memberss{
  implicit lazy val membersfmt = Json.format[Members]
}
