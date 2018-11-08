package minitime

import java.time._

trait Add[L, R] {
  def apply(l: L, r: R): L
}

object Add {
  def create[L, R](f: (L, R) => L) = new Add[L, R] {
    override def apply(l: L, r: R) = f(l, r)
  }

  implicit val ldp = create[LocalDate, Period](_ plus _)
  implicit val ldtp = create[LocalDateTime, Period](_ plus _)
  implicit val ldtd = create[LocalDateTime, Duration](_ plus _)
  implicit val ltd = create[LocalTime, Duration](_ plus _)
  implicit val zdtp = create[ZonedDateTime, Period](_ plus _)
  implicit val zdtd = create[ZonedDateTime, Duration](_ plus _)
  implicit val pp = create[Period, Period](_ plus _)
  implicit val dd = create[Duration, Duration](_ plus _)
}
