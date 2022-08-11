package demo

import demo.LeetCode.maxLengthFourSublist
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

import scala.collection.mutable.PriorityQueue
import scala.util.Random

object Arrays {
    var z: Array[String] = new Array[String](3)

    var z1 = new Array[String](3)

    println(z1(0))

    z(0) = "Zara"
    z(1) = "Nuha"
    z(4 / 2) = "Ayan"

    println(z(1))

    var z3 = Array("Zara", "Nuha", "Ayan")

    var myList = Array(1.9, 2.9, 3.4, 3.5)

    // Print all the array elements
    for (x <- myList) {
        println(x)
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

    println("Max is " + max);


    println(List(1, 2, 3, 4, 5).sliding(2).toList)
    println(List(1, 2, 3, 4, 5).sliding(3).toList)
    println(List(1, 2, 3, 4, 5).sliding(3, 1).toList)
    println(List(1, 2, 3, 4, 5).sliding(3, 2).toList)
    println(List(1, 2, 3, 4, 5).sliding(3, 3).toList)
    println(List(1, 2, 3, 4, 5).sliding(3, 4).toList)
    println(List(1, 2, 3, 4, 5).grouped(3).toList)

    println(maxLengthFourSublist(List(1, 2, 3, 4, 5)))
    println(List(1, 2, 3, 10).sum)

    case class Doo(id: Int, name: String, salary: Int = 5500) extends Ordered[Doo] {
        def compare(that: Doo) = this.name compare that.name
    }

    val myDooList = List(
        Doo(4, "Howard"),
        Doo(1, "John"),
        Doo(2, "Woody"),
        Doo(3, "Allen")
    )

    def main(args: Array[String]): Unit = {
        //initialized an array with values
        var initializedArrayWithValues: List[Int] = List.fill[Int](10)(8)
        var initializedArrayWithValuesTwo: Array[Int] = new Array[Int](10)

        var initializedArrayWithValuesThree: Array[Int] = Array.fill[Int](10)(73)

        var minDisArr = Array.ofDim[Int](3,3)
//        var minDisArrTwo = Array.fill[Array[Int]](10)
//        println("minDisArrTwo  => ")
//        for(i <- 0 until minDisArrTwo.size){
//
//        }

        println("initializedArrayWithValues => ")
        println(initializedArrayWithValues)
        println(initializedArrayWithValuesTwo.toList)

        var arrayInt = new Array[Int](4)
        assert(arrayInt(0) == 0)
        assert(arrayInt.length == 4)

        var stringArray = new Array[String](3)
        assert(stringArray(1) == null)

        var stringArrayTwo = Array("This", "is", "a", "string", "array")
        assert(stringArrayTwo.length == 5)
        assert(stringArrayTwo(1) == "is")

        var randomDoubleArray = Array.fill(4) { math.random }
        assert(randomDoubleArray.length == 4)

//        Using a Collection with Splat Operator
//        We can use a predefined Collection to initialize an array. Most importantly, we can use the splat operator
//        for copying all the elements of a collection to the array:
        var list = List(1, 2, 3, 4)
        var arraySplatOperator = Array[Int](list: _*)
        assert(arraySplatOperator(1) == list(1))
        assert(arraySplatOperator.length == 4)

        var listTwo = List(1, 2, 3, 4)
        var listToArray = listTwo.toArray
        assert(listToArray.length == 4)
        assert(listToArray(3) == 4)

        val randomIntArray = Array.fill(4) { Random.nextInt(4) }

        val array = Array.range(1, 10)
        assert(array.length == 9)
        assert(array(8) == 9)

        var array2 = Array.range(0, 10, 2)
        assert(array2.length == 5)
        assert(array2(4) == 8)

        var arraytwo = Array.range(10, 0, -2)
        assert(arraytwo.length == 5)
        assert(arraytwo(4) == 2)

        var arraythree = Array.range(0, -10, -2)
        assert(arraythree.length == 5)
        assert(arraythree(4) == -8)

        // shouldBe testing
        myDooList.sorted shouldBe List(Doo(3,"Allen"), Doo(4,"Howard"), Doo(1,"John"), Doo(2,"Woody"))

        println(myDooList.sorted)
        println(myDooList.sortBy(_.name)(Ordering[String].reverse))
        println(myDooList.sortBy(_.id))
        println(myDooList.sortBy(_.id)(Ordering[Int].reverse))
        println(myDooList.sortBy(doo =>(doo.name,doo.id)))
        println(myDooList.sortWith(_.salary > _.salary))
        println(List(('b',30),('c',10),('a',20)).sortBy(_._2))
        println(List(('b',30),('c',10),('a',20)).sortBy(_._1))

        //creating the array of 2 rows and 2 columns
        val mymultiarr= Array.ofDim[Int](2, 2)

        //Assigning the values
        mymultiarr(0)(0) = 2
        mymultiarr(0)(1) = 7
        mymultiarr(1)(0) = 3
        mymultiarr(1)(1) = 4

        for(i<-0 to 1; j<-0 until 2)
        {
            print(i, j)

            //Accessing the elements
            println("=" + mymultiarr(i)(j))
        }


    }

}
