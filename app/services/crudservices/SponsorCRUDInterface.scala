package services.crudservices

import domain.people.Facilitator
import domain.stuff.{Sponsor, Speciality, Channel}

/**
 * Created by alex on 2014/10/09.
 */
trait SponsorCRUDInterface {

  def create( facs: Facilitator, chan: Channel, spec: Speciality, spo: Sponsor ): Sponsor
  def read(name: String, id: String)
  def update( desc: String, id: String)
  def delete(id: String)
}
