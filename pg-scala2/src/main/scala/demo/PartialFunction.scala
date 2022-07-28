package demo

object PartialFunction extends App{

  val squareRoot: PartialFunction[Double, Double] = {
    def apply(x: Double) = Math.sqrt(x)
    def isDefinedAt(x: Double) = x >= 0
    x => Math.sqrt(x)
  }

  val squareRootImplicit: PartialFunction[Double, Double] = {
    case x if x >= 0 => Math.sqrt(x)
  }

  val negativeOrZeroToPositive: PartialFunction[Int, Int] = {
    case x if x <= 0 => Math.abs(x)
  }

  val positiveToNegative: PartialFunction[Int, Int] = {
    case x if x > 0 => -1 * x
  }

  val swapSign: PartialFunction[Int, Int] = {
    positiveToNegative orElse negativeOrZeroToPositive
  }

  println(swapSign(35))

  val printIfPositive: PartialFunction[Int, Unit] = {
    case x if x > 0 => println(s"$x is positive!")
  }

  (swapSign andThen printIfPositive)(-1)

  val parseRange: PartialFunction[Int, Int] = {
    case x: Int if x > 10 => x + 1
  }
//  List(15, 3, "aString") collect { parseRange }

//  List(15, 3, "aString") map { parseRange }

  println(List(1, 2) collect { case i: Int => i > 10 })
  println(List(1, 2) filter { case i: Int => i > 10 })



}
