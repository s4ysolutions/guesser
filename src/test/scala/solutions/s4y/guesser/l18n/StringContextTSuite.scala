package solutions.s4y.guesser.l18n

class StringContextTSuite extends munit.FunSuite:
  test("t"):
    val first = "John"
    val second = "Doe"
    assertEquals(t"non existing ${first}", "!!non existing {}")
    assertEquals(t"Hello, ${first + " " + second}!", "Hi, John Doe!")
    assertEquals(t"greeting", "Hello, world!")
    assertEquals(t"non existing", "!!non existing")
