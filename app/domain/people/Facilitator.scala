package people

import play.api.libs.json.Json

/**
 * Created by alex on 2014/09/02.
 */

case class Facilitator(id:String)

object Facilitator {
  implicit lazy val facilitatorfmt = Json.format[Facilitator]
}
