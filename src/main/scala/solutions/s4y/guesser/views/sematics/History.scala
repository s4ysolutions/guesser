package solutions.s4y.guesser.views.sematics

import com.raquo.laminar.api.L.{Element, children, className, cls, div, h2, inContext, li, onMountCallback, table, tbody, td, tfoot, thead, tr, ul, given}
import solutions.s4y.guesser.domain.entities.Guess
import solutions.s4y.guesser.l18n.given
import solutions.s4y.guesser.viewmodels.{HistoryViewModel, ViewModelFactory}
import solutions.s4y.guesser.views.widgets.PanelTitle

def History()(using vmf: ViewModelFactory[HistoryViewModel]): Element =
  val viewModel = vmf()
  var containerRef: Option[org.scalajs.dom.html.Div] = None

  def scrollToBottom(): Unit = org.scalajs.dom.window.setTimeout(() => {
      containerRef match
        case Some(container) => container.scrollTop = container.scrollHeight
        case None => ()
    }, 50)

  div(cls := "flex flex-col",
    PanelTitle(t"History"),
    div(cls := "flex flex-col overflow-hidden max-h-[20em]",
      div(cls := "flex font-bold border-b",
        cell("me"),
        cell("you"),
        cell("")
      ),
      div(cls := "overflow-y-auto",
        inContext { el =>
          containerRef = Some(el.ref)
          el
        },
        children <-- viewModel.notifier.map { guesses =>
          scrollToBottom()
          viewModel.history.map { guess => guessItem(guess) }
        },
      ),
    )
  )

private def item(me: String, you: String, result: String): Element =
  div(cls := "flex border-b",
    cell(me),
    cell(you),
    cell(result))

private def guessItem(guess: Guess): Element =
  item(guess.secretNumber.toString, guess.guessNumber.toString, if (guess.isCorrect) "✔" else "❌")

private def cell(text: String): Element = div(cls := "flex-1 px-4 py-2", text)