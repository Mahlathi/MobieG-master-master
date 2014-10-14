package models

import domain.stuff.MemberEncounter
import play.api.libs.json.Json
import repository.MemberEncountersRepository.MemberEncountersRepository

/**
 * Created by akhona on 2014/10/08.
 */
case class UserHistoryModel(id: String, startTime:String, endTime:String, facilitatorId:String, memberId:String) {
  def getDomain(): MemberEncounter = UserHistoryModel.domain(this)
}

object UserHistoryModel{
  implicit val userhistoryfmt = Json.format[UserHistoryModel]

  def domain(model: UserHistoryModel)  ={
    MemberEncounter(model.id, model.startTime, model.endTime, model.facilitatorId, model.memberId)

  }
}
