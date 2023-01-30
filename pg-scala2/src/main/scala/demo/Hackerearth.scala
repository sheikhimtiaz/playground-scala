package demo

import scala.collection.convert.ImplicitConversions.`collection asJava`
import scala.collection.immutable.{ListMap, TreeSet}

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


    def kapjhap(): Unit = {
        val nums = scala.io.StdIn.readLine().split(" ").map(_.toInt)
        val n = nums(0)
        val x = nums(1)
        val inputString = scala.io.StdIn.readLine()
        var uniqueChars: Map[Char, Int] = Map.empty[Char, Int]
        for(chars <- inputString){
            uniqueChars = uniqueChars + (chars -> (uniqueChars.get(chars).getOrElse(0)+1) )
        }
        if(uniqueChars.size == x) println("0")
        else {
            println(scala.collection.immutable.ListMap(uniqueChars.toSeq.sortBy(_._2):_*))
            println(scala.collection.immutable.ListMap(uniqueChars.toSeq.sortBy(_._2):_*).take(uniqueChars.size-x))
            val ans = scala.collection.immutable.ListMap(uniqueChars.toSeq.sortBy(_._2):_*).take(uniqueChars.size-x).map(_._2).sum
            println(ans)
        }
    }


    def TandT(): Unit = {
        val queries = scala.io.StdIn.readInt()
        var db: List[String] = List()
        for(i <- 0 until queries){
            val inputLine = scala.io.StdIn.readLine().split(" ").toList
            val typeNo = inputLine(0).toInt
            val typeValue = inputLine(1)
            if(typeNo == 1) {
                db = typeValue :: db
            }
            else if(typeNo == 2 && ".".equals(typeValue)) {
                db.sorted.take(1).foreach(println)
            }
            else {
                val res = db.filter(_.startsWith(typeValue) == true)
                if(res.nonEmpty) res.take(1).foreach(println)
                else println("No word found!")
            }
        }
    }

    def longestRecurring(): Unit = {
        val givenStr = scala.io.StdIn.readLine().toList
        var uniqueChars: Set[Char] = Set()
        for(chars <- givenStr){
            uniqueChars = uniqueChars + chars
        }
        var maxLen = 0
        var currLen = 0
        uniqueChars.toList.combinations(2).toList.foreach(item => {
            givenStr.foldLeft(item(0)) { (curr: Char, accumulator) =>
                if(curr == accumulator && accumulator == item(1)) {
                    println("match 1", curr, accumulator)
                    currLen += 1
                    item(0)
                }
                else if(curr == accumulator && accumulator == item(0)) {
                    println("match 2", curr, accumulator)
                    currLen += 1
                    item(1)
                }
                else {
                    println("match 3", curr, accumulator)
                    accumulator
                }
            }
            if(currLen > maxLen) maxLen = currLen
            currLen = 0
        })
        println(maxLen)
    }

    def captainZakTheLazyProgrammer(): Unit = {
        val inputs = scala.io.StdIn.readLine().split(" ").map(_.toInt)
        val len = inputs(0)
        val k = inputs(1)
        val givenStr = scala.io.StdIn.readLine()
        println(len, k, givenStr)
    }

    def main(args: Array[String]): Unit = {
//        adjacentParity
//        kapjhap
//        TandT
//        longestRecurring
        captainZakTheLazyProgrammer
    }
}
