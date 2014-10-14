package controllers

import domain.people.Facilitator
import domain.stuff.Channel
import models.{FacilitatorModel, ChannelModel}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import play.api.libs.json.Json
import play.api.mvc._
import repository.ChannelRepository.ChannelRepository
import services.ChannelService
import services.crudservices.{ChannelCRUD, ChannelCRUDInterface}
import services.impl.ChannelServiceImpl



/**
 * Created by akhona on 2014/10/01.
 */
object ChannelController extends Controller{
  implicit val adminWrites = Json.writes[Channel]
  implicit val facsWrites = Json.writes[Facilitator]


     def create( chan: String, fac: String ) = Action.async(parse.json )
     {
        request =>
          val input = request.body
          val chanModel = Json.fromJson[ChannelModel](input).get
          val chanzoModel = Json.fromJson[FacilitatorModel](input).get
          val admin = chanModel.getDomain()
          val chanzo = chanzoModel.getDomain()
          val obj: ChannelCRUDInterface = new ChannelCRUD
          val res = obj.create(admin, chanzo)
          val other = admin.copy(id = chan)
          val otherz = admin.copy(id = fac)
          val results: Future[Channel] = Future{res}
          results.map(resu => Ok(Json.toJson(resu)))
     }

     def update( chan: String, id: String ) = Action.async(parse.json)
     {
       request =>
         val input = request.body
         val chanModel = Json.fromJson[ChannelModel](input).get
         val chanzoModel = Json.fromJson[FacilitatorModel](input).get
         val admin = chanModel.getDomain()
         //val chanzo = chanzoModel.getDomain()
         val obj: ChannelCRUDInterface = new ChannelCRUD
         val res = obj.update(chan, id)
         val results: Future[String] = Future{res.toString}
         results.map(result => Ok(Json.toJson(result)))
     }

    def delete(id:String) = Action{

      val obj: ChannelCRUDInterface = new ChannelCRUD
      val res = obj.delete(id)
      Ok("Deleted")
    }

    def read(id: String, name: String ) = Action
    {
      val obj: ChannelCRUDInterface = new ChannelCRUD
      //val admin = chanModel.getDomain()
      val res = obj.read(name, id)
      val json = Json.toJson(res)
      Ok(json)
    }
}

