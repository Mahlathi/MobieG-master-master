package domain.stuff

import play.api.libs.json.Json

/**
 * Created by alex on 2014/09/02.
 */

case class Ratings (id:String,rate:Int,comment:String, facilitatorId:String)

object Ratingsr{
  implicit lazy val ratingsfmt = Json.format[Ratings]
}
