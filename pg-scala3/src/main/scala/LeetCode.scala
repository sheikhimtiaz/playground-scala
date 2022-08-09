import scala.util.control.Breaks.break

object LeetCode {


    def decodeString(s: String): String = {
        val (str, res) = decodeStringRecursive(s, 0)
        str
    }

    def decodeStringRecursive(input: String, start: Int): (String, Int) = {
        val result = new StringBuilder()
        var i = start
        while(i < input.length){
            input(i) match {
                case x if x>= '0' && x<='9' =>
                    val currNum = input.substring(i, input.indexOf('[', i)).toInt
                    val (str, maxI) = decodeStringRecursive(input, input.indexOf('[', i)+1)
                    i = maxI
                    result.append(str * currNum)
                case x if x >= 'a' && x <= 'z' =>
                    (result.append(x), i)
                case ']' =>
                    return (result.toString, i)
                case _ =>
            }
            i+=1
        }
        (result.toString, i)
    }

    def minCostClimbingStairs(cost: Array[Int]): Int = {
        val n = cost.length
        var first = cost(0)
        var second = cost(1)
        if (n<=2)
            first min second
        else {
            for ( i <- 2 until n) {
                val curr = cost(i) + (first min second)
                first = second
                second = curr
            }
            first min second
        }
    }

    def main(args: Array[String]): Unit = {
        val input = "3[a2[c]]xyz"
//        println(decodeString(input))


//        println(Array(1,100,1,1,1,100,1,1,100,1).sliding(2).foldLeft((0, 0)) {
//            case((a0, a1), Array(b0, b1)) =>
//                println("a0:"+a0 + " a1:" + a1 + " b0:" + b0 + " b1:" + b1)
//                (a1 min a0 + b0, a0 + b0 min a1 + b1)
//        }._2)

        println(minCostClimbingStairs(Array(1,100,1,1,1,100,1,1,100,1)))

    }

}
