package demo

object FunctionalProgramming extends App {

  // Scala is OO
  class Person(name: String) {
    def apply(age: Int) = println(s"I have aged $age years")
  }

  val bob = new Person("Bob")
  bob.apply(43)
  bob(43) /// INVOKING bob as a function === bob.apply(43)

  /*
    Scala runs on the JVM
    Functional programming:
    - compose functions
    - pass functions as args
    - return functions as results

    Conclusion: FunctionX = Function1, Function2, ... Function22
   */

  val simpleIncrementer = new Function1[Int, Int]{
    override def apply(v1: Int): Int = v1 + 1
  }

  simpleIncrementer.apply(43)
  simpleIncrementer(43)
  //defined a function

  // ALL SCALA FUNCTIONS ARE INSTANCES OF THESE FUNCTION_X TYPES

  //function with 2 arguments a Int return type
  val stringCounter = new Function2[String, String, Int] {
    override def apply(v1: String, v2: String): Int = v1.length + v2.length
  }

  println(stringCounter("one", "two"))
  println(stringCounter("one", ""))

  val doubler: Function1[Int, Int] = (x: Int) => 2 * x
  val doublerTwo: Int => Int = (x: Int) => 2 * x // same as doubler
  val doublerThree = (x: Int) => 2 * x // same as doublerTwo
  println(doubler(4))
  /*
  equivalent to the much longer:

  new Function1[Int, Int] {
    override def apply(x: Int) = 2 * x
  }
   */

  // Higher-order functions: take functions as args/return functions as results
  val aMappedList: List[Int] = List(1,2,3).map(x => x + 1) // HOF
  println(aMappedList)

  val aFlatMappedList = List(1,2,3).flatMap(x => List(x, 2 * x))
  val aFlatMappedListSecond = List(1,2,3).flatMap{ x =>
  List(x, 2 * x)
  } // alternative syntax. same as .map(x => List(x, 2 * x))
  println(aFlatMappedList)

  val aFilteredList = List(1,2,3,4,5).filter( x => x <= 3)
  val aFilteredListTwo = List(1,2,3,4,5).filter( _ <= 3) // equivalent to  x => x <= 3
  println(aFilteredList)

  // all pairs between 1,2,3 and the letters 'a', 'b', 'c'
  val allPairs = List(1,2,3).flatMap(number => List('a', 'b', 'c').map(letter => s"$number-$letter"))
  println(allPairs)

  // for comprehensions
  val allPairsReadableChains = for {
    number <- List(1,2,3)
    letter <- List('a', 'b', 'c')
  } yield s"$number-$letter"
  // equivalent to map/flatMap chain above

  /**
   * Collections
   */

  // Lists
  val aList = List(1,2,3)
  val firstElement = aList.head
  val rest = aList.tail
  val aPrependedList = 0 :: aList
  val anExtendedList = 0 +: aList :+ 6

  // Sequences
  val aSequences: Seq[Int] = Seq(1,2,3) // Seq.apply(1,2,3)
  println(aSequences)
  val accessedElement = aSequences.apply(1)
  println(accessedElement)

  // vectors = fast seq implementation
  val aVector = Vector(1,2,3,4,5)

  // sets = no duplicate
  val aSet = Set(1,2,3,4,1,2,3) //Set(1,2,3,4)
  val setHas5 = aSet.contains(5) // false
  val anAddedSet = aSet + 5
  val aRemovedSet = aSet - 3

  // ranges
  val aRange = 1 to 1000
  val twoByTwo = aRange.map(x => 2 * x).toList

  // Tuples = groups of values under the same value
  val aTuple = ("Bon Jovi", "Rock", 1982)

  // maps
  val aPhoneBook: Map[String, Int] = Map(
    ("Imtiaz", 45754587),
    "Sheikh"-> 54543545 // equivalent to ("Sheikh", 54543545)
  )

}
