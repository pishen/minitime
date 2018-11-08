package minitime

import java.time.{Period => JPeriod, _}

object Period {
  def apply(years: Int, months: Int, days: Int) = {
    JPeriod.of(years, months, days)
  }
  def parse(text: String) = JPeriod.parse(text)
}
