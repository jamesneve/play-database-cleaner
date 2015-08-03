package com.jamesneve

import org.scalatest.{WordSpec, MustMatchers}

import slick.driver.MySQLDriver.api._

abstract class UnitSpec extends WordSpec {
	val database = Database.forURL("jdbc:mysql://localhost/arikui_test", 
                                driver="com.mysql.jdbc.Driver", 
                                user="root", 
                                password="")
}

class TestSpec extends UnitSpec with DBCleaner

class DBCleanerMysqlSpec extends WordSpec with MustMatchers {

  "DBSpec" must {
  	"not cause errors with basic tests" in {
  		true mustBe true
  	}
  }

}
