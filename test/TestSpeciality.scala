import org.scalatest.{GivenWhenThen, FeatureSpec}

/**
 * Created by joseph on 2014/09/03.
 */
class TestSpeciality extends FeatureSpec with GivenWhenThen
{
  feature("Create Speciality")
  {
    info("Speciality")
    scenario("create Speciality"){
      Given("Speciality")

      val channel = Speciality("1", "Doctor" ,"I help with all your physical problems", "2")

      assert( channel.specialityName == ("Doctor"))
    }
  }

}
