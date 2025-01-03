package solutions.s4y.guesser.domain.entities.id

trait ID

trait IDProvider:
  def next: ID

object ID:
  def apply()(using provider: IDProvider): ID = provider.next
