object ObjectOrientation extends App {

    //class and instance
    class Animal {
        //define fields
        val age: Int = 0

        //define methods
        def eat() = println("I am eating")
    }

    val anAnimal = new Animal

    // inheritance
    class Dog(val name: String) extends Animal // constructor definition

    val aDog = new Dog("doogey")

    println(aDog.age)
    println(aDog)
    //constructor arguments are not fields: need to put a val before the constructor argument
    // aDog.name does not exist if you don use val
    println(aDog.name)

    //subType polymorphism
    val aDeclaredAnimal: Animal = new Dog("Hachi")
    aDeclaredAnimal.eat() // the most derived method will be called at runtime

    //abstract class
    abstract class WalkingAnimal {
        protected val hasLegs = true // by default public, can restrict by using private/protected

        def walk(): Unit
    }

    // "interface"
    trait Carnivore {
        def eat(animal: Animal): Unit
    }

    trait SomeOtherTrait {
        def someFunc(): Unit
    }

    trait Philosopher {
        def ?!(thought: String): Unit // valid method name
    }

    // single-class inheritance, multiple-trait mixing
    class Crocodile extends Animal with Carnivore with SomeOtherTrait with Philosopher {
        override def eat(animal: Animal): Unit = println("Crocodile is eating")

        override def someFunc(): Unit = println("Some function is implemented!")

        override def eat(): Unit = super.eat()

        override def ?!(thought: String): Unit = println(s"I was thinking: $thought")
    }

    val aCroc = new Crocodile
    aCroc.eat(aDog)
    aCroc eat aDog // infix notation = object method argument, only available for methods with ONE argument
    aCroc ?! "what if we could fly"

    //operators in Scala are actually methods
    val basicMath = 1 + 2
    val anotherBasicMath = 1.+(2) //equivalent

    //anonymous classes
    val dinosaurs = new Carnivore {
        override def eat(animal: Animal): Unit = println("I am a dinosaur so I can eat pretty much anything")
    }
    /*
  What you tell the compiler:

  class Carnivore_Anonymous_3572B extends Carnivore {
    override def eat(animal: Animal): Unit = println("I am a dinosaur so I can eat pretty much anything")
  }
  val dinosaur = new Carnivore_Anonymous_3572B
   */

    //singleton objects
    object MySingleton { // the only instance of MySingleton type
        val mySpecialValue = 1137054

        def mySpecialMethod(): Int = 1137054

        def apply(x: Int): Int = x + 1
    }

    MySingleton.mySpecialMethod()

    MySingleton.apply(65)
    MySingleton(65) // equivalent to MySingleton.apply(65)

    object Animal { // companions - companion object , can also be applied to traits
        // companions can access each other's private fields/methods
        // singleton Animal and instances of Animal are different things
        val canLiveIndefnitely = false
    }

    val animalsCanLiveForever = Animal.canLiveIndefnitely // "static" fields/methods

    /*
  case classes = lightweight data structures with some boilerplate
  - sensible equals and hash code
  - serialization
  - companion with apply
  - pattern matching
   */
    case class Person(name: String, age: Int)

    val bob = new Person("Boc", 54)
    // can be constructed without new
    val martin = Person("Martin", 61) // equivalent to Person.apply("Martin", 61)

    // exceptions
    try {
        // code that can throw
        val x: String = null
        x.length
    } catch { // catch(Exception e) {...}
        case e: Exception => "some faulty error message"
    } finally {
        // execute some code no matter what
    }

    // generics
    abstract class MyList[T] {
        def head: T

        def tail: MyList[T]
    }

    // using a generic with a concrete type
    val aList: List[Int] = List(1, 2, 3) // List.apply(1,2,3)
    val first = aList.head // Int

    val rest = aList.tail

    val aStringsList = List("Hello", "Scala")

    var firstString = aStringsList.head // Strig

    // Point #1 : In Scala we usually operate with IMMUTABLE values/objects
    // any modification to an object must return another object
    /*
  Benefits:
  1) Works miracles in multithreaded/distributed env
  2) helps making sense of the code ("reasoning about")
   */
    val reversedList = aList.reverse // returns a NEW List

    // point #2: Scala is closest to the OO Ideal


}
