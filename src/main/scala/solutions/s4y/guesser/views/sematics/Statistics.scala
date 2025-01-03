package solutions.s4y.guesser.views.sematics

import com.raquo.laminar.api.L.{Element, cls, div, h3, p, text, given}
import solutions.s4y.guesser.viewmodels.{StatisticsViewModel, ViewModelFactory}
import solutions.s4y.guesser.views.widgets.PanelTitle

def Statistics()(using vmf: ViewModelFactory[StatisticsViewModel]): Element =
  val viewModel = vmf()
  val n = viewModel.notifier
  div(cls := "pt-4",
    PanelTitle("Stats"),
    p(text <-- n.startWith(()).map(
      _ => s"Total: " + viewModel.statistics.total)
    ),
    p(text <-- n.startWith(()).map(
      _ => s"Correctness: " + viewModel.statistics.correctRateString
    )),
    p(text <-- n.startWith(()).map(
      _ => s"Correct: " + viewModel.statistics.correct
    )),
    p(text <-- n.startWith(()).map(
      _ => s"Wrong: " + viewModel.statistics.incorrect
    )))
