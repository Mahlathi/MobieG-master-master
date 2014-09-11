

import domain.stuff.Channel
import org.scalatest.{BeforeAndAfter, FunSuite, FeatureSpec, GivenWhenThen}
import domain.people.Facilitator
import people.Admin
import repository.AdminRepository.AdminRepository
import repository.ChannelRepository.ChannelRepository
import repository.FacilitatorRepository.FacilitatorRepository

import scala.slick.driver.MySQLDriver.simple._
import org.scalatest.{GivenWhenThen, FeatureSpec}

import scala.slick.lifted.TableQuery
import scalaz.std.list


/**
 * Created by joseph on 2014/09/03.
 */
class TestAdmin extends FeatureSpec with GivenWhenThen {
  feature("Save Care Plan") {
    info("As a Coordinator")
    info("I want to Set up Tables")
    info("So that I can Add Data into the MYSQL")

    scenario("Create Tables in the Database ") {
      Given("Given a Connection to the Database Through a Repository")

      val adminrepo = TableQuery[AdminRepository]




      Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession { implicit session =>

        //Creating tables
        //admin.ddl.create

        //Inserting
        //info("Creating Admin")
        //val admins = Admin("12")

        //val valo = adminrepo.insert(admins)

        //Testing for extraction
        def Read(id: String) =
          adminrepo foreach { case (count: Admin) =>
            info("Fail")
            if(count.id === id )
            {
              assert(count.id.contentEquals(id))
              info("Success")
            }

        }

        def Update(id: String) = {

          adminrepo.filter(_.id === id).map(_.id).update(id)
          adminrepo foreach { case (chann: Admin) =>
           if (chann.id.contentEquals(id)) {
              assert(chann.id.contentEquals(id))
           }
          }
        }


        def Delete(id: String) = {
          adminrepo.filter(_.id === id).delete
          adminrepo foreach { case (chann: Admin) =>
            if (!chann.id.contentEquals(id)) {
              assert(chann.id !== id)
              info("Checked")
            }
            else {
              info("Not checked")
            }
          }
        }

        info("Reading things")
        Read("12")
        info("Updating things")
        Update("12")
        info("Deleting things")
        Delete("6")

      }
    }

  }
}


