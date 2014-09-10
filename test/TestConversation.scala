import org.scalatest.{GivenWhenThen, FeatureSpec}

/**
 * Created by joseph on 2014/09/03.
 */
class TestConversation extends FeatureSpec with GivenWhenThen
{
  feature("Create Conversation")
  {
    info("Conversation")
    scenario("create Conversation"){
      Given("Conversation")

      val channel = Conversation("1", "Hello, please help me", "2")

      assert( channel.id == ("1"))
    }
  }

}