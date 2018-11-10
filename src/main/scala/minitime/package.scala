import java.time.{Duration => JDuration, Period => JPeriod, _}
import scala.concurrent.duration._
import scala.language.implicitConversions

package object minitime {
  implicit class RichInt(i: Int) {
    def hour = JDuration.ofHours(i)
    def hours = JDuration.ofHours(i)
    def minute = JDuration.ofMinutes(i)
    def minutes = JDuration.ofMinutes(i)
    def second = JDuration.ofSeconds(i)
    def seconds = JDuration.ofSeconds(i)
    def milli = JDuration.ofMillis(i)
    def millis = JDuration.ofMillis(i)
    def nano = JDuration.ofNanos(i)
    def nanos = JDuration.ofNanos(i)
    def day = JPeriod.ofDays(i)
    def days = JPeriod.ofDays(i)
    def week = JPeriod.ofWeeks(i)
    def weeks = JPeriod.ofWeeks(i)
    def month = JPeriod.ofMonths(i)
    def months = JPeriod.ofMonths(i)
    def year = JPeriod.ofYears(i)
    def years = JPeriod.ofYears(i)
  }

  implicit class RichDuration(d: JDuration) {
    def toFiniteDuration = FiniteDuration(d.toNanos, NANOSECONDS)
  }

  implicit class Infix[L](l: L) {
    def +[R](r: R)(implicit add: Add[L, R]) = add(l, r)
    def -[R, C](r: R)(implicit subtract: Subtract[L, R, C]) = subtract(l, r)
    def *(scalar: Int)(implicit multiply: Multiply[L]) = multiply(l, scalar)
    def /[R, C](r: R)(implicit divide: Divide[L, R, C]) = divide(l, r)

    def to[S](r: L)(implicit builder: TimeRangeBuilder[L, S]) = {
      builder.build(l, r, true)
    }
    def until[S](r: L)(implicit builder: TimeRangeBuilder[L, S]) = {
      builder.build(l, r, false)
    }
  }

  implicit def infixOrderingOps[T: Ordering](x: T) = {
    Ordering.Implicits.infixOrderingOps(x)
  }

  def createOrdering[T](f: (T, T) => Int) = new Ordering[T] {
    override def compare(x: T, y: T): Int = f(x, y)
  }
  implicit val ldOrdering = createOrdering[LocalDate](_ compareTo _)
  implicit val ldtOrdering = createOrdering[LocalDateTime](_ compareTo _)
  implicit val ltOrdering = createOrdering[LocalTime](_ compareTo _)
  implicit val zdtOrdering = createOrdering[ZonedDateTime](_ compareTo _)
  implicit val dOrdering = createOrdering[JDuration](_ compareTo _)
}
