import sbtcrossproject.CrossPlugin.autoImport.{crossProject, CrossType}

lazy val root = crossProject(JSPlatform, JVMPlatform)
  .crossType(CrossType.Pure)
  .in(file("."))
  .settings(
    name := "minitime",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := "2.12.7",
    organization := "net.pishen"
  )
  .jsSettings(
    libraryDependencies ++= Seq(
      "io.github.cquiroz" %%% "scala-java-time" % "2.0.0-M13"
    )
  )

lazy val rootJVM = root.jvm
lazy val rootJS = root.js
