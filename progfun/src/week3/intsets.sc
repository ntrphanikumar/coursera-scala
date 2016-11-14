abstract class IntSet {
  def include(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet
}

object Empty extends IntSet {
  def contains(x: Int) = false
  def include(x:Int) = new NonEmpty(x, Empty, Empty)
  def union(other: IntSet): IntSet = other
  override def toString: String = "."
}

val set = new NonEmpty(5) include 3 include 8
val set1 = new NonEmpty(6) include 5 include 7
set union set1


class NonEmpty(ele: Int, left: IntSet = Empty, right: IntSet = Empty) extends IntSet {
  def contains(x: Int): Boolean =
    if(x<ele) left contains x
    else if (x>ele) right contains x
    else true

  def include(x: Int): IntSet =
    if(x<ele) new NonEmpty(ele, left include x, right)
    else if(x>ele) new NonEmpty(ele, left, right include x)
    else this

  override def union(other: IntSet): IntSet = ((left union right) union other) include ele

  override def toString: String = "{"+left+ele+right+"}"
}

