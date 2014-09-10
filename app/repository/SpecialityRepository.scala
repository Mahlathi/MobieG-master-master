package repository

import repository.FacilitatorRepository.FacilitatorRepository

import scala.slick.driver.MySQLDriver.simple._
import scala.slick.lifted.{ProvenShape, ForeignKeyQuery}

/**
 * Created by joseph on 2014/09/08.
 */
object SpecialityRepository {

  class Speciality (tag: Tag) extends Table[(String, String, String, String)](tag, "Speciality")
  {
    def id = column[String]("SPECIALITY_ID", O.PrimaryKey)
    def name =  column[String]("SPECIALITY_NAME")
    def description = column[String]("SPECIALITY_DESCRIPTION")
    def facilitatorID = column[String]("SPECIALITY_FACILITATORID")

    def * = (id, name, description, facilitatorID)

    //override def * : ProvenShape[(String, String, String, String)] = (id, name, description, facilitatorID)

    def facilitator = foreignKey("FAC_FK", facilitatorID, TableQuery[FacilitatorRepository])(_.id)
  }

  val speciality= TableQuery[Speciality]

}
