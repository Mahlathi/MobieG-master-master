package repository

import domain.stuff.MemberEncounter

import scala.slick.driver.MySQLDriver.simple._

/**
 * Created by akhona on 2014/09/23.
 */
object MemberEncountersRepository {
        class MemberEncountersRepository(tag: Tag) extends Table[MemberEncounter](tag, "MemberEncounter"){

          def id = column[String]("MEMBERENCOUNTER_ID", O.PrimaryKey)
          def startTime = column[String]("STARTTIME")
          def endTime = column[String]("ENDTIME")
          def facilitator_id = column[String]("FACILITATOR_ID")
          def members_id = column[String]("MEMBER_ID")

          def * = (id, startTime, endTime, facilitator_id, members_id) <> (MemberEncounter.tupled, MemberEncounter.unapply)
        }

  val membersEncounters = TableQuery[MemberEncountersRepository]

}
