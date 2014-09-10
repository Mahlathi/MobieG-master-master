

import org.scalatest.{BeforeAndAfter, FunSuite, FeatureSpec, GivenWhenThen}
import people.{Facilitator, Admin}
import repository.AdminRepository.AdminRepository

import scala.slick.driver.MySQLDriver.simple._
import org.scalatest.{GivenWhenThen, FeatureSpec}

import scalaz.std.list


/**
 * Created by joseph on 2014/09/03.
 */
class TestAdmin extends FeatureSpec with GivenWhenThen {

  val admin = TableQuery[AdminRepository]

  Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession { implicit session =>

   //Creating Table Admin
   // ( admin.ddl ).create


    //Testing data insertion
    feature("Testing Admin")
    {
      info("Test insert")
      scenario("Test Admin insert"){
        Given("Admin")

        //val adm = Admin("6")

        //val value = admin.insert("6");

        //assert( value == 1)
      }
    }


    //Testing for extraction
    feature("Testing Admin")
    {
      info("Testing read")
      scenario("Reading Admin"){
        Given("Admin")

        val results = admin.list

        assert(results.size == 3)
      }
    }


    //Testing for updation
    feature("Updating Admin")
    {
      info("Testing update")
      scenario("Updating Admin"){
        Given("Admin")

        val rmadd = admin.findBy(_.id)
        val adm = Admin(rmadd.toString)


        //assert(results.size == 3)
      }
    }

    //Testing for updation
    feature("Deleting Admin")
    {
      info("Testing delete")
      scenario("Deleting Admin"){
        Given("Admin")

         // val rmadd = admin.findBy(_.id)


         // admin.deleteStatement(rmadd)

        //assert(results.size == 3)
      }
    }

  }
}