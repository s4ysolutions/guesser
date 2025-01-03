package solutions.s4y.guesser.views.sematics

import com.raquo.airstream.state.Var
import com.raquo.laminar.api.L.{Element, Observer, br, cls, display, div, h2, h3, onMountCallback, p, given}
import solutions.s4y.guesser.viewmodels.{GuessState, GuessViewModel, ViewModelFactory}
import solutions.s4y.guesser.views.widgets.{PanelTitle, ToggleSwitch}

def GuessForm()(using vmf: ViewModelFactory[GuessViewModel]): Element =
  val viewModel = vmf()
  val reset = Var[Unit](())
  div(cls := "border-b border-gray-900/10 pb-2 sm:pb-8 relative",
    onMountCallback(ctx =>
      viewModel.guessState.foreach {
        case GuessState.Guessing => ()
        case _ => reset.set(())
      }(ctx.owner)
    ),
    PanelTitle("Click one of:"),
    p(cls := "text-gray-500 text-[80%] pb-2 sm:pb-4", "I hope I know what you think"),
    div(
    ToggleSwitch("sw0", reset.signal, Observer[Boolean]((b: Boolean) => if (b) viewModel.guess(0)), "0"),
    ),
    br(),
    div(
    ToggleSwitch("sw1", reset.signal, Observer[Boolean]((b: Boolean) => if (b) viewModel.guess(1)), "1"),
    )
  )
