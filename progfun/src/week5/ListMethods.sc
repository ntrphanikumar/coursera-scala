def init[T](xs: List[T]): List[T] = xs match {
  case List() => throw new Error("init of empty list")
  case List(x) => List()
  case y :: ys => y :: init(ys)
}

def removeAt[T](n: Int, xs: List[T]): List[T] = xs match {
  case List() => xs
  case y :: ys => if(n==0) ys else y::removeAt(n-1, ys)
}

//removeAt(-1, List('a', 'b', 'c', 'd', 'e'))

val numbers = List(1,5,3,8,7,9,0,-4,12,6)
val fruits = List("apple", "orange", "pineapple", "banana")

numbers filter (x => x>0)
numbers filterNot (x => x>0)
numbers partition (x=>x>0)

numbers takeWhile (x => x>0)
numbers dropWhile (x => x>0)
numbers span (x => x>0)
numbers span (x => x<1000)


def pack[T](xs: List[T]): List[List[T]] = xs match {
  case Nil => Nil
  case x :: xs1 => {
    val (p, q) = xs span (e => e == x)
    p::pack(q)
  }
}
pack(List("a", "a", "a", "b", "c", "c", "a"))

def encode[T](xs: List[T]): List[(T, Int)] =
  pack(xs) map (l => (l.head, l.length))

encode(List("a", "a", "a", "b", "c", "c", "a"))

def mapFun[T, U](xs: List[T], f: T => U): List[U] =
  (xs foldRight List[U]())( (p, q) => f(p)::q )

def lengthFun[T](xs: List[T]): Int =
  (xs foldRight 0)( (p,q)=> q+1)

lengthFun(List("a", "a", "a", "b", "c", "c", "a"))