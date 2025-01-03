package solutions.s4y.guesser.l18n

private trait StringContextExtensions:
  extension (sc: StringContext)
    def t(args: Any*): String

given StringContextExtensions: StringContext with
  extension (sc: StringContext)
    def t(args: Any*): String =
      val key = if sc.parts.length == 1 then sc.parts.head else sc.parts.mkString("{}")
      L18n.translated(key) match {
        case None => "!!" + key
        case Some(translated) =>
          if (sc.parts.length == 1) translated
          else StringContext(translated.split("\\{}") *).s(args *)
      }
