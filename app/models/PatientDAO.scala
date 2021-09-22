package models

import scala.language.postfixOps

import anorm._
import anorm.SqlParser.{ get, scalar }
import play.api.db.DBApi
import play.api.libs.json.Json
import play.db._

import java.text.SimpleDateFormat
import java.util.Date
import javax.inject.{Inject, Singleton}

case class Patient (
                     patient_id:Int,
                     city_id:Int,
                     patient_name:String,
                     gender:String,
                     date_birth:Date,
                     address:String,
                     city: Option[City]
                   )

@Singleton
class PatientDAO @Inject()(dbApi: DBApi, cityDAO: CityDAO) {

  import cityDAO.cityFormat
  implicit val patienFormat = Json.format[Patient]
  private val db = dbApi.database("default")

  val jumlah = 3

  val simpleWithCity: RowParser[Patient] = {
        get[Int]("patient_id") ~
        get[Int]("city_id") ~
        get[String]("patient_name") ~
        get[String]("gender") ~
        get[Date]("date_birth") ~
        get[String]("address") ~
         cityDAO.simple.? map{
          case patient_id~city_id~patient_name~gender~date_birth~address~city =>
                Patient(patient_id, city_id, patient_name, gender, date_birth, address, city)
    }
  }

  def getJumlah() = {
    val jml = (getData().length / jumlah) + (getData().length % jumlah)
    jml
  }

  def getData(): List[Patient] = {
    db.withConnection { implicit c =>
      val result : List[Patient] = SQL("SELECT p.*,c.city_name FROM patient p join city c on p.city_id = c.city_id")
        .as(simpleWithCity.*)

      result
    }
  }

  def getItemData(id:Int) = {
    db.withConnection { implicit c =>
      val result = SQL("SELECT * FROM patient WHERE patient_id =" + id)
        .as(simpleWithCity.singleOpt)

      result
    }
  }

  def pageData(page:Int): List[Patient] = {
    val awal = (page * jumlah ) - jumlah
    db.withConnection{ implicit c=>
      val result : List[Patient] = SQL(s"SELECT p.*,c.city_name FROM patient p join city c on p.city_id = c.city_id LIMIT $awal,$jumlah")
        .as(simpleWithCity.*)
      result
    }
  }

  def addData( patient: Patient) = {
    db.withConnection { implicit c =>

      val city = patient.city_id
      val nama = patient.patient_name
      val gender = patient.gender
      val date = new SimpleDateFormat("yyyy-mm-dd").format(patient.date_birth)
      val address = patient.address

      val result = SQL(s"INSERT INTO `patient`" +
        s"(`patient_name`,`city_id`, `gender`, `date_birth`, `address`) " +
        s"VALUES ('$nama','$city','$gender','$date','$address')")
        .executeUpdate()
      result
    }
  }

  def updateData( patient:Patient) = {

    db.withConnection { implicit c =>

      val id = patient.patient_id
      val city = patient.city_id
      val nama = patient.patient_name
      val gender = patient.gender
      val date = new SimpleDateFormat("yyyy-mm-dd").format(patient.date_birth)
      val address = patient.address

      val result = SQL(s"UPDATE `patient` SET " +
        s"`patient_name` = '$nama'," +
        s"`city_id` = $city, " +
        s"`gender` = '$gender', " +
        s"`date_birth` = '$date', " +
        s"`address` = '$address' " +
        s"WHERE `patient`.`patient_id` = $id")
        .executeUpdate()
      result
    }

  }

  def deleteData(id:Int): Unit = {
    db.withConnection { implicit c =>
      val result = SQL(s"DELETE FROM `patient` WHERE `patient`.`patient_id` = $id")
        .executeUpdate()
      result
    }
  }

}