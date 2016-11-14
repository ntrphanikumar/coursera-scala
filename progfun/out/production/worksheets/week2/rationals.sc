val x = new Rational(1,3)
val y = new Rational(5,7)
val z = new Rational(3,2)
x - y - z
y + y
x max y
new Rational(5)


class Rational(x: Int, y: Int) {
  require(y!=0, "Denominator must not be zero")

  def this(x: Int) = this(x, 1)

  private def gcd(a: Int, b: Int):Int = if(b==0) a else gcd(b, a%b)
  val numerator = x/gcd(x, y)
  val denominator = y/gcd(x, y)

  def +(that: Rational): Rational = {
    new Rational(
      numerator * that.denominator + denominator * that.numerator, denominator * that.denominator
    )
  }

  def <(that:Rational) = this.numerator * that.denominator < that.numerator * this.denominator
  def max(that:Rational) = if(this < that) that else this

  def -(that: Rational) = this + -that

  def unary_- = new Rational(-numerator, denominator)

  override def toString(): String = numerator+"/"+denominator
}