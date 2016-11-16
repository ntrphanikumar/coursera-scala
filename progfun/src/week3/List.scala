package week3

/**
  * Created by phanik on 14/11/16.
  */
trait List[+T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
  def prepend [U >: T](elem: U): List[U] = new Cons(elem, this)
}

object Nil extends  List[Nothing]{
  def isEmpty: Boolean = true
  def head: Nothing = throw new NoSuchElementException("Nil.head")
  def tail: Nothing = throw new NoSuchElementException("Nil.tail")

  override def toString: String = "."
}

class Cons[T] (val head: T, val tail: List[T]) extends List[T]{
  def isEmpty: Boolean = false

  override def toString: String = head+","+ tail
}

object List {
  def main(args: Array[String]): Unit = {
    println(Nil)
  }
}

object test {
  val x: List[String] = Nil
}