package solutions.s4y.guesser.domain.entities

case class Statistics(correct: Int, incorrect: Int):
  def total: Int = correct + incorrect
  private def totalSafe: Int = if total == 0 then 1 else total
  def correctRate: Double = correct.toDouble / totalSafe
  def incorrectRate: Double = incorrect.toDouble / totalSafe
  def correctRatePercent: Int = (correctRate * 100).toInt
  def incorrectRatePercent: Int = (incorrectRate * 100).toInt
  def correctRateString: String = s"$correctRatePercent%"
  def incorrectRateString: String = s"$incorrectRatePercent%"
