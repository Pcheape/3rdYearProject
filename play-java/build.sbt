name := """play-java"""

version := "1.0-SNAPSHOT"

lazy val myProject = (project in file("."))
  .enablePlugins(PlayJava, PlayEbean )


scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  javaJpa,
  "org.hibernate" % "hibernate-entitymanager" % "5.1.0.Final"
)

def excludeJPAPersistence(module: ModuleID): ModuleID =
  module.excludeAll(ExclusionRule("javax.persistence","persistence-api"))

libraryDependencies ~= (_.map(excludeJPAPersistence))

routesGenerator := InjectedRoutesGenerator
fork in run := true

fork in run := true