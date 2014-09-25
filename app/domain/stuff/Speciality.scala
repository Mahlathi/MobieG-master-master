package domain.stuff

import play.api.libs.json.Json

/**
 * Created by alex on 2014/09/02.
 */

case class Speciality(id:String, specialityName:String, specialityDescription:String, facilitatorId:String)

object Specialitys{
  implicit lazy val specialityfmt = Json.format[Speciality]
}
