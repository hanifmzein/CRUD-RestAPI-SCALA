package models

import anorm.{Macro, RowParser}
import play.api.db.DBApi
import play.api.libs.json.Json

import javax.inject.{Inject, Singleton}

case class City (
                     city_id:Int,
                     city_name:String
                   )

@Singleton
class CityDAO @Inject()(dbApi: DBApi) {
  implicit val cityFormat = Json.format[City]
  val simple: RowParser[City] = Macro.namedParser[City]

}