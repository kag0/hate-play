name := """petstore"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJpa,
  "org.postgresql" % "postgresql" % "9.4.1209",
  "org.hibernate" % "hibernate-core" % "5.2.2.Final",
  "black.door" % "hate" % "v1r4t0",
  "dom4j" % "dom4j" % "1.6.1"
)
