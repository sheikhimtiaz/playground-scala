package demo

object ContextualAbstractions {
  /**
   * 1 - context parameters/arguments
   * @param args
   */

  val aList = List(2, 1, 3, 4)
  val anOrderedList = aList.sorted // (ordering) injected by the compiler

  // Ordering
  given descendingOrdering: Ordering[Int] = Ordering.fromLessThan(_ > _) // (a, b) => a > b
  // analogous to an implicit val

  trait Combinator[A] {  // monoid
    def combine(x: A, y:A):A
  }

  def combineAll[A](list: List[A])(using combinator: Combinator[A]): A =
//    list.reduce(combinator.combine)
    list.reduce((a,b) => combinator.combine(a,b))

  given intCombinator: Combinator[Int] = new Combinator[Int]{
    override def combine(x: Int, y: Int) = x + y
  }

  val theSum = combineAll(aList) // (intCombinator)

  // combineAll(List(1,2,3,4))

  /**
   * Given places
   * - local scope
   * - imported scope
   * - the companion of all the types involved in the call
   *    - companion of List
   *    - companion of Int
   * @param args
   */

  // context bounds
  def combinedAll_v2[A](list: List[A])(using Combinator[A]): A = ???
  def combineAll_v3[A](list: List[A]): A = ???
  def combineAll_v4[A : Combinator](list: List[A]): A = ???

  /**
   * where context args are useful
   * - type classes
   * - dependency injection
   * - context-dependant functionality
   * - type-level programming
   * @param args
   */

  /**
   * Extension Methods
   *
   * @param args
   */

  case class Person(name: String) {
    def greet(): String = s"Hi, my name is $name, I love scala!"
  }

  extension (string: String)
    def greet(): String = new Person(string).greet()

  val imtiazGreeting = "Imtiaz".greet() // "type enrichment" = pimping
  println(imtiazGreeting)

  // POWER
  extension [A](list: List[A]) {
    def combineAllValues(using combinator: Combinator[A]): A =
      list.reduce(combinator.combine)
  }

  val theSum_2 = aList.combineAllValues

  def main(args: Array[String]): Unit = {
    println(anOrderedList)
    println(theSum)
  }

}
