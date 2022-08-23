package demo

object Methods {

    def main(args: Array[String]): Unit = {


    }

    // POLYMORPHIC METHODS
    def listOfDuplicates[A](x: A, length: Int): List[A] = {
        if (length < 1)
            Nil
        else
            x :: listOfDuplicates(x, length - 1)
    }
    println(listOfDuplicates[Int](3, 4))  // List(3, 3, 3, 3)
    println(listOfDuplicates("La", 8))  // List(La, La, La, La, La, La, La, La)
}
