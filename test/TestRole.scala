import org.scalatest.{GivenWhenThen, FeatureSpec}
import people.Role

/**
 * Created by joseph on 2014/09/03.
 */
class TestRole extends FeatureSpec with GivenWhenThen
{
  feature("Create Role")
  {
    info("Role")
    scenario("create Role"){
      Given("Role")

      val role = Role("Good Good", "This is the role being taken", "10111")

      assert( role.roleName == ("Good Good"))
    }
  }

}