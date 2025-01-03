package solutions.s4y.guesser.viewmodels

import com.raquo.airstream.core.EventStream
import solutions.s4y.guesser.domain.GuessService
import solutions.s4y.guesser.domain.entities.Statistics

class StatisticsViewModel(val service: GuessService):
  def statistics: Statistics = service.statistic
  val notifier: EventStream[Unit] = service.historyNotifier

object StatisticsViewModel:
  def apply()(using service: GuessService): StatisticsViewModel = new StatisticsViewModel(service)
