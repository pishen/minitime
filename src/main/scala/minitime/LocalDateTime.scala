package minitime

import java.time.{LocalDateTime => JLocalDateTime, _}
import java.time.format._

object LocalDateTime {
  def now = JLocalDateTime.now
  def now(zone: ZoneId) = JLocalDateTime.now(zone)
  def apply(
      year: Int,
      month: Int,
      day: Int,
      hour: Int,
      minute: Int,
      second: Int = 0,
      nano: Int = 0
  ) = {
    JLocalDateTime.of(year, month, day, hour, minute, second, nano)
  }
  def parse(text: String) = JLocalDateTime.parse(text)
  def parse(text: String, formatter: DateTimeFormatter) = {
    JLocalDateTime.parse(text, formatter)
  }
}
