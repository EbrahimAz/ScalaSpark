
def sqr( x: Double) = x * x
sqr(4)

def sumOfSquares( x: Double, y: Double) =sqr(x) + sqr(y)
sumOfSquares(3,4)

// call by name vs call by value
// Scala normally calls by value
// it matters:

def first(x:Int, y:Int) = x
// call by name is more efficient here as it does not need to calculate y
// exampele first(1, loop) stuckes in the loop on call by value method

// scala does call by name if if the type of function param starts with =>

def consOne(x:Int, y: => Int) = 1
// this does not work in practice though
// constOne(loop, 1+2)

def and(x:Boolean, y: => Boolean) = if (x) y else false
and(true, false)
and(true, true)
and(false, false)
//and(false, loop)

def or(x:Boolean, y:Boolean) = if (x) true else y

