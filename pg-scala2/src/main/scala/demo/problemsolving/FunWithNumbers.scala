package demo.problemsolving

object FunWithNumbers extends App {
    class Number(var value: Int) {
        def +(other: Number): Int = {
            value += other.value; value
        }
    }

    object Number {
        private var cache = Map.empty[Int, Number]

        def make(int: Int): Number =
            cache.getOrElse(
                int, {
                    val number = new Number(int)
                    cache += (int -> number)
                    number
                }
            )
    }

    implicit def int2Number(i: Int): Number = Number.make(i)

    def println(n: Number): Unit = scala.Predef.println(n.value)

    // POP QUIZ!
    println(10 + 15)
    println(5 + 30)
    println(10 + 5)

    println(5)
    println(10)
}
