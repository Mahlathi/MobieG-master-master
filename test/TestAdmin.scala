

import org.scalatest.{BeforeAndAfter, FunSuite, FeatureSpec, GivenWhenThen}
import people.Admin
import repository.AdminRepository.AdminRepository

import scala.slick.driver.MySQLDriver.simple._



/**
 * Created by joseph on 2014/09/03.
 */
class TestAdmin extends FunSuite with BeforeAndAfter
{

  val admin = TableQuery[AdminRepository]

  implicit var session: Session = _

  Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "root").withSession {
    implicit session =>



  }
}