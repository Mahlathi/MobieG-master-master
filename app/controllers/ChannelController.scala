package controllers

import domain.stuff.Channel

import play.api.libs.json.Json
import play.api.mvc._
import repository.ChannelRepository.ChannelRepository
import services.ChannelService
import services.impl.ChannelServiceImpl



/**
 * Created by akhona on 2014/10/01.
 */
object ChannelController extends Controller{


  var channelListOne: List[ChannelRepository#TableElementType] = null


  val chanObj: ChannelService = new ChannelServiceImpl


  channelListOne = chanObj.chooseChannel("60")


  implicit val chanWrites = Json.writes[Channel]

  def listChannelOne = Action{

    val json = Json.toJson(channelListOne)
    Ok(json)
  }

  def index = Action {

    Ok(views.html.index("All is well!"))

  }
}
