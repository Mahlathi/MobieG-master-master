package domain.stuff

import play.api.libs.json.Json

/**
 * Created by alex on 2014/09/02.
 */
case class Sponsor
(
  id:String,
 name:String,
 url:String,
 message:String,
 imageId:String,
 channelId:String
  )

object Sponsors{
  implicit lazy val sponsorfmt = Json.format[Sponsor]
}
