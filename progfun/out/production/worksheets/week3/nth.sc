import week3._

def nth[T](n: Int, list: List[T]): T = {
  if(n==0) list.head
  else nth(n-1, list.tail)
}

//val list = new Cons(1, new Cons(2, new Cons(3, new Nil)))
//list
//nth(1, list)
new Cons[Int](1, new Cons[Int](2, new Cons[Int](3, new Nil[Int])))

