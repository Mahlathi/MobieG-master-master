package services.crudservices

import domain.people.Facilitator
import domain.stuff.Conversation

/**
 * Created by alex on 2014/10/09.
 */
trait ConversationCRUDInterface {

  def create( fac: Facilitator, convo: Conversation ): Conversation
  def read(name: String, id: String)
  def update( desc: String, id: String)
  def delete(id: String)

}
