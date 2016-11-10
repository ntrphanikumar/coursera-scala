1 + 2

def sqrt(x: Double) = {
  def sqrtItr(guess: Double): Double =
    if(isGoodEnough(guess)) guess
    else sqrtItr(improve(guess))

  def isGoodEnough(guess: Double) =
    abs(guess*guess - x)/x < 0.001

  def improve(guess: Double) =
    (guess + (x/guess))/2

  def abs(x: Double) = if(x<0) -x else x

  sqrtItr(1.0)
}

sqrt(2)
sqrt(25)
sqrt(1e-6)
sqrt(1e60)