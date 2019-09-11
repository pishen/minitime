package minitime

import org.scalatest.FlatSpec

class SyntaxSpec extends FlatSpec {

  behavior of "minitime DSL"

  it should "plus one day to 2020/02/20" in {
    val localDate = LocalDate(2020, 2, 20)

    val addOneDay = localDate + 1.day

    assert(addOneDay == LocalDate(2020, 2, 21))
  }

  it should "subtract one day from 2020/02/20" in {
    val localDate = LocalDate(2020, 2, 20)

    val addOneDay = localDate - 1.day

    assert(addOneDay == LocalDate(2020, 2, 19))
  }

  it should "2 times of original duration" in {
    val second = 30.seconds

    val multipleTwo = second * 2

    assert(multipleTwo == 60.seconds)
  }

  it should "1/5 times of original duration" in {
    val second = 30.seconds

    val multipleTwo = second / 5

    assert(multipleTwo == 6.seconds)
  }

  it should "" in {
    val period = Period.ofDays(5)

    val tenDay = period * 2

    assert(tenDay.getDays == 10)
  }

}
