package repository

import repository.FacilitatorRepository.FacilitatorRepository

import scala.slick.driver.MySQLDriver.simple._
import scala.slick.lifted.{ProvenShape, ForeignKeyQuery}

/**
 * Created by joseph on 2014/09/08.
 */
object ChannelRepository {

  class ChannelRepository(tag:Tag) extends Table[(String, String, String, String)](tag,"Channel")
  {
    def id = column[String]("CHANNEL_ID", O.PrimaryKey)
    def name = column[String]("CHANNEL_NAME")
    def description = column[String]("CHANNEL_DESCRIPTION")
    def facilitatorID = column[String]("CHANNEL_FACILITATORID")

    //def * = (id, name, description, facilitatorID) <> ( Channe )

    override def * : ProvenShape[(String, String, String, String)] = (id, name, description, facilitatorID)

    def facilitator = foreignKey("FAC_FK", facilitatorID, TableQuery[FacilitatorRepository])(_.id)

  }

  val channel = TableQuery[ChannelRepository]

}
