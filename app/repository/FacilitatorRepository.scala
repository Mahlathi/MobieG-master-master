package repository

import people.Facilitator

import scala.slick.driver.MySQLDriver.simple._
import scala.slick.lifted.ProvenShape

/**
 * Created by joseph on 2014/09/08.
 */
object FacilitatorRepository {
    class FacilitatorRepository(tag: Tag) extends Table[(String)](tag, "Facilitator") {
        def id = column[String]("FACILITATOR_ID", O.PrimaryKey)

        //def * = (id)

      override def * : ProvenShape[(String)] = (id)
    }

  val facilitator = TableQuery[FacilitatorRepository]
}
