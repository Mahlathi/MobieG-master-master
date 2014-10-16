package services.crudservices

import domain.people.Facilitator
import domain.stuff.Conversation
import repository.ConversationRepository.ConversationRepository

/**
 * Created by alex on 2014/10/09.
 */
trait ConversationCRUDInterface {

  def create( fac: Facilitator, convo: Conversation ): Conversation
  def read(name: String, id: String): List[ConversationRepository#TableElementType]
  def update( desc: String, id: String)
  def delete(id: String)

}
