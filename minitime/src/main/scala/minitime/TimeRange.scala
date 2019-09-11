package minitime

import scala.util.Try

case class TimeRange[T: Ordering, S: Multiply](
    start: T,
    end: T,
    step: S,
    inclusive: Boolean
)(
    implicit add: Add[T, S]
) extends Seq[T] {
  override def apply(idx: Int): T = {
    val res = start + step * idx
    if (idx < 0 || (inclusive && res > end) || (!inclusive && res >= end)) {
      throw new IndexOutOfBoundsException(idx.toString)
    } else {
      res
    }
  }

  override def iterator: Iterator[T] =
    Iterator
      .tabulate(Int.MaxValue)(start + step * _)
      .takeWhile(t => if (inclusive) t <= end else t < end)

  override def length: Int = iterator.length

  override def toString = {
    val content = iterator.take(15).mkString(", ")
    val more = Try(apply(15)).toOption.map(_ => ", ...").getOrElse("")
    s"TimeRange($content$more)"
  }

  def by[P: Multiply](step: P)(implicit add: Add[T, P]): TimeRange[T, P] = {
    TimeRange(start, end, step, inclusive)
  }
}
