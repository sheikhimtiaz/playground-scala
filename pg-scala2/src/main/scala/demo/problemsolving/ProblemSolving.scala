package demo.problemsolving

object ProblemSolving extends App {

    val fibs: LazyList[Int] = 0 #:: fibs.scanLeft(1)(_ + _)
//    println(fibs take 15 toList)

    def fibonacchi(n: Int): Int = {
        var fibo = List(0, 1)
        List.range(2, n + 1).map(x =>
            fibo = fibo :+ fibo(x - 1) + fibo(x - 2)
        )
        fibo(n)
    }

    List.range(0, 11).map(x => print(fibonacchi(x) + " "))

}
