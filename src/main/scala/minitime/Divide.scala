package minitime

import java.time._

trait Divide[L, R, C] {
  def apply(l: L, r: R): C
}

object Divide {
  def create[L, R, C](f: (L, R) => C) = new Divide[L, R, C] {
    override def apply(l: L, r: R): C = f(l, r)
  }

  implicit val di = create((l: Duration, r: Int) => l dividedBy r)
  // Not available in Java 8
  // implicit val dd = create((l: Duration, r: Duration) => l dividedBy r)
}
