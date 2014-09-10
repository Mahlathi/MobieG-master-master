
import org.scalatest.{BeforeAndAfter, FunSuite, GivenWhenThen, FeatureSpec}
import people.Facilitator
import scala.slick.driver.MySQLDriver.simple._
import repository.ChannelRepository.ChannelRepository
import repository.FacilitatorRepository.FacilitatorRepository


import scala.slick.lifted.TableQuery

/**
 * Created by joseph on 2014/09/03.
 */
class TestChannel extends FunSuite with BeforeAndAfter
{

  val channel = TableQuery[ChannelRepository]
  val facilitator = TableQuery[FacilitatorRepository]

  Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession { implicit session =>

    //( channel.ddl ++ facilitator.ddl ).create


    //val chan = Channel("1", "Akhona", "I am simply the best", "2")

   // val fac = Facilitator("3")

    val other = facilitator.insert("2")
    val valo = channel.insert("1", "Akhona", "I am simply the best", "2")


  }

}
