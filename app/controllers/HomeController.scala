package controllers

import akka.http.scaladsl.model.DateTime
import models.{Patient, PatientDAO}
import play.api.libs.json.{JsArray, JsNull, JsNumber, JsObject, JsString, JsValue, Json, Reads}

import javax.inject._
import play.api.mvc._
import anorm._
import anorm.SqlParser.{flatten, get, int, scalar, str, to}
import play.api.db.DBApi
import database.ScalaApplicationDatabase
import play.api.db.Database
import play.api.libs.concurrent.CustomExecutionContext

import java.text.SimpleDateFormat
import java.util.Date
import scala.concurrent.Future
import scala.language.postfixOps

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(dbApi: DBApi,
                               patientDAO:PatientDAO,
                               val controllerComponents: ControllerComponents)
                    extends BaseController {

  private val db = dbApi.database("default")

  implicit val patienFormat = Json.format[Patient]
  val simple: RowParser[Patient] = Macro.namedParser[Patient]

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */

  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  def pagePatient(page:Int) = Action {
    val result = patientDAO.pageData(page)
    val json = Json.obj("patient"->result)
    Ok(json)
  }

  def getPatient() = Action {
    val result = patientDAO.getData()
    val json = Json.obj("patient" -> result)
    Ok(json)
  }

  def getItemPatient(id:Int) = Action {

    val result = patientDAO.getItemData(id)
    val json = Json.obj("name" -> result)

    Ok(json)
  }

  def addPatient() = Action {
    implicit request:Request[AnyContent] =>

      val param: JsValue = request.body.asJson.get
      val city_id:Int = (param \ "city_id").as[Int]
      val name:String = (param \ "patient_name").as[String]
      val gender:String = (param \ "gender").as[String].charAt(0).toString
      val birth:Date = new SimpleDateFormat("yyyy-mm-dd").parse((param \ "date_birth").as[String])
      val address:String = (param \ "address").as[String]

      val patient = Patient(0, city_id, name, gender, birth, address)

      val result = patientDAO.addData(patient)

      Ok(result.toString)
  }


  def updatePatient() = Action {
    implicit request:Request[AnyContent] =>

      val param: JsValue = request.body.asJson.get
      val id:Int  = (param \ "patient_id").as[Int]
      val city_id:Int = (param \ "city_id").as[Int]
      val name:String = (param \ "patient_name").as[String]
      val gender:String = (param \ "gender").as[String].charAt(0).toString
      val birth:Date = new SimpleDateFormat("yyyy-mm-dd").parse((param \ "date_birth").as[String])
      val address:String = (param \ "address").as[String]

      val patient = Patient(id, city_id, name, gender, birth, address)

      val result = patientDAO.updateData(patient)

      Ok(result.toString)
  }

  def deletePatient() = Action {
    implicit request:Request[AnyContent] =>

      val param: JsValue = request.body.asJson.get
      val id:Int  = (param \ "patient_id").as[Int]

      val result = patientDAO.deleteData(id)
      Ok(result.toString)
  }



  def returnMap = Action {
    val json: JsValue = JsObject(
      Seq(
        "name"     -> JsString("Watership Down"),
        "location" -> JsObject(Seq("lat" -> JsNumber(51.235685), "long" -> JsNumber(-1.309197))),
        "residents" -> JsArray(
          IndexedSeq(
            JsObject(
              Seq(
                "name" -> JsString("Fiver"),
                "age"  -> JsNumber(4),
                "role" -> JsNull
              )
            ),
            JsObject(
              Seq(
                "name" -> JsString("Bigwig"),
                "age"  -> JsNumber(6),
                "role" -> JsString("Owsla")
              )
            )
          )
        )
      )
    )

    Ok(json)
  }


  def listNama() = Action {

    val daftarNama = List(
      "nama 1",
      "nama 2",
      "nama 3",
      "nama 4",
      "nama 5"
    )

    val json = Json.obj("nama" -> daftarNama)
    Ok(json)
  }

}
