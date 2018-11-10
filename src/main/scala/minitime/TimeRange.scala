package minitime

case class TimeRange[T: Ordering, S: Multiply](
    start: T,
    end: T,
    step: S,
    inclusive: Boolean
)(
    implicit add: Add[T, S]
) extends Seq[T] {
  override def apply(idx: Int): T = start + step * idx

  override def iterator: Iterator[T] = Iterator
    .tabulate(Int.MaxValue)(start + step * _)
    .takeWhile(t => if (inclusive) t <= end else t < end)

  override def length: Int = iterator.length

  override def toString = {
    val preposition = if (inclusive) "to" else "until"
    s"TimeRange $start $preposition $end by $step"
  }

  def by[P: Multiply](step: P)(implicit add: Add[T, P]): TimeRange[T, P] = {
    new TimeRange(start, end, step, inclusive)
  }
}
