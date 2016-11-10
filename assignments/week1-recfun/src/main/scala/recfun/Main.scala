package recfun

object Main {
  def main(args: Array[String]) {
    pascal(5, 10)
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      def row(r: Int): Array[Int] = {
        if(r==0)
          Array(1)
        else
          nextRowOf(row(r-1))
      }

      def nextRowOf(row: Array[Int]): Array[Int] = {
        val nextRow = new Array[Int](row.length+1)
        nextRow(0)=1
        nextRow(row.length)=1
        for(i <- 1 until row.length) {
          nextRow(i) = row(i-1)+row(i)
        }
        nextRow
      }

      row(r).apply(c)
    }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    val firstIdxOfClose = chars.indexOf(')')
    if(firstIdxOfClose == -1)
      chars.indexOf('(') == -1
    else{
      val lastIdxOfOpenBeforeFirstClose = chars.lastIndexOf('(', firstIdxOfClose)
      if(lastIdxOfOpenBeforeFirstClose == -1)
        false
      else
        balance(chars.updated(firstIdxOfClose, ' ').updated(lastIdxOfOpenBeforeFirstClose, ' '))
    }
  }
  
  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if(money == 0)
      1
    else if(coins.isEmpty)
      0
    else if(money < coins.head)
      countChange(money, coins.tail)
    else
      countChange(money-coins.head, coins) + countChange(money, coins.tail)
  }
}
