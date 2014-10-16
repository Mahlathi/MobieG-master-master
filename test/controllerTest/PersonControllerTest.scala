package controllerTest

import models.crudmodels.PersonModel
import org.specs2.mutable.Specification
import com.google.gson.Gson

import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner
import play.api.Logger
import play.api.libs.json.Json
import play.api.test.Helpers._
import play.api.test.{FakeRequest, WithApplication}
/**
 * Created by joseph on 2014/10/10.
 */
@RunWith(classOf[JUnitRunner])
class PersonControllerTest extends Specification
{
  val gson = new Gson()
  "Controllers" should
  {
    "Should create Admin Object" in new WithApplication()
    {
      val person = PersonModel("366346","Mr","Joseph","Davids","","Joseph","password","email","355736","5878754","667896")
      val jsonstring = gson.toJson(person).stripMargin
      val json = Json.parse(jsonstring)
      val Some(result) = route(FakeRequest(POST,"/personCreate/:adms").withJsonBody(json))

      status(result) must equalTo(OK)
      Logger.debug("The result is" + result)
      contentType(result) must beSome("application/json")

    }
  }
}
