package services

import repository.ConversationRepository.ConversationRepository

/**
 * Created by joseph on 2014/09/24.
 */
trait ConversationService
{
  def getAllConversationsOfFacilitator(facID :String) : List[ConversationRepository#TableElementType]

}
