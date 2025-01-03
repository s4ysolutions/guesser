package solutions.s4y.guesser.domain

import com.raquo.airstream.core.EventStream
import com.raquo.airstream.eventbus.EventBus
import solutions.s4y.guesser.applib.{Delayed, Random}
import solutions.s4y.guesser.domain.entities.{Guess, Guesser, Statistics}
import solutions.s4y.guesser.domain.entities.id.IntCountIDProvider

import scala.collection.mutable.ListBuffer
import scala.concurrent.Future

class GuessService(using delayed: Delayed, random: Random) {
  private val currentGuesser = Guesser()
  private val historyBuffer = ListBuffer[Guess]()
  /*
  private val historyBuffer = ListBuffer[Guess](
    Guess(currentGuesser, 0, 0),
    Guess(currentGuesser, 0, 0),
    Guess(currentGuesser, 0, 0),
    Guess(currentGuesser, 0, 0),
    Guess(currentGuesser, 0, 0),
    Guess(currentGuesser, 0, 0),
    Guess(currentGuesser, 0, 0),
    Guess(currentGuesser, 0, 0),
  )*/
  private val historyNotifierBus = EventBus[Unit]()

  def history: Seq[Guess] = historyBuffer.toSeq
  val historyNotifier: EventStream[Unit] = historyNotifierBus.stream
  def statistic: Statistics = Statistics(historyBuffer.count(_.isCorrect), historyBuffer.count(!_.isCorrect))

  def guess(number: Int): Future[Boolean] = {
    delayed {
      val guessed = random.nextZeroOrOne
      val guess = Guess(currentGuesser, number, guessed)
      historyBuffer.append(guess)
      historyNotifierBus.writer.onNext(())
      guess.isCorrect
    }
  }
}

object GuessService {
  inline def apply()(using delayed: Delayed)(using random: Random): GuessService = new GuessService()
}
