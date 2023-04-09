package future

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import scala.language.postfixOps

object GroupedFutures {
  def main(array: Array[String]): Unit = {
    val map =
      Map("1" -> true, "2" -> true, "3" -> false, "4" -> false, "13" -> false)
    val groupdMap =
      map.groupBy { case (_, value) => value }.mapValues(_.keys.toList)

    val responseFuture = Future
      .sequence(
        groupdMap
          .map(y => {
            getVideo(y._2, y._1)
          })
          .toList
      )
      .map(x => x.flatten.toMap)

    println(Await.result(responseFuture, Duration.Inf))

  }

  def getVideo(
      id: List[String],
      mute: Boolean
  ): Future[Map[String, Boolean]] = {
    Future.successful(Map("a" -> true, "b" -> false))
  }

}
