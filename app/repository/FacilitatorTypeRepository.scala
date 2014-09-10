package repository

import people.FacilitatorType
import repository.FacilitatorRepository.FacilitatorRepository

import scala.slick.driver.MySQLDriver.simple._
import scala.slick.lifted.{ProvenShape, ForeignKeyQuery}

/**
 * Created by joseph on 2014/09/08.
 */
object FacilitatorTypeRepository {
    class FacilitatorTypeRepository(tag: Tag) extends Table[(String, String, String, String)](tag, "FacilitatorType"){
        def id = column[String]("FACILITATORTYPE_ID", O.PrimaryKey)

        def name = column[String]("FACILITATORTYPE_NAME")

        def description = column[String]("FACILITATORTYPE_DESCRIPTION")

        def facilitator_id = column[String]("FACILITATOR_ID")

        def * = (id, name, description, facilitator_id)

        //override def * : ProvenShape[(String, String, String, String)] = (id, name, description, facilitator_id)


      def facilitator = foreignKey("FAC_FK", facilitator_id, TableQuery[FacilitatorRepository])(_.id)
    }

    val facilitatorType = TableQuery[FacilitatorTypeRepository]

}
