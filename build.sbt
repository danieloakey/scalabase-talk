val scala2Version = "2.13.3"
val projectVersion = "1.0"

lazy val root = project
  .in(file("."))
  .settings(
    scalaVersion := scala2Version,
    name := "scalabase-talk",
    organization := "ch.epfl.scala",
    version := projectVersion,
    libraryDependencies ++= Seq("org.scalameta" %% "scalameta" % "4.4.14")
  )
