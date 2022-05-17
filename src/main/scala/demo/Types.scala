package demo

import Array._

object Types extends App {

  // Processing Arrays
  val list: List[Any] = List(
    "a string",
    732,  // an integer
    'c',  // a character
    true, // a boolean value
    () => "an anonymous function returning a string"
  )

  list.foreach(element => println(element))

  var myList = Array(1.9, 2.9, 3.4, 3.5)

  // Print all the array elements
  for ( x <- myList ) {
    println( x )
  }

  // Summing all elements
  var total = 0.0;

  for ( i <- 0 to (myList.length - 1)) {
    total += myList(i);
  }
  println("Total is " + total);

  // Finding the largest element
  var max = myList(0);

  for ( i <- 1 to (myList.length - 1) ) {
    if (myList(i) > max) max = myList(i);
  }

  println("Max is " + max);

  // Concatenate Arrays
  var myList1 = Array(1.9, 2.9, 3.4, 3.5)
  var myList2 = Array(8.9, 7.9, 0.4, 1.5)

  var myList3 =  concat( myList1, myList2)

  for ( x <- myList3 ) {
    println( x )
  }

  // Multi-Dimensional Arrays
  var myMatrix = ofDim[Int](3,3)

  // build a matrix
  for (i <- 0 to 2) {
    for ( j <- 0 to 2) {
      myMatrix(i)(j) = j;
    }
  }

  // Print two dimensional array
  for (i <- 0 to 2) {
    for ( j <- 0 to 2) {
      print(" " + myMatrix(i)(j));
    }
    println();
  }



  // Create Array with Range
  var myList11 = range(10, 20, 2)
  var myList22 = range(10,20)

  for ( x <- myList11 ) {
    print( " " + x )
  }

  println()
  for ( x <- myList22 ) {
    print( " " + x )
  }


  // Type Casting
  val x: Long = 987654321
  val y: Float = x  // 9.8765434E8 (note that some precision is lost in this case)
  println(y)
  val face: Char = '☺'
  val number: Int = face  // 9786
  println(number)

  val face2: Char = 9700
  val face3: Char = 9800
  for(j <- face2 to face3){
    print(j + "  ,  ")
  }
  println(face)
}
