package controllers

/**
 * Created by akhona on 2014/10/02.
 */


import domain.stuff.ConversationMessage
import play.api.libs.json.Json
import play.api.mvc._
import repository.ConversationMessageRepository.ConversationMessageRepository
import services.ConversationService
import services.impl.ConversationServiceImpl

object ConversationController extends Controller{

  var convoRepo: List[ConversationMessageRepository#TableElementType] = null

  val convo: ConversationService = new ConversationServiceImpl

  convoRepo = convo.getAllConversationsOfFacilitator("4", "5")

  implicit val convoWrites = Json.writes[ConversationMessage]

  def listConversation = Action{

    val json = Json.toJson(convoRepo)
    Ok(json)
  }

  def index = Action {

    Ok(views.html.index("All is well!"))

  }
}
