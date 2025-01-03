package solutions.s4y.guesser.domain.entities.id

import scala.scalajs.js

class TimestampID private (val long: Long) extends ID:
  override def equals(obj: Any): Boolean =
    obj match
      case that: TimestampID => this.long == that.long
      case _ => false

  override def hashCode: Int = long.hashCode

object TimestampID:
  private var prev: Long = -1
  def apply(): TimestampID = {
    var ts = System.currentTimeMillis
    while ts == prev do
      js.timers.setTimeout(0) {}
      ts = System.currentTimeMillis
    prev = ts
    new TimestampID(ts)
  }

given TimestampIDProvider: IDProvider with
  override def next: ID = TimestampID()
