def sum(f:Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x + y, 0)(a, b)

sum(x => x)(1, 10)
sum(x => x * x)(1, 1)
sum(x => x * x * x)(1, 5)


def product(f: Int => Int) (a: Int, b: Int): Int = mapReduce(f, (x, y) => x * y, 1)(a, b)

def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int) : Int = {
  if(a > b) zero
  else combine(f(a), mapReduce(f, combine, zero)(a+1, b))
}

product(x => x * x)(1, 1)
product(x => x * x * x)(4, 5)

def factorial(x: Int): Int = {
  if(x==0 || x==1) 1
  else product(x => x)(1, x)
}

factorial(10)
factorial(8)
