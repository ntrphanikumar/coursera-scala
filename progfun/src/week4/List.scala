package week4

import week3._
/**
  * Created by phanik on 15/11/16.
  */
object List {
  def apply[T](): List[T] = Nil
  def apply[T](x1: T): List[T] = new Cons[T](x1, Nil)
  def apply[T](x1: T, x2: T): List[T] = new Cons[T](x1, new Cons[T](x2, Nil))
}
