
def isPrime(n: Int): Boolean = (2 until n) forall (n%_!=0)


val n = 7

var pairs = ((1 until n) flatMap (i =>
  (1 until i) map (j => (i, j))))

pairs filter (pair => isPrime(pair._1 + pair._2))

for(pair <- pairs if isPrime(pair._1 + pair._2)) yield pair

for {
  i <- 1 until n
  j <- 1 until i
  if(isPrime(i + j))
} yield (i, j)


def scalarProduct(xs: List[Double], ys:List[Double]): Double =
  (for ( (x,y) <- xs zip ys) yield x*y).sum