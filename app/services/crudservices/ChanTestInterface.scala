package services.crudservices

import domain.people.Facilitator
import domain.stuff.Channel

/**
 * Created by akhona on 2014/10/07.
 */
trait ChanTestInterface {
  def create( chan: Channel, fac: Facilitator )
}
