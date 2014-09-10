import org.scalatest.{GivenWhenThen, FeatureSpec}

/**
 * Created by joseph on 2014/09/03.
 */
class TestSponsor extends FeatureSpec with GivenWhenThen
{
  feature("Create Sponsor")
  {
    info("Sponsor")
    scenario("create Sponsor"){
      Given("Sponsor")

      val channel = Sponsor("1", "IBM" ,"ibm.com", "We help you", "www.image.com", "2")

      assert( channel.name == ("IBM"))
    }
  }

}