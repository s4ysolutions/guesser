# I18N

The idea is to define string interpolation prefixes `t` to denote that the string is a
subject for translation.

```scala
 println(t"Hello, world!")
```

The `t` prefix is [defined](StringContextExtensions.scala) in the `i18n` package

```scala
private trait StringContextExtensions:
  extension (sc: StringContext)
    def t(args: Any*): String
```

and currently, the [implementation](L18n.scala) is just a naive proof of concept assuming 
one language translation with a simple `Map` lookup.

```scala
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
```
