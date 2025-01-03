package solutions.s4y.guesser.viewmodels

trait ViewModelFactory[T]:
  def apply(): T