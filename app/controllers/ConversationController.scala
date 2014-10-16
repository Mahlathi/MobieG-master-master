package controllers

/**
 * Created by akhona on 2014/10/02.
 */


import domain.people.Facilitator
import domain.stuff.{Conversation, ConversationMessage}
import models.FacilitatorModel
import models.crudmodels.ConversationModel
import play.api.libs.json.Json
import play.api.mvc._
import repository.ConversationMessageRepository.ConversationMessageRepository
import services.ConversationService
import services.crudservices.{ConversationCRUD, ConversationCRUDInterface}
import services.impl.ConversationServiceImpl
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object ConversationController extends Controller{
  implicit val convoWrites = Json.writes[Conversation]


  def create( convo: String, fac: String ) = Action.async(parse.json)
  {
    request =>
      val input = request.body
      val chanModel = Json.fromJson[ConversationModel](input).get
      val chanzoModel = Json.fromJson[FacilitatorModel](input).get
      val admin = chanModel.getDomain()
      val chanzo = chanzoModel.getDomain()
      val obj: ConversationCRUDInterface = new ConversationCRUD
      val abj: Facilitator = new Facilitator("6661")
      val res = obj.create(abj, admin)
      val other = admin.copy(id = convo)
      val otherz = chanzo.copy(id = fac)
      val results: Future[Conversation] = Future{res}
      results.map(resu => Ok(Json.toJson(resu)))
  }

  def update( chan: String, id: String  ) = Action.async(parse.json)
  {
    request =>
      val input = request.body
      val chanModel = Json.fromJson[ConversationModel](input).get
      val chanzoModel = Json.fromJson[FacilitatorModel](input).get
      val admin = chanModel.getDomain()
      val chanzo = chanzoModel.getDomain()
      val obj: ConversationCRUDInterface = new ConversationCRUD
      val res = obj.update(chan, id)

      val results: Future[String] = Future{res.toString}
      results.map(result => Ok(Json.toJson(result)))
  }

  def delete(id:String) = Action
  {
    val obj: ConversationCRUDInterface = new ConversationCRUD
    val res = obj.delete(id)
    Ok("Deleted")
  }

  def read(id: String, name: String ) = Action
  {
    val obj: ConversationCRUDInterface = new ConversationCRUD
    //val admin = chanModel.getDomain()
    val res = obj.read(name, id)
    val json = Json.toJson(res)
    Ok(json)
  }
}
