package demo

object Arrays {
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
    myList.map(item => total = total + item)
    println("Total is " + total);

    // Finding the largest element
    var max = myList(0);

    //  for ( i <- 1 to (myList.length - 1) ) {
    //    if (myList(i) > max) max = myList(i);
    //  }

    myList.map(item => {
        if (item > max) max = item
    })

    println("Max is " + max)

    def main(args: Array[String]): Unit = {
        println("test => " + List[Int]().foreach(_*5))
        println("test => " + "aga=agag".split(";").size)

        arraysNiyeKapjhap
    }

    def arraysNiyeKapjhap(): Unit = {
        println(List(1) :+ 2)
        println(List(1) ++ List(2))
        println(1 :: List(2))
        println(1 +: List(2))
        println(List(1).appended(2))
        println(List(1).:::(List(2)))
        println(List(1).:++(List(2)))
        println("1" :: "2" :: Nil)
        println("1" + "2")
        println("1" ++ "2")
    }
}
