import org.scalatest.{GivenWhenThen, FeatureSpec}

/**
 * Created by joseph on 2014/09/03.
 */
class TestRatings extends FeatureSpec with GivenWhenThen
{
  feature("Create Ratings")
  {
    info("Ratings")
    scenario("create Ratings"){
      Given("Ratings")

      val channel = Ratings("1", 1 ,"Good Good", "2")

      assert( channel.comment == ("Good Good"))
    }
  }

}