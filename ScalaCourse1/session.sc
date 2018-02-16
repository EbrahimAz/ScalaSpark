object session {
  1+2
  def abs(c: Double) = if (c<0) -c else c

  def sqrt(x: Double ) = {
    def sqrtIter(guess: Double) =
      if isGoodEnough(guess:Double) guess else
        improve(guess)
    def improve(guess:Double)= (x+  x/guess)/2
    def isGoodEnough(guess: Double)= abs(x - guess * guess)<0.001
    sqrtIter(1.0)
  }
  sqrt(4)
}