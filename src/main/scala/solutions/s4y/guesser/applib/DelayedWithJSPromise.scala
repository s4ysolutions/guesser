package solutions.s4y.guesser.applib

import scala.concurrent.{Future, Promise}
import scala.concurrent.duration.Duration
import scala.scalajs.js

class DelayedWithJSPromise extends Delayed:
  def apply[T](delay: Duration, expression: => T): Future[T] =
    val promise = Promise[T]()
    js.timers.setTimeout(delay.toMillis) {
      promise.success(expression)
    }
    promise.future
