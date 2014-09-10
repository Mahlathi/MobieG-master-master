import org.scalatest.{GivenWhenThen, FeatureSpec}
import people.Members

/**
 * Created by joseph on 2014/09/03.
 */
class TestMembers extends FeatureSpec with GivenWhenThen
{
  feature("Create Members")
  {
    info("There are Members that the user can chat on")
    scenario("create Members"){
      Given("Members")

      val members = Members("12", "12")

      assert( members.facilitatorId == ("12"))
    }
  }

}