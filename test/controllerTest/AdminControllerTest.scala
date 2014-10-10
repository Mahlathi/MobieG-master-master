package controllerTest


import com.google.gson.Gson
import models.AdminModel
import org.junit.runner.RunWith
import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner
import play.api.Logger
import play.api.libs.json.Json
import play.api.test.Helpers._
import play.api.test.{FakeRequest, WithApplication}



/**
 * Created by akhona on 2014/10/07.
 */

@RunWith(classOf[JUnitRunner])
class AdminControllerTest extends Specification
{
  val gson = new Gson()

  "Controllers" should
    {
      "Should create Admin Object" in new WithApplication()
      {
        val role = AdminModel("045546")
        val jsonstring = gson.toJson(role).stripMargin
        val json = Json.parse(jsonstring)
        val Some(result) = route(FakeRequest(
          POST, "/adminCreate/:adms").withJsonBody(json)
        )
        status(result) must equalTo(OK)
        Logger.debug(" The Result is " + result)
        contentType(result) must beSome("application/json")

      }
    }

}
