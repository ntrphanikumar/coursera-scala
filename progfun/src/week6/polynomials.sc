class Poly(val terms0: Map[Int, Double]) {
  def this(bindings: (Int, Double)*) = this(bindings.toMap)

  val terms = terms0 withDefaultValue 0.0
  def + (other: Poly): Poly =  new Poly((other.terms foldLeft terms)(addTerm))
  def addTerm(terms: Map[Int, Double], term: (Int, Double)): Map[Int, Double] = {
    val (exp, coeff) = term
    terms + (exp -> (coeff + terms(exp)))
  }

  override def toString: String = (terms.toList.sorted.reverse map (_ match
  {
    case (_, 0) => ""
    case (0 ,c) => c
    case (1,c) => s"${c}x"
    case (p, c) => s"${c}x^${p}"
  })) mkString " + "
}

val p1 = new Poly(1->2,3->4,5->6.2)
val p2 = new Poly(0->3,3->7)

p1 + p2


val words = "Hello guru prema kosame ro jeevitham".split(" ")
val mnem = Map('2'->"ABC",'3'->"DEF",'4'->"GHI",'5'->"JKL", '6'->"MNO", '7'-> "PQRS",'8'->"TUV",'9'->"WXYZ")
val charCode: Map[Char, Char] = for((digit, str) <- mnem; ltr <- str) yield ltr -> digit

def wordCode(word: String): String = word.toUpperCase map charCode

wordCode("Java")

words groupBy wordCode

def encode(number: String): Set[List[String]] = {
  if(number.isEmpty) Set(List())
  else {
    for{
      split <- 1 to number.length
      word <-
    }
  }
}