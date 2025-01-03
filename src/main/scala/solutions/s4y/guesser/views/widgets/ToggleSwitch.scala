package solutions.s4y.guesser.views.widgets

import com.raquo.airstream.core.Observer
import com.raquo.airstream.state.Var
import com.raquo.laminar.api.L.{Element, Signal, checked, cls, controlled, div, forId, h3, idAttr, input, label, onClick, onMountCallback, typ, when, given}

def ToggleSwitch(id: String, reset: Signal[Unit], checkedObserver: Observer[Boolean], labelText: String = ""): Element =
  val isChecked = Var[Boolean](false)

  label(
    cls := "inline-flex items-center space-x-2",
    onMountCallback(ctx =>
      reset.foreach {
        _ => isChecked.set(false)
      }(ctx.owner)
    ),
    forId := id,
    cls := "text-gray-700 cursor-pointer",
    when(labelText.nonEmpty)(h3(labelText)),
    div(
      cls := "relative",
      input(
        typ := "checkbox",
        idAttr := id,
        cls := "sr-only peer",
        controlled(
          checked <-- isChecked.signal,
          onClick.mapToChecked --> isChecked.writer,
        ),
        onClick.mapToChecked.filter(identity) --> checkedObserver
      ),
      div(
        cls := "w-10 h-6 bg-gray-300 rounded-full transition duration-300 cursor-pointer",
        cls("peer-checked:bg-blue-600") <-- isChecked.signal,
      ),
      div(
        cls := "absolute left-0 top-0 h-6 w-6 bg-white border border-gray-300 rounded-full transition duration-300",
        cls("peer-checked:translate-x-4 peer-checked:border-blue-600") <-- isChecked.signal
      )
    )
  )