package solutions.s4y.guesser.applib

import scala.concurrent.Await
import scala.concurrent.{Future, Promise}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.{Duration, DurationInt}

object DelayedWithJVMPromise:

  def post[T](delay: Duration)(expression: => T): Future[T] =
    val promise = Promise[T]()
    scala.concurrent.Future {
      Thread.sleep(delay.toMillis)
      promise.success(expression)
    }
    promise.future

class DelaydSuite extends munit.FunSuite:
  test("Expression must be evaluated after delay"):
    val delayed = DelayedWithJVMPromise
    val start = System.currentTimeMillis
    var calledAt: Long = 0;
    val future = delayed.post(500.millis){
      calledAt = System.currentTimeMillis
      42
    };
    val result = Await.result(future, 2000.millis)
    val end = System.currentTimeMillis
    assertEquals(result, 42)
    assert(calledAt - start >= 500, s"Expected at least 500 ms, but got ${calledAt - start} ms")
    assert(end - start > 500, s"Expected above 500 ms, but got ${end - start} ms")
