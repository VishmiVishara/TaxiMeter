name := """ATMv2"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.3"
//gets cached libraries for faster builds. Remove in prod
updateOptions := updateOptions.value.withCachedResolution(true)

libraryDependencies += guice
libraryDependencies += javaJdbc
libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.41"
// Test Database
libraryDependencies += "com.h2database" % "h2" % "1.4.194"
libraryDependencies += evolutions
// Testing libraries for dealing with CompletionStage...
libraryDependencies += "org.assertj" % "assertj-core" % "3.6.2" % Test
libraryDependencies += "org.awaitility" % "awaitility" % "2.0.0" % Test

// Make verbose tests
testOptions in Test := Seq(Tests.Argument(TestFrameworks.JUnit, "-a", "-v"))

lazy val myProject = (project in file("."))
  .enablePlugins(PlayJava, PlayEbean)