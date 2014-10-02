package services

import repository.ConversationMessageRepository.ConversationMessageRepository


/**
 * Created by joseph on 2014/09/24.
 */
trait ConversationService
{
  def getAllConversationsOfFacilitator(facID :String, memID :String ) : List[ConversationMessageRepository#TableElementType]

}
