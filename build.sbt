import sbtcrossproject.CrossPlugin.autoImport.{crossProject, CrossType}

name := "minitime"

ThisBuild / version := "0.3.0"
ThisBuild / scalaVersion := "2.12.9"

ThisBuild / organization := "net.pishen"
ThisBuild / licenses += "Apache-2.0" -> url("https://www.apache.org/licenses/LICENSE-2.0.html")
ThisBuild / homepage := Some(url("https://github.com/pishen/minitime"))
ThisBuild / pomExtra := (
  <scm>
    <url>https://github.com/pishen/minitime.git</url>
    <connection>scm:git:git@github.com:pishen/minitime.git</connection>
  </scm>
  <developers>
    <developer>
      <id>pishen</id>
      <name>Pishen Tsai</name>
    </developer>
  </developers>
)

publish / skip := true

lazy val minitime = crossProject(JSPlatform, JVMPlatform)
  .crossType(CrossType.Pure)
  .settings(
    name := "minitime",
    libraryDependencies += "org.scalatest" %%% "scalatest" % "3.0.8" % Test
  )
  .jsSettings(
    libraryDependencies ++= Seq(
      "io.github.cquiroz" %%% "scala-java-time" % "2.0.0-RC1"
    )
  )
