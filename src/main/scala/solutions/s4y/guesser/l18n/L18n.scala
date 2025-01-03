package solutions.s4y.guesser.l18n

trait L18n:
  def translated(key: String): Option[String]

object L18n extends L18n:
  private val map: Map[String, String] = Map(
    "greeting" -> "Hello, world!",
    "Hello, {}!" -> "Hi, {}!",

    "Guess" -> "Guess",
    "History" -> "History",
    "Stats" -> "Stats",
  )

  def translated(key: String): Option[String] =
    map.get(key)
