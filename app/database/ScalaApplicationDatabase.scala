package database

import anorm._

import javax.inject.Inject
import play.api.db.Database
import play.api.libs.concurrent.CustomExecutionContext

import scala.concurrent.Future

class ScalaApplicationDatabase @Inject() (db: Database, databaseExecutionContext: CustomExecutionContext) {
  def updateSomething(): Unit = {
    Future {
      db.withConnection { conn =>
        // do whatever you need with the db connection

      }
    }(databaseExecutionContext)
  }
}