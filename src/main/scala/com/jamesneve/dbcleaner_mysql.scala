package com.jamesneve

import scala.concurrent.Future
import scala.concurrent.Await
import scala.concurrent.duration.Duration

import org.scalatest._
import org.scalatestplus.play._
import play.api.test._

import slick.driver.MySQLDriver.api._

trait DBCleaner extends Suite with BeforeAndAfterEach {
  protected val database: Database

  private def cleanDB() {
    val result = Await.result(database.run(sql"SHOW TABLES".as[(String)]), Duration.Inf)
    result.foreach { table_name =>
      if(table_name != "play_evolutions") 
        Await.result(database.run(sqlu"DELETE FROM #$table_name;"), Duration.Inf)
    }
  }

  override def beforeEach() {
    cleanDB()
  }

  override def afterEach() {
    cleanDB()
  }
}
