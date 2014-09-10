package repository

import repository.FacilitatorRepository.FacilitatorRepository

import scala.slick.driver.MySQLDriver.simple._
import scala.slick.lifted.{ProvenShape, ForeignKeyQuery}


/**
 * Created by joseph on 2014/09/08.
 */
object RatingRepository {
  class Rating(tag:Tag) extends Table[(String, Int, String, String)](tag,"Rating")
  {
    def id = column[String]("Rating_ID", O.PrimaryKey)
    def rate = column[Int]("Rating_Rate")
    def comment = column[String]("Rating_COMMENT")
    def facilitatorID = column[String]("Rating_FACILITATORID")

    def * = (id, rate, comment, facilitatorID)
    //override def * : ProvenShape[(String, Int, String, String)] = (id, rate, comment, facilitatorID)

    def facilitator = foreignKey("FAC_FK", facilitatorID, TableQuery[FacilitatorRepository])(_.id)
  }

  val rating = TableQuery[Rating]

}
