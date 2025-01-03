package solutions.s4y.guesser.domain.entities

import solutions.s4y.guesser.domain.entities.id.{ID, IDProvider}

case class Guess(id: ID, guesser: Guesser, secretNumber: Int, guessNumber: Int) {
  def isCorrect: Boolean = secretNumber == guessNumber
}

object Guess:
  def apply(guesser: Guesser, secretNumber: Int, guess: Int)(using idProvider: IDProvider): Guess =
    new Guess(idProvider.next, guesser, secretNumber, guess)