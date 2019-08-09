package minitime

import java.time.{LocalTime => JLocalTime, _}
import java.time.format._

object LocalTime {
  def now = JLocalTime.now
  def now(zone: ZoneId) = JLocalTime.now(zone)
  def apply(hour: Int, minute: Int, second: Int = 0, nano: Int = 0) = {
    JLocalTime.of(hour, minute, second, nano)
  }
  def parse(text: String) = JLocalTime.parse(text)
  def parse(text: String, formatter: DateTimeFormatter) = {
    JLocalTime.parse(text, formatter)
  }
}
