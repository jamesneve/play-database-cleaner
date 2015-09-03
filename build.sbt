name := """database-cleaner"""

organization := "com.jamesneve"

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))

javacOptions ++= Seq("-source", "1.6", "-target", "1.6")

scalaVersion := "2.11.7"

crossScalaVersions := Seq("2.10.4", "2.11.7")

libraryDependencies ++= Seq(
	"com.typesafe.slick" %% "slick" % "3.0.0",
	"mysql" % "mysql-connector-java" % "5.1.24",
  "org.scalatest" %% "scalatest" % "2.2.1",
  "org.scalatestplus" %% "play" % "1.4.0-M3"
)

import bintray.Keys._

lazy val commonSettings = Seq(
  version := "0.0.2",
  organization := "com.jamesneve"
)

lazy val root = (project in file(".")).
  settings(commonSettings ++ bintrayPublishSettings: _*).
  settings(
    sbtPlugin := true,
    name := "Database Cleaner",
    description := "Database cleaner for Play 2.4, Scalatest and MySQL",
    licenses += ("Apache-2.0", url("https://www.apache.org/licenses/LICENSE-2.0.html")),
    publishMavenStyle := false,
    repository := "sbt-plugins",
    bintrayOrganization in bintray := None
  )

com.typesafe.sbt.SbtGit.versionWithGit
