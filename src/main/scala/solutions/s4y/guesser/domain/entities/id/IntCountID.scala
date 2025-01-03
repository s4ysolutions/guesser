package solutions.s4y.guesser.domain.entities.id

class IntCountID private(val int: Int) extends ID:
  override def equals(obj: Any): Boolean =
    obj match
      case that: IntCountID => this.int == that.int
      case _ => false

  override def hashCode: Int = int.hashCode

object IntCountID:
  private var prev: Int =0 
  def apply(): IntCountID = {
    prev = prev + 1
    new IntCountID(prev)
  }

given IntCountIDProvider: IDProvider with
  override def next: ID = IntCountID()
