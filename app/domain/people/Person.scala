package people

import play.api.libs.json.Json

/**
 * Created by alex on 2014/09/02.
 */
case class Person(id:String,
                  title:String,
                  firstname:String,
                  surname:String,
                  othername:String,
                  username:String,
                  password:String,
                  email:String,
                  adminId:String,
                  facilitatorId:String,
                  membersId:String
                   )

object Person{
  implicit lazy val personfmt = Json.format[Person]
}