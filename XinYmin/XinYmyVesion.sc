println("hello world!")

println("the first program")

def x1 = 2
println(x1)

val y1 = 2
println(y1)

lazy val z1=3
println(z1)

""" Learn x in y minutes """
// basics //
println("Hello World!")
println(10)

print("hello World")
print(10)

// val is immutable
// var is mutable
val x=10
// x=20  will throw error message
var z=10
z =20
print(z)

val t: Int = 10
var s: Double = 5
1 == 2
10>7
6/4
6.0/4
6/4.0
'a'
print('a)
"hello world!".length
"hello world!".substring(2,7)
"hello world".replace("d","d!")

"hello world".take(5)
"hello world".drop(5)

val n=45
s"We have $n apples"
val a = Array(11,9,6)
s"My daughter is ${a(1)-a(2)} years old."
s" Power of 2 is: ${math.pow(2,2)}"

f"Power of 5: ${math.pow(5,2)}%1.4f"
f"Square root of 122:${math.sqrt(122)}%1.4f"

// raw string , ignore special characters//
raw"Square root of 122:${math.sqrt(122)}%1.4f"
raw"something \n something \r."

"They stood outside the \"Rose and Crown\" "
// triple double-quoting allows spaning over a few lines //
val html = """<form id="daform">
                <p>Press belo', Joe</p>
                <input type="submit">
              </form>"""
//////////////////////// 2.Functions ////////////////////////

def sumOfSquare(x:Int , y:Int): Int = {
  val x2 = x*x
  val y2 = y*y
  x2 + y2
}
print(sumOfSquare(3,4))
def sumOfSq(x:Int, y:Int): Double = {
  math.pow(x,2) + math.pow(y,2)
}
print(sumOfSq(4,6))

def subtract(x:Int, y:Int): Int = x-y

print(subtract(25,16))
var ac = subtract(25,16)
print(ac)

val addFive: Int => Int = _ + 5
print(addFive(20))

/////////////////////////////////////////////////
// 3. Flow Control
/////////////////////////////////////////////////
1 to 5
val r = 1 to 5
r.foreach(println)
r foreach println
(5 to 1 by -1) foreach println

//while loop
var i = 1
while (i<10) {println(i) ; i += 1 }

// Recursion
def showNumbersInRange( a:Int, b:Int): Unit = {
  println(a)
  if (a < b)
    showNumbersInRange(a+1, b)
}
showNumbersInRange(1,14)


// conditionals
val vv = 15
if (vv == 15) println("vv=15")
if (vv == 14) println(" vv <> 15") else println("vv==14")
println(if (vv==15) "yes" else "no")
val text = if (vv==15) "yes" else "no"

/////////////////////////////////////////////////
// 4. Data Structures
/////////////////////////////////////////////////
// Array
val aa = Array(1,2,3,4,5)
aa(0)
aa(3)

// Map
val m = Map("first" -> "1st", "second"->"2nd", "third"->"3rd")
m("first")         // java.lang.String = tenedor
m("second")        // java.lang.String = cuchara
m("third")         // Throws an exception

val safeM = m.withDefaultValue("other")
safeM("forth")

// Set
val ss = Set(5,1,3,1,5)
ss(1)             // whether 1 is in the set ss
print(ss)

val fruit = Set("apples", "oranges", "pears")
val nums: Set[Int] = Set()

println( "Head of fruit : " + fruit.head )
println( "Tail of fruit : " + fruit.tail )
println( "Check if fruit is empty : " + fruit.isEmpty )
println( "Check if nums is empty : " + nums.isEmpty )

// Tuples

(1,2)
(1, 3, "four")
val devideInts = (x:Int, y:Int) => ( x / y, x % y )
devideInts(6,4)   // gives integer part of div and the reminder (mod)
val vvv=devideInts(6,4)
vvv._1
vvv._2

val (div, mod) = devideInts(6,4)

/////////////////////////////////////////////////
// 5. Object Oriented Programming
/////////////////////////////////////////////////

class Dog(br:String){
  var breed:String = br
  def bark = "woof , woof!"
  def sleep(hours:Int) =
    println(s"I sleep for $hours hours")
}

val myDog = new Dog("greyhound")
println(myDog.breed)
println(myDog.bark)
myDog.sleep(8)

case class Person(name:String, phone:String)
var George = Person("George", "7783")
var Nike = Person("Nike", "4563")
Nike.name
Nike.phone
var otherNike = Nike.copy(name="Nike")
otherNike.phone

/////////////////////////////////////////////////
// 7. Functional Programming
/////////////////////////////////////////////////
val add10: Int => Int = _ + 10
List(1, 2, 3) map add10
List(1, 2, 3) map (x => x + 10)
List(1, 2, 3) map (_ + 10)

List("Dom", "Bob", "Natalia") foreach println

def sq( x: Int):Int = x*x
val sss = Set(1,3,5)
sss.map(sq)


val sSquared = sss. map(sq)
sSquared.filter(_ < 10)
sSquared.reduce (_+_)