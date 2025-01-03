package solutions.s4y.guesser.viewmodels

import com.raquo.airstream.core.Signal
import com.raquo.airstream.state.Var
import solutions.s4y.guesser.domain.GuessService

import scala.concurrent.ExecutionContext.Implicits.global

class GuessViewModel(val guessService: GuessService):

  private val guessStateVar = Var[GuessState](GuessState.Initial)

  def guess(guess: Int): Unit = {
    guessStateVar.set(GuessState.Guessing)
    val future = guessService.guess(guess)
    future.onComplete {
      case scala.util.Success(true) => guessStateVar.set(GuessState.Correct)
      case scala.util.Success(false) => guessStateVar.set(GuessState.Incorrect)
      case scala.util.Failure(exception) => guessStateVar.set(GuessState.Error(exception))
    }
  }

  def guessState: Signal[GuessState] = guessStateVar.signal

object GuessViewModel:
  def apply()(using guessService: GuessService): GuessViewModel = new GuessViewModel(guessService)