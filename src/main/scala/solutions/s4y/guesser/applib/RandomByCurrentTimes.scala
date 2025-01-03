package solutions.s4y.guesser.applib

import scala.concurrent.duration.{Duration, DurationInt}

class RandomByCurrentTimes extends Random:
  def nextZeroOrOne: Int = System.currentTimeMillis().toInt % 2
  def nextLatency: Duration = (System.currentTimeMillis().toInt % 1000).millis