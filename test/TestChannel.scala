
import org.scalatest.{BeforeAndAfter, FunSuite, GivenWhenThen, FeatureSpec}
import people.{Admin, Facilitator}
import scala.slick.driver.MySQLDriver.simple._
import repository.ChannelRepository.ChannelRepository
import repository.FacilitatorRepository.FacilitatorRepository


import scala.slick.lifted.TableQuery

/**
 * Created by joseph on 2014/09/03.
 */
class TestChannel extends FeatureSpec with GivenWhenThen
{

  val channel = TableQuery[ChannelRepository]
  val facilitator = TableQuery[FacilitatorRepository]

  Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession { implicit session =>

    //Creating tables
    //( channel.ddl ++ facilitator.ddl ).create


    feature("Testing channel")
    {
      info("Testing insert")
      scenario("Read channel"){
        Given("channel")
          //val chan = Channel("1", "Akhona", "I am simply the best", "2")

          // val fac = Facilitator("3")

          //val other = facilitator.insert("3")
          //val valo = channel.insert("5", "Akhona", "I am simply the best", other.toString)
        //assert(results.size == 2)
      }
    }

    //Testing for extraction
    feature("Testing channel")
    {
      info("Testing read")
      scenario("Reading channel"){
        Given("channel")

        val results = channel.list
        //val otherresults = facilitator.list

        assert(results.size == 3)
        //assert(otherresults.size == 2)
      }
    }


    //Testing for updation
    feature("Updating channel")
    {
      info("Testing update")
      scenario("Updating Admin"){
        Given("Admin")


        val rmadd = channel.findBy(_.id)
        val walue = channel.insert( "" + rmadd., "Mahlathi", "used to be the best", "2")
        val results = channel.list

        assertResult( results.take(2), "Mahlathi")_
      }
    }

  }

}
