package solutions.s4y.guesser.applib

import scala.concurrent.duration.{Duration, DurationInt}

trait Random:
  def nextZeroOrOne: Int
  def nextLatency: Duration