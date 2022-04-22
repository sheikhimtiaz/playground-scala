package demo

object Advanced extends App{

  // lazy evaluation
  lazy val aLazyValue = 2
  lazy val lazyValueWithSideEffect = {
    println("I am so very lazy")
    43
  }
  println(lazyValueWithSideEffect)
  val eagerValue = lazyValueWithSideEffect + 1
  // useful in infinite collections

  // pseudo-collections: Option, Try

}
