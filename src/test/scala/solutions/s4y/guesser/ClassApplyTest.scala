package solutions.s4y.guesser

class SUT(val x: String) {
  def apply(): String = "applied " + x
}

def sut(x: String) = new SUT(x)

val s: SUT = sut("sut")

class ClassApplyTest extends munit.FunSuite:
  test("ClassApplyTest") {
    val i = s()
    assertEquals(i, "applied sut")
  }
