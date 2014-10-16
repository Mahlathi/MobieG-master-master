package controllerTest

import com.google.gson.Gson
import models.RoleModel
import org.junit.runner.RunWith
import org.specs2.mutable.Specification

import org.specs2.runner.JUnitRunner
import play.api.Logger
import play.api.libs.json.Json
import play.api.mvc.Controller
import play.api.test.Helpers._
import play.api.test.{FakeRequest, WithApplication}


/**
 * Created by joseph on 2014/10/09.
 */
@RunWith(classOf[JUnitRunner])
class RoleControllerTest extends Specification//extends Controller
{
    val gson = new Gson()

  "Controllers" should
    {
      "Should create Admin Object" in new WithApplication()
      {
        {
          val role = RoleModel("3462605", "some role name", "this is description things")
          val jsonstring = gson.toJson(role).stripMargin
          val json = Json.parse(jsonstring)
          val Some(result) = route(FakeRequest(
            POST, "/roleCreate/:adms ").withJsonBody(json)
          )

          status(result) must equalTo(OK)
          Logger.debug("The result of role controller is : " + result)
          contentType(result) must beSome("application/json")

        }
      }
  }

}
