organization := "com.github.noahshen"

name := "vibranium"

version := "1.0"

scalaVersion := "2.11.1"


resolvers += "Nexus osc" at "http://maven.oschina.net/content/groups/public/"

libraryDependencies ++= Seq(
  "joda-time" % "joda-time" % "1.6.2",
  "com.google.guava" % "guava" % "18.0",
  "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"
)