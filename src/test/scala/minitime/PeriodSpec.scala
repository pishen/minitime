package minitime

class PeriodSpec extends BaseSpec {

  "minitime.Period" should {
    "apply" in {
      val period = Period(2019, 6, 21)
      period.getYears shouldEqual 2019
      period.getMonths shouldEqual 6
      period.getDays shouldEqual 21
    }

    "parse" in {
      val period = Period.parse("P1Y2M3D")
      period.getYears shouldEqual 1
      period.getMonths shouldEqual 2
      period.getDays shouldEqual 3
    }
  }

}
