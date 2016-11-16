def nth[T](n: Int, list: week3.List[T]): T = {
  if(list.isEmpty) throw new IndexOutOfBoundsException
  if(n==0) list.head
  else nth(n-1, list.tail)
}

//val list = new Cons(1, new Cons(2, new Cons(3, new Nil)))
//list
//nth(1, list)

val list = new week3.Cons(1, new week3.Cons(2, new week3.Cons(3, new week3.Nil[Int])))
//nth(-1, list)
nth(0, list)
nth(1, list)
nth(2, list)
//nth(3, list)



+