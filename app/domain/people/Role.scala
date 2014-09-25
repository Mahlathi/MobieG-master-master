package people

import play.api.libs.json.Json

/**
 * Created by alex on 2014/09/02.
 */

case class Role(roleName:String, description:String, roleId:String)

object Roles {
  implicit lazy val rolefmt = Json.format[Role]
}
