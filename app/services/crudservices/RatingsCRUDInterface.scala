package services.crudservices

import domain.people.Facilitator
import domain.stuff.Ratings

/**
 * Created by alex on 2014/10/09.
 */
trait RatingsCRUDInterface {

  def create( fac: Facilitator, rat: Ratings ): Ratings
  def read(name: String, id: String)
  def update( desc: String, id: String)
  def delete(id: String)

}
