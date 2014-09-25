package domain.stuff

import play.api.libs.json.Json

/**
 * Created by alex on 2014/09/02.
 */
case class Channel(id:String,
                   name:String,
                   description:String,
                   facilitatorId:String
                    )

object Channels{
    implicit lazy val channelfmt = Json.format[Channel]
}


