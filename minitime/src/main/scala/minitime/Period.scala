package minitime

import java.time.{Period => JPeriod}

object Period {
  def apply(years: Int, months: Int, days: Int) = {
    JPeriod.of(years, months, days)
  }
  def ofDays(days: Int) = JPeriod.ofDays(days)
  def parse(text: String) = JPeriod.parse(text)
}
