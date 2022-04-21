package demo


object Basics extends App{
  val meaningOfLife: Int = 42

  val aBoolean = false;

  val aString = "I love Scala"
  val aComposedString = "Hello" + " " + "World!"
  val anInterpolatedString = s"The meaning of life is $meaningOfLife"

  //expressions = structures that can be reduced to a value
  val anExpression = 2 + 3

  //if-expression
  val ifExpression = if (meaningOfLife > 356) 56 else 999 // other lang ? :
  val chainedExpression =
    if(meaningOfLife > 4362) 35
    else if (meaningOfLife == 42) 0
    else 999

  //code blocks
  val aCodeBlock = {
    //definitions
    val aLocalValue = 73

    //value of the block is the value of the last expression
    aLocalValue + 3

  }

  //define a function

  def myFunction(x: Int, y: String): String = y + " " + x

  def largerFunc(x:Int): String = {
    "The number is " + x
  }

  //recursive functions
  def factorial(n:Int): Int =
    if (n <=1) 1
    else n * factorial(n - 1)
  println(factorial(5))
  //In Scala, we dont use loops or iteration, we use RECURSION!


  // The Unit Type = no meaningful value === "void" in other language
  // type of SIDE EFFECTS!
  println("kapjhap")


  def myUnitReturningFunction(): Unit = {
    println("I don't love returning Unit!")
  }

  val theUnit = ()


}
