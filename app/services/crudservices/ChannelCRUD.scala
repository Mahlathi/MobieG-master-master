package services.crudservices

import domain.stuff.Channel
import repository.ChannelRepository.ChannelRepository
import repository.FacilitatorRepository.FacilitatorRepository
import scala.slick.driver.MySQLDriver.simple._
import scala.slick.lifted.TableQuery

/**
 * Created by akhona on 2014/10/02.
 */
class ChannelCRUD {
  val channel = TableQuery[ChannelRepository]
  val facilitator = TableQuery[FacilitatorRepository]



  Database.forURL("jdbc:mysql://localhost:3306/mysql", driver = "com.mysql.jdbc.Driver", user = "root", password = "admin").withSession { implicit session =>

    //Creating tables
    //( channel.ddl ++ facilitator.ddl ).create



    // val chan = Channel("6", "Phumeza", "She is simply the best", "8")

    // val fac = Facilitator("8")

    //val other = facilitator.insert(fac)

    // val valo = channel.insert(chan)
    //assert(results.size == 2)

    //Testing for extraction
    def Read(name: String, id: String) =
      channel foreach { case (count: Channel) =>



      }

    def Update( desc: String, id: String) =
    {
      channel.filter(_.id === id).map(_.description).update(desc)
      channel foreach { case ( chann: Channel ) =>

      }
    }

    def Delete(id: String) =
    {
      channel.filter(_.id === id).delete
      facilitator.filter(_.id === id).delete
      channel foreach { case (chann: Channel) =>

      }
    }


    Read("Hotness sana", "1")

    Update("Hotness sana", "1")

    Delete("<function>")

  }
}

