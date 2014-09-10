import org.scalatest.{GivenWhenThen, FeatureSpec}
import people.FacilitatorType

/**
 * Created by joseph on 2014/09/03.
 */
class TestFacilitatorType extends FeatureSpec with GivenWhenThen
{
  feature("Create FacilitatorType")
  {
    info("FacilitatorType is the type you need bro")
    scenario("create FacilitatorType"){
      Given("FacilitatorType")

      val facilitatorType = FacilitatorType("12", "FacilitatorType","Feeling blue?","12")

      assert( facilitatorType.name == ("FacilitatorType"))
    }
  }

}