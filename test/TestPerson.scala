import org.scalatest.{GivenWhenThen, FeatureSpec}
import people.Person

/**
 * Created by joseph on 2014/09/03.
 */
class TestPerson extends FeatureSpec with GivenWhenThen
{
  feature("Create Person")
  {
    info("There are multiple Person that the user can chat on")
    scenario("create Person"){
      Given("Person")

      val person = Person("12",
        "Jack",
        "Jack",
        "987",
        "android",
        "Akhona",
        "123",
        "ok@gmail.com",
        "123","123","123"
      )

      assert( person.firstname == ("Jack"))
    }
  }

}