package minitime

import org.scalatest.FlatSpec
import java.time.format.DateTimeFormatter

class LocalDateSpec extends FlatSpec {

  behavior of "minitime.LocalDate"

  it should "create java.time.LocalDate" in {
    val localDate = LocalDate(2020, 2, 20)

    assert(localDate.getYear == 2020)
    assert(localDate.getMonthValue == 2)
    assert(localDate.getDayOfMonth == 20)
  }

  it should "parse date string successfully" in {
    val localDate = LocalDate.parse("2020-02-20")

    assert(localDate.getYear == 2020)
    assert(localDate.getMonthValue == 2)
    assert(localDate.getDayOfMonth == 20)
  }

  it should "parse BASIC_ISO_DATE string successfully" in {
    val localDate =
      LocalDate.parse("20200220", DateTimeFormatter.BASIC_ISO_DATE)

    assert(localDate.getYear == 2020)
    assert(localDate.getMonthValue == 2)
    assert(localDate.getDayOfMonth == 20)
  }

}
