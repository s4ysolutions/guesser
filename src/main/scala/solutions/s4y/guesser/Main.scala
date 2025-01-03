package solutions.s4y.guesser

import com.raquo.laminar.api.L.renderOnDomContentLoaded
import org.scalajs.dom
import solutions.s4y.guesser.applib.{Delayed, DelayedWithJSPromise, Random, RandomByCurrentTimes}
import solutions.s4y.guesser.domain.GuessService
import solutions.s4y.guesser.viewmodels.{GuessViewModel, HistoryViewModel, StatisticsViewModel, ViewModelFactory}
import solutions.s4y.guesser.views.Scaffold

given Delayed = new DelayedWithJSPromise()
given Random = new RandomByCurrentTimes()
given GuessService = new GuessService()

given ViewModelFactory[StatisticsViewModel] with
  def apply(): StatisticsViewModel = StatisticsViewModel()

given ViewModelFactory[GuessViewModel] with
  def apply(): GuessViewModel = GuessViewModel()

given ViewModelFactory[HistoryViewModel] with
  def apply(): HistoryViewModel = HistoryViewModel()

@main
def Main(): Unit = {
  renderOnDomContentLoaded(
    dom.document.getElementById("app"),
    Scaffold()
  )
}
