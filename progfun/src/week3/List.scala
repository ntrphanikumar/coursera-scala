package week3

/**
  * Created by phanik on 14/11/16.
  */
trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

class Nil[T] extends  List[T]{
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
    println(new Nil[Int])
  }
}