package minitime

import java.time._

trait Multiply[A] {
  def apply(a: A, scalar: Int): A
}

object Multiply {
  def create[A](f: (A, Int) => A) = new Multiply[A] {
    override def apply(a: A, scalar: Int) = f(a, scalar)
  }

  implicit val p = create[Period](_ multipliedBy _)
  implicit val d = create[Duration](_ multipliedBy _)
}
