package io.chrisdavenport.http4staskexample

import cats.effect.{Effect, IO}
import fs2.StreamApp
import org.http4s.server.blaze.BlazeBuilder

import scalaz.concurrent.Task
import io.chrisdavenport.scalaz.task._

import scala.concurrent.ExecutionContext

object HelloWorldServer extends StreamApp[Task] {
  import scala.concurrent.ExecutionContext.Implicits.global

  def stream(args: List[String], requestShutdown: Task[Unit]) = ServerStream.stream[Task]
}

object ServerStream {

  def helloWorldService[F[_]: Effect] = new HelloWorldService[F].service

  def stream[F[_]: Effect](implicit ec: ExecutionContext) =
    BlazeBuilder[F]
      .bindHttp(8080, "0.0.0.0")
      .mountService(helloWorldService, "/")
      .serve
}
