package models

import anorm.{Macro, RowParser, SQL}
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
                     address:String
                   )

@Singleton
class PatientDAO @Inject()(dbApi: DBApi) {

  private val db = dbApi.database("default")
  val simple: RowParser[Patient] = Macro.namedParser[Patient]

  def getData(): List[Patient] = {
    db.withConnection { implicit c =>
      val result : List[Patient] = SQL("SELECT * FROM patient")
        .as(simple.*)
      result
    }
  }

  def getItemData(id:Int) = {
    db.withConnection { implicit c =>
      val result = SQL("SELECT * FROM patient WHERE patient_id =" + id)
        .as(simple.singleOpt)

      result
    }
  }

  def pageData(page:Int): List[Patient] = {
    val jumlah = 3
    val awal = (page * jumlah ) - jumlah
    db.withConnection{ implicit c=>
      val result : List[Patient] = SQL(s"SELECT * FROM patient LIMIT $awal,$jumlah;")
        .as(simple.*)
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