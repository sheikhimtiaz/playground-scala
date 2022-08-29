package demo

object Hackerearth {

    def adjacentParity(): Unit = {
        val tc = scala.io.StdIn.readInt()

        for(i <- 0 until tc){
            val n = scala.io.StdIn.readInt()
            val nums: List[Int] = scala.io.StdIn.readLine.split(" ").map(_.toInt).toList.map(_ % 2)
//            println(tc, n, nums)
            var count = 0
            for(i <- nums){
                if (i == 1) count = count + 1
            }
            if(count == 0 || count == n || count == (n/2 + n%2)) println("YES")
            else println("NO")
        }
    }

    def main(args: Array[String]): Unit = {
        adjacentParity
    }
}
