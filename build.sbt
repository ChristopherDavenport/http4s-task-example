val Http4sVersion = "0.18.23"
val Specs2Version = "4.7.1"
val LogbackVersion = "1.2.3"

val ScalazTaskEffectVersion = "0.1.0"

lazy val root = (project in file("."))
  .settings(
    organization := "io.chrisdavenport",
    name := "http4s-task-example",
    version := "0.0.1-SNAPSHOT",
    scalaVersion := "2.12.6",
    libraryDependencies ++= Seq(
      "org.http4s"      %% "http4s-blaze-server" % Http4sVersion,
      "org.http4s"      %% "http4s-circe"        % Http4sVersion,
      "org.http4s"      %% "http4s-dsl"          % Http4sVersion,
      "org.specs2"     %% "specs2-core"          % Specs2Version % "test",
      "ch.qos.logback"  %  "logback-classic"     % LogbackVersion,
      "io.chrisdavenport" %%  "scalaz-task-effect" % ScalazTaskEffectVersion
    )
  )

