package com.jamesneve.dbcleaner

import scala.concurrent.Future
import scala.concurrent.Await
import scala.concurrent.duration.Duration

import org.scalatest._
import org.scalatestplus.play._
import play.api.test._

import slick.driver.MySQLDriver.api._

trait DBCleanerFine extends DBCleanerBase {
  override def afterEach() {
    cleanDB()
  }
}
