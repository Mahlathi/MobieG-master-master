package models

import people.Members
import play.api.libs.json.Json

/**
 * Created by d on 2014/10/11.
 */
case class MemberModel(id:String, facilitatorId:String)
{
    def getDomain() : Members = MemberModel.domain(this)
}

object MemberModel
{
  implicit  val memberfmt = Json.format[MemberModel]

  def domain (model : MemberModel) =
  {
    Members(model.id , model.facilitatorId)
  }
}
