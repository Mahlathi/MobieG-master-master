package services.crudservices

import domain.stuff.Sponsor
import repository.ChannelRepository.ChannelRepository
import repository.FacilitatorRepository.FacilitatorRepository
import repository.SpecialityRepository.SpecialityRepository
import repository.SponsorRepository.SponsorRepository
import scala.slick.driver.MySQLDriver.simple._
import scala.slick.lifted.TableQuery

/**
 * Created by akhona on 2014/10/02.
 */
class SponsorCRUD {
  val channel = TableQuery[ChannelRepository]
  val spons = TableQuery[SponsorRepository]
  val fac = TableQuery[FacilitatorRepository]
  val specs = TableQuery[SpecialityRepository]

  Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession { implicit session =>

    //Creating tables
    //spons.ddl.create


    // info("Creating a Care Plan")
    //  val fecs = Facilitator("702")

    ///  val chan = Channel("602", "Mai", "Host them",fecs.id)

    /// val spo = Speciality("702", "jazee", "what it do main",fecs.id)

    // val into = Sponsor("412", "Magigolo", "hhps://www.google.com","Take the money and go", "4554",chan.id)

    // val other = fac.insert(fecs)

    /// val valo = channel.insert(chan)

    /// val vho = specs.insert(spo)

    //val nser = spons.insert(into)


    //Testing for extraction
    def Read(name: String, id: String) =
      spons foreach { case (count: Sponsor) =>

      }


    def Update( desc: String, id: String) =
    {
      spons.filter(_.id === id).map(_.message).update(desc)
      spons foreach { case ( chann: Sponsor ) =>

      }
    }

    def Delete(id: String) =
    {
      spons.filter(_.id === id).delete
      channel.filter(_.id === id).delete
      fac.filter(_.id === id).delete
      specs.filter(_.id === id).delete
      spons foreach { case (chann: Sponsor) =>

      }
    }


    Read("Take the money and go", "41")

    Update("Hotness na ngoku", "41")

    Delete("41")

  }
}
