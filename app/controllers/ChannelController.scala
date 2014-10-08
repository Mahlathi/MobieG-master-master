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


  //channelListOne = chanObj.chooseChannel("60")


  implicit val chanWrites = Json.writes[Channel]

  def listChannelOne(id: String) = Action{

    val chan = chanObj.chooseChannel(id)
    val json = Json.toJson(chan)
    Ok(json)
  }


/* def create(chan:Channel) = Action.async(parse.json)
 {
    request =>

    val input = request.body
    val feedsModel = Json.fromJson[Channel](input).get
 }*/

  def index = Action {

    Ok(views.html.index("All is well!"))

  }
}
