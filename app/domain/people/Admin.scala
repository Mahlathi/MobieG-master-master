package people

import play.api.libs.json.Json

/**
 * Created by alex on 2014/09/02.
 */

case class Admin(id:String)

object Admin {
  implicit lazy val adminfmt = Json.format[Admin]
}
