package minitime

import java.time.{LocalDate => JLocalDate, _}
import java.time.format._

object LocalDate {
  def now = JLocalDate.now
  def now​(zone: ZoneId) = JLocalDate.now(zone)
  def apply(year: Int, month: Int, day: Int) = {
    JLocalDate.of(year, month, day)
  }
  def parse(text: String) = JLocalDate.parse(text)
  def parse(text: String, formatter: DateTimeFormatter) = {
    JLocalDate.parse(text, formatter)
  }
}
