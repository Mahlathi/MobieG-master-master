package controllerTest

import models.{FacilitatorModel, AdminModel}
import models.crudmodels.{MembersModel, PersonModel}
import org.specs2.mutable.Specification
import com.google.gson.Gson

import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner
import play.api.Logger
import play.api.libs.json.{JsString, JsObject, JsValue, Json}
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
    "Should create Person Object" in new WithApplication()
    {
      val roleA = AdminModel("66583218")
      val jsonstringA = gson.toJson(roleA).stripMargin

      val roleF = FacilitatorModel("99425877")
      val jsonstringF = gson.toJson(roleF).stripMargin

      val roleM = MembersModel("423900079","8878740015")
      val jsonstringM = gson.toJson(roleM).stripMargin

      val person = PersonModel("587111158","Mr","Joseph","Davids","","Joseph","password","email","66583218","99425877","423900079")
      val jsonstring = gson.toJson(person).stripMargin

      val json: JsValue = JsObject(Seq
        (
            "object" -> JsString(jsonstring),
            "admobject" -> JsString(jsonstringA),
            "facobject" -> JsString(jsonstringF),
            "memobject" -> JsString(jsonstringM)
        )
      )

      val Some(result) = route(FakeRequest(POST,"/createPerson/:Person").withJsonBody(json))

      status(result) must equalTo(OK)
      Logger.debug("The result is" + result)
      contentType(result) must beSome("application/json")

    }
  }
}
