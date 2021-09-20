name := """CRUD-RestAPI-Scala"""
organization := "com.hanif"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.6"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test
libraryDependencies += jdbc
libraryDependencies ++= Seq(
  "mysql" % "mysql-connector-java" % "8.0.18",
  "org.playframework.anorm" %% "anorm" % "2.6.10"
)
// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.hanif.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.hanif.binders._"
