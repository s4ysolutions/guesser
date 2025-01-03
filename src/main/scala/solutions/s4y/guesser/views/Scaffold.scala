package solutions.s4y.guesser.views

import com.raquo.laminar.api.L.{Element, className, div}
import solutions.s4y.guesser.viewmodels.{GuessViewModel, HistoryViewModel, StatisticsViewModel, ViewModelFactory}
import solutions.s4y.guesser.views.sematics.{GuessForm, History, Statistics}

def Scaffold()(using
               ViewModelFactory[HistoryViewModel],
               ViewModelFactory[GuessViewModel],
               ViewModelFactory[StatisticsViewModel])
: Element = {
  div(className := "container mx-auto p-4 bg-white rounded-lg shadow-lg",
    div(className := "grid grid-cols-1 sm:grid-cols-2 gap-4  max-h-[80vh]",
      // left
      div(className := "flex flex-col p-4 bg-green-100 rounded",
        // right-top
        GuessForm(),
        // right-bottom
        Statistics(),
      ),
      // right
      div(className := "flex flex-col p-4 bg-blue-100 rounded inline-block",
        History()
      ),
    )
  )
}