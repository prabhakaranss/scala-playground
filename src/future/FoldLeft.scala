package future

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import scala.language.postfixOps

object FoldLeft {
  def main(array: Array[String]): Unit = {
    val list = List(Future.successful(true), Future.successful(false), Future.successful(true))
    println (Await.result(Future.foldLeft(list)(false)(_ || _), Duration.Inf))
  }
}
