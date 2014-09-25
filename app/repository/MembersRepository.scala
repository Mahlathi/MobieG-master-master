package repository

import people.Members
import repository.FacilitatorRepository.FacilitatorRepository

import scala.slick.driver.MySQLDriver.simple._
import scala.slick.lifted.{ProvenShape, ForeignKeyQuery}

/**
 * Created by joseph on 2014/09/08.
 */
object MembersRepository {
    class MembersRepository(tag: Tag) extends Table[Members](tag, "Members"){
        def id = column[String]("MEMBER_ID", O.PrimaryKey)

        def facilitator_id = column[String]("FACILITATOR_ID")

        def * = (id, facilitator_id) <> (Members.tupled, Members.unapply)

      //override def * : ProvenShape[(String, String)] = (id, facilitator_id)

      def facilitator = foreignKey("FAC_FK", facilitator_id, TableQuery[FacilitatorRepository])(_.id)

    }

  val member = TableQuery[MembersRepository]

}
