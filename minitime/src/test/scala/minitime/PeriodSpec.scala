package minitime

import org.scalatest.FlatSpec

class PeriodSpec extends FlatSpec {

  behavior of "minitime.Period"

  it should "create java.time.Period" in {
    val period = Period(2019, 6, 21)
    assert(period.getYears == 2019)
    assert(period.getMonths == 6)
    assert(period.getDays == 21)
  }

  it should "parse ISO-8601 period formats' string" in {
    val period = Period.parse("P1Y2M3D")
    assert(period.getYears == 1)
    assert(period.getMonths == 2)
    assert(period.getDays == 3)
  }

}
