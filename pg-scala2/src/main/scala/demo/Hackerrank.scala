package demo

object Hackerrank {

    def missingNumbers(arr: Array[Int], brr: Array[Int]): Array[Int] = {
        var numbers: Map[Int, Int] = Map.empty[Int, Int]
        for(item <- brr){
            numbers = numbers + (item -> (numbers.get(item).getOrElse(0)+1) )
        }
        for(item <- arr){
            numbers = numbers + (item -> (numbers.get(item).getOrElse(1)-1) )
        }
        val predicate: ((Int, Int)) => Boolean = {
            case (key, value) => value > 0
        }
        numbers.filter(predicate).keys.toArray.sorted
    }

    def main(args: Array[String]): Unit = {
        val arr = Array(203,204,205,206,207,208,203,204,205,206)
        val brr = Array(203,204,204,205,206,207,205,208,203,206 ,205, 206, 204)
        println(missingNumbers(arr, brr).toList)

    }

}
