package services.crudservices

import domain.people.Facilitator
import domain.stuff.Channel
import repository.ChannelRepository.ChannelRepository

/**
 * Created by akhona on 2014/10/07.
 */
trait ChannelCRUDInterface {

  def create( chan: Channel, fac: Facilitator ): Channel
  def read(name: String, id: String): List[ChannelRepository#TableElementType]
  def update( desc: String, id: String)
  def delete(id: String)

}
