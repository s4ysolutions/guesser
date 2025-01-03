package solutions.s4y.guesser.viewmodels

enum GuessState {
  case Initial
  case Guessing
  case Correct
  case Incorrect
  case Error(error: Throwable) // TODO: handle unchecked exceptions
}
