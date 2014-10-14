package models

import domain.stuff.Ratings
import play.api.libs.json.Json

/**
 * Created by d on 2014/10/11.
 */
case class RatingsModel(id:String,rate:Int,comment:String, facilitatorId:String)
{
    def getDomain(): Ratings = RatingsModel.domain(this)
}

object RatingsModel
{
  implicit  val ratingFmt = Json.format[RatingsModel]

  def domain(model : RatingsModel)=
  {
    Ratings(model.id,model.rate, model.comment,model.facilitatorId)
  }
}
