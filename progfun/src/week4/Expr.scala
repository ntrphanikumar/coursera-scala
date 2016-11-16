package week4

/**
  * Created by phanik on 16/11/16.
  */
trait Expr {
  def show(): String = this match {
    case Number(n) => s"${n}"
    case Sum(e1, e2) => s"(${e1.show} + ${e2.show})"
    case Prod(e1, e2) => s"(${e1.show} * ${e2.show})"
    case Var(x) => s"${x}"
  }
}

case class Number(n: Int) extends Expr
case class Var(x: String) extends Expr
case class Sum(e1: Expr, e2:Expr) extends Expr
case class Prod(e1: Expr, e2: Expr) extends Expr

object Expr {
  def main(args: Array[String]): Unit = {
    println(Sum(Number(1), Sum(Number(2), Number(4))).show)
    println(Prod(Sum(Number(2), Var("x")), Var("y")).show())
  }
}
