def init[T](xs: List[T]): List[T] = xs match {
  case List() => throw new Error("init of empty list")
  case List(x) => List()
  case y :: ys => y :: init(ys)
}

def removeAt[T](n: Int, xs: List[T]): List[T] = xs match {
  case List() => xs
  case y :: ys => if(n==0) ys else y::removeAt(n-1, ys)
}

removeAt(-1, List('a', 'b', 'c', 'd', 'e'))


def flatten(xs: List[Any]): List[Any] = ???

flatten(List(List(1, 1), 2, List(3, List(5, 8))))