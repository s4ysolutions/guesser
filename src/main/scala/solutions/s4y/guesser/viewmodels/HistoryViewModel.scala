package solutions.s4y.guesser.viewmodels

import com.raquo.airstream.core.EventStream
import solutions.s4y.guesser.domain.GuessService
import solutions.s4y.guesser.domain.entities.Guess

class HistoryViewModel(val guessService: GuessService):
  def history: Seq[Guess] = guessService.history
  val notifier: EventStream[Unit] = guessService.historyNotifier

object HistoryViewModel:
  def apply()(using guessService: GuessService): HistoryViewModel = new HistoryViewModel(guessService)
