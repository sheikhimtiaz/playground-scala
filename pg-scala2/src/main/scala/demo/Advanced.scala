package demo

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success, Try}

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

  /**
   * pseudo-collections: Option, Try
   * @return
   */

  def methodWhichCanReturnNull(): String = "Hello, Scala"
//  if( methodWhichCanReturnNull() == null){
    // defensive code against null
//  }
  val anOption = Option(methodWhichCanReturnNull())
  // option = "collections" which contains at most one element: Some(value) or None

  val stringProcessing = anOption match{
    case Some(string) => s"I have obtaned a valid string $string"
    case None => "I obttained nothing"
  }
  // map, flatMap, filter

  def methodWhichCanThrowException(): String = throw new RuntimeException

  try{
    methodWhichCanThrowException()
  } catch {
    case e: Exception => "defend against this evil exception"
  }

  val aTry = Try(methodWhichCanThrowException())
  // a try = "collection" with either a value if the code went well, or an exceptio if the code thew one

  val anotherStringProcessing = aTry match {
    case Success(validValue) => s"I have obtained a valid value $validValue"
    case Failure(exception) => s"I have obtained exception $exception"
  }


  /**
   *  Evaluate something on another thread
   *  (asynchronous programming)
   */

  // future
  val aFuture = Future{ // Future.apply()
    println("loading... ")
    Thread.sleep(1000)
    println("I have computed a value")
    67
  }
  // Future is a "collection" which contains a value when it's evaluated
  // future is composable with map, flatMap and filter
  // monads - future try option

  Thread.sleep(2000)


  /**
   * Implicits basics
   */
  // #1: Implicits arguments
  def aMethodWithImplicitArgs(implicit args: Int) = args + 1
  implicit val myImplicitInt: Int = 46
  println(aMethodWithImplicitArgs) // aMethodWithImplicitArgs(myImplicitInt)

  //#2: Implicit conversions
  implicit class MyRichInteger(n: Int){
    def isEven() = n % 2 == 0
  }

  println(23.isEven()) // new MyRichInteger(23).isEven()
  // use this carefully 


}
