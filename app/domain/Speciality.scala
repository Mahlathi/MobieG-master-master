import play.api.libs.json.Json

/**
 * Created by alex on 2014/09/02.
 */

case class Speciality(id:String, specialityName:String, specialityDescription:String, facilitatorId:String)

object Speciality{
  implicit lazy val specialityfmt = Json.format[Speciality]
}
