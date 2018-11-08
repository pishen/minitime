package minitime

import java.time.{ZonedDateTime => JZonedDateTime, _}
import java.time.format._

object ZonedDateTime {
  def now = JZonedDateTime.now
  def now(zone: ZoneId) = JZonedDateTime.now(zone)
  def apply(
      year: Int,
      month: Int,
      day: Int,
      hour: Int,
      minute: Int,
      second: Int = 0,
      nano: Int = 0,
      zone: ZoneId = ZoneId.systemDefault
  ) = {
    JZonedDateTime.of(year, month, day, hour, minute, second, nano, zone)
  }
  def parse(text: String) = JZonedDateTime.parse(text)
  def parse(text: String, formatter: DateTimeFormatter) = {
    JZonedDateTime.parse(text, formatter)
  }
}
