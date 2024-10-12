name := "pg-scala2"

version := "0.1"

scalaVersion := "2.13.2"
lazy val akkaVersion     = "2.6.9"

//from 2.13 onwards we need the following dependency
libraryDependencies ++= Seq(
    "org.scala-lang.modules"    %% "scala-parallel-collections" % "1.0.0",
    "com.typesafe.akka"         %% "akka-actor-typed"           % akkaVersion,
    "com.typesafe.akka"         %% "akka-stream"                % akkaVersion,
    "org.scalatest"             %% "scalatest"                  % "3.2.13",
    "org.scala-lang.modules"    %% "scala-xml"                  % "2.0.1"
)

// https://mvnrepository.com/artifact/org.scala-lang/scala-xml
//libraryDependencies += "org.scala-lang" % "scala-xml" % "2.13"