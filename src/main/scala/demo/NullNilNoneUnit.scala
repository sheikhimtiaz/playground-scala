package demo

object NullNilNoneUnit extends App{
  val anAbsentString: String = null
  anAbsentString.length() // triggers the famous NullPointerException
  val theNullReference: Null = null
  val noString: String = theNullReference
  case class Person()
  val noPerson: Person = theNullReference
  val noList: List[Int] = theNullReference


  val anEmptyList: List[Int] = Nil
  val emptyListLength: Int = Nil.length


  def processList(list: List[Int]): Int = list.length

  println(processList(Nil))

  val anAbsentInt: Option[Int] = None
  val aPresentInt: Option[Int] = Some(42)
//  val anAbsentValue: Option[Int] = Option(null) // this returns None

  def aUnitReturningFunction(): Unit = println("Starting to get the difference!")

  val theNothing = throw new RuntimeException("Nothing to see here")
  val nothingInt: Int = throw new RuntimeException("No int")
  val nothingString: String = throw new RuntimeException("No string")

  case class Car(make:String)

  //Initializes an instance of Car with null reference
  val nullRefCar:Car = null
  try{
    println(nullRefCar.make)
  }catch{
    case npe:NullPointerException => println("Null Pointer Error occurred: %s".format(npe))
  }

  //Initializes an instance of Car type with argument as null
  val nullMakeCar = Car(null)
  println(nullMakeCar.make)

  val myList = Nil
  println("a list is initialized with length %s".format(myList.length))
  val consList = "A" :: "B" :: Nil
  println(consList)
  val numList = 1 :: 4 :: Nil
  println(numList)

}
