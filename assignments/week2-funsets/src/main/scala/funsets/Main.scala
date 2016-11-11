package funsets

object Main extends App {
  import FunSets._
  val oneToTen: Set = x => Range(1, 11).contains(x)
  val fiveToFifteen: Set = x=> Range(5,16).contains(x)

  println(union(oneToTen, fiveToFifteen)(1), union(oneToTen, fiveToFifteen)(5), union(oneToTen, fiveToFifteen)(15),union(oneToTen, fiveToFifteen)(16))

  println(map(oneToTen, x=> x*2)(10))

//  println(FunSets.toString(oneToTen))
}
