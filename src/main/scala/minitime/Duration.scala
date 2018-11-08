package minitime

import java.time.{Duration => JDuration}
import java.time.temporal.Temporal

object Duration {
  def parse(text: String) = JDuration.parse(text)
  def between(l: Temporal, r: Temporal) = JDuration.between(l, r)
}
