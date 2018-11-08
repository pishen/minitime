package minitime

import java.time._
import java.time.temporal.ChronoUnit

trait Subtract[L, R, C] {
  def apply(l: L, r: R): C
}

object Subtract {
  def create[L, R, C](f: (L, R) => C) = new Subtract[L, R, C] {
    override def apply(l: L, r: R): C = f(l, r)
  }

  implicit val ldp = create((l: LocalDate, r: Period) => l minus r)
  implicit val ldld = create(
    (l: LocalDate, r: LocalDate) => ChronoUnit.DAYS.between(r, l)
  )
  implicit val ldtp = create((l: LocalDateTime, r: Period) => l minus r)
  implicit val ldtd = create((l: LocalDateTime, r: Duration) => l minus r)
  implicit val ldtldt = create(
    (l: LocalDateTime, r: LocalDateTime) => Duration.between(r, l)
  )
  implicit val ltd = create((l: LocalTime, r: Duration) => l minus r)
  implicit val ltlt = create(
    (l: LocalTime, r: LocalTime) => Duration.between(r, l)
  )
  implicit val zdtp = create((l: ZonedDateTime, r: Period) => l minus r)
  implicit val zdtd = create((l: ZonedDateTime, r: Duration) => l minus r)
  implicit val zdtzdt = create(
    (l: ZonedDateTime, r: ZonedDateTime) => Duration.between(r, l)
  )
  implicit val pp = create((l: Period, r: Period) => l minus r)
  implicit val dd = create((l: Duration, r: Duration) => l minus r)
}
