package models

import domain.stuff.Ratings
import play.api.libs.json.Json

/**
 * Created by akhona on 2014/10/08.
 */
case class RatingsModel(id:String,rate:Int,comment:String, facilitatorId:String) {
      def geDomain(): Ratings = RatingsModel.domain(this)
}

object RatingsModel{
  implicit val ratingsfmt = Json.format[RatingsModel]

  def domain(model: RatingsModel) ={
    Ratings(model.id, model.rate, model.comment, model.facilitatorId)
  }

}
