package solutions.s4y.guesser.applib

import scala.concurrent.Future
import scala.concurrent.duration.Duration

trait Delayed:
  def apply[T](delay: Duration, expression: => T): Future[T]

  def apply[T](expression: => T)(using random: Random): Future[T] = apply(random.nextLatency, expression)
