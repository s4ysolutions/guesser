package solutions.s4y.guesser.domain.entities

import solutions.s4y.guesser.domain.entities.id.{ID, IDProvider}

case class Guesser(id: ID)

object Guesser:
  def apply()(using idProvider: IDProvider): Guesser = Guesser(idProvider.next)
