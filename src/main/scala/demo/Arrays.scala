package demo

object Arrays extends App {
  var z:Array[String] = new Array[String](3)

  var z1 = new Array[String](3)

  println(z1(0))

  z(0) = "Zara"
  z(1) = "Nuha"
  z(4/2) = "Ayan"

  println(z(1))

  var z3 = Array("Zara", "Nuha", "Ayan")

  var myList = Array(1.9, 2.9, 3.4, 3.5)

  // Print all the array elements
  for ( x <- myList ) {
    println( x )
  }

  myList.map(item => print(item + " - "))
  println()

  // Summing all elements
  var total = 0.0;

//  for ( i <- 0 to (myList.length - 1)) {
//    total += myList(i);
//  }
  myList.map(item => total + item)
  println("Total is " + total);

  // Finding the largest element
  var max = myList(0);

//  for ( i <- 1 to (myList.length - 1) ) {
//    if (myList(i) > max) max = myList(i);
//  }

  myList.map(item => {
    if (item > max) max = item
  })

  println("Max is " + max);
}
