package demo.problemsolving

import scala.collection.mutable
import scala.collection.mutable.{Map, PriorityQueue}
import scala.util.control.Breaks.break

object LeetCode {

    def findMaxConsecutiveOnes(nums: Array[Int]): Int =
        nums.scanLeft(0)((m, x) => if (x == 0) 0 else m + 1).max


    def minCostClimbingStairs(cost: Array[Int]): Int = {
        cost.sliding(2).foldLeft((0, 0)) {
            case ((a0, a1), Array(b0, b1)) => (a1 min a0 + b0, a0 + b0 min a1 + b1)
        }._2
    }

    def decodeString(s: String): String = {
        decodeStringRecursive("1[" + s + "]", 0)
    }

    def decodeStringRecursive(input: String, start: Int): String = {
        val result = new StringBuilder()
        val dropStart = start
        for (i <- start until input.length) {
            val char = input(i)
            println("char => " + char)
            char match {
                case char if (char >= '0' && char <= '9') =>
                    val currNum = input.substring(i, input.indexOf('[', i)).toInt
                    result.append(decodeStringRecursive(input, input.indexOf('[', i) + 1) * currNum)
                case char if (char >= 'a' && char <= 'z') =>
                    result.append(char)
                case char if char == ']' =>
                    return result.toString()
                case _ =>
            }
        }
        result.toString
    }

    def maxLengthFourSublist(list: List[Int]): List[Int] = {
        list.sliding(4, 1).maxBy(_.sum)
    }

    def maxEnvelopes(envelopes: Array[Array[Int]]): Int = {
        envelopes.sortWith((a1, b1) => if (a1(0) == b1(0)) a1(1) > b1(1) else a1(0) < b1(0))
            .map(_ (1)).foldLeft(List[Int]()) { (acc, item) =>
            if (acc.isEmpty || item > acc.last) acc :+ item
            else {
                var res = acc.take(lower_bound(acc, acc.size, item))
                res = res :+ item
                res = res ++ acc.drop(lower_bound(acc, acc.size, item) + 1)
                res
            }
        }.size
    }

    // Function to implement lower_bound
    private def lower_bound(arr: List[Int], N: Int, X: Int): Int = {
        var low = 0
        var high = N
        var mid = low + (high - low) / 2;
        while (low < high) {
            mid = low + (high - low) / 2
            if (X <= arr(mid)) high = mid
            else low = mid + 1
        }
        if (low < N && arr(low) < X) low += 1
        low
    }

    def coinChange(coins: Array[Int], amount: Int): Int = {
        //        var dp: Array[Int] = new Array[Int](amount+5)
        var dp: Array[Int] = Array.fill[Int](amount + 5)(amount + 1)
        dp(0) = 0
        for (i <- 1 to amount) {
            for (j <- 0 until coins.size) {
                if (coins(j) <= i) {
                    dp(i) = dp(i) min (dp(i - coins(j)) + 1)
                }
            }
        }
        if (dp(amount) > amount) -1 else dp(amount);
    }

    def minDistance(word1: String, word2: String): Int = {
        //        var array2d: Array[Array[Int]] =
        //            List.fill[Array[Int]](word1.size+5)(List.fill[Int](word2.size+5)(0).toArray).toArray

        var minDisArr = Array.ofDim[Int](word1.size + 1, word2.size + 1)

        for (i <- 0 to word1.size; j <- 0 to word2.size) {
            if (i == 0 || j == 0) minDisArr(i)(j) = i + j

            else if (word1(i - 1).equals(word2(j - 1)))
                minDisArr(i)(j) = minDisArr(i - 1)(j - 1)

            else
                minDisArr(i)(j) = 1 + (minDisArr(i - 1)(j - 1) min minDisArr(i)(j - 1) min minDisArr(i - 1)(j))

        }
        minDisArr(word1.size)(word2.size)
    }

    def isInterleaveTwo(s1: String, s2: String, s3: String): Boolean = {
        val asgag = s1.toCharArray
        if (s1.size + s2.size != s3.size) false
        else {
            var pivot1 = 0
            var pivot2 = 0
            for (i <- 0 until s3.size) {
                println(pivot1, pivot2, i, s3(i))
                val c1 = s1(pivot1)
                val c2 = s2(pivot2)
                if (s3(i).equals(c1)) pivot1 += 1
                else if (s3(i).equals(c2)) pivot2 += 1
            }
            if (pivot1 == s1.size - 1 && pivot2 == s2.size - 1) true
            else false
        }
    }

    def isInterleave(s1: String, s2: String, s3: String): Boolean = {
        val c1 = s1.toCharArray()
        val c2 = s2.toCharArray()
        val c3 = s3.toCharArray()
        val m = s1.length()
        val n = s2.length()
        if (m + n != s3.length()) false
        else dfs(c1, c2, c3, 0, 0, 0, Array.ofDim[Boolean](m + 1, n + 1))
    }

    def dfs(c1: Array[Char], c2: Array[Char], c3: Array[Char], i: Int, j: Int, k: Int, invalid: Array[Array[Boolean]]): Boolean = {
        if (invalid(i)(j)) return false
        if (k == c3.length) return true
        val valid =
            i < c1.length && c1(i) == c3(k) && dfs(c1, c2, c3, i + 1, j, k + 1, invalid) ||
                j < c2.length && c2(j) == c3(k) && dfs(c1, c2, c3, i, j + 1, k + 1, invalid)
        if (!valid) invalid(i)(j) = true
        valid
    }

    def countWords(text: String): Int = {
        val counts = Map.empty[String, Int].withDefaultValue(0)
        println(counts)
        for (rawWord <- text.split("\\W+")) { // "[ ,!.]+", "[ ,!.]"
            val word = rawWord.toLowerCase
            counts(word) += 1
        }
        counts.size
    }

    def findKthLargest(nums: Array[Int], k: Int): Int = {
        val pq = PriorityQueue.empty(Ordering[Int].reverse)
        for (i <- 0 until nums.size) {
            if (i < k) pq.enqueue(nums(i))
            else {
                pq.enqueue(nums(i))
                pq.dequeue()
            }
        }
        pq.dequeue()
    }

    def containsDuplicate(nums: Array[Int]): Boolean = {
        var uniqueNums: mutable.HashMap[Int, Int] = new mutable.HashMap()
        var res: Boolean = true
        for(i <- 0 until nums.size){
            if(uniqueNums.contains(nums(i))) {
                res = false
                break
            }
            else {
                uniqueNums = uniqueNums + (nums(i) -> 1)
            }
        }
        res
    }

    def main(args: Array[String]): Unit = {

        //        println(findKthLargest(Array(3,2,1,5,6,4),2))
        //        println(findKthLargest(Array(3,2,3,1,2,4,5,5,6),4))

        //        println(countWords("three words here"))

        //        println(isInterleave("aabcc","dbbca","aadbbcbcac"))
        //
        println(minDistance("horse", "ros"))
        //        println(minDistance("intention","execution"))
        //
        //        println(coinChange(Array(1,2,5),11))
        //        println(coinChange(Array(2),3))
        //        println(coinChange(Array(1),0))

        //        println(maxEnvelopes(Array(Array(5,4),Array(6,4),Array(6,7),Array(2,3))))
        //        println(maxEnvelopes(Array(Array(1,1),Array(1,1),Array(1,1))))

        val input = "3[a2[c]]xyz"
        //        println(decodeString(input))

        val myNumberString = "tnztheewrreoooe"

        val numbersSpelling = Map(
            0 -> "zero",
            1 -> "one",
            2 -> "two",
            3 -> "three",
            4 -> "four",
            5 -> "five",
            6 -> "six",
            7 -> "seven",
            8 -> "eight",
            9 -> "nine",
        )


    }

}
