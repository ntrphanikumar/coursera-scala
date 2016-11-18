def insertionSort(list: List[Int]): List[Int] = list match {
  case List() => list
  case List(x) => list
  case head :: tail => {
    val sortedTail = insertionSort(tail)
    if(head <= sortedTail.head) head :: sortedTail
    else sortedTail.head :: insertionSort(head :: sortedTail.tail)
  }
}

def mergeSort[T](list: List[T])(implicit ord: Ordering[T]): List[T] = {
  val n = list.length / 2
  if (n == 0) list
  else {
    def merge(xs: List[T], ys: List[T]): List[T] = (xs, ys) match {
      case (Nil, ys) => ys
      case (xs, Nil) => xs
      case (x :: xs1, y :: ys1) => if (ord.lt(x, y)) x :: merge(xs1, ys) else y :: merge(xs, ys1)
    }
    val (left, right) = list splitAt (n)
    merge(mergeSort(left), mergeSort(right))
  }
}

val numbers = List(1,5,3,8,7,9,0,-4,12,6)
insertionSort(numbers)
mergeSort(numbers)

val fruits = List("apple", "orange", "pineapple", "banana")
mergeSort(fruits)