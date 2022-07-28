package demo

object Underscores {

    // 1 - ignoring stuff
    val _ = 5
    val onlyFives = (1 to 10).map(_ => 5)

    trait Singer
    trait Actor { _: Singer =>
        //your implementation
    }

    def processList(list: List[Option[_]]): Int = list.length

    // 2 - everything = wildcard

    val meaningOfLife: Any = 42
    meaningOfLife match {
        case _ => "I'm fine with anything"
    }

    import scala.concurrent.duration._ // import everything

    // 3 - default initializers

    var myString: String = _ // 0 for numeric types, false for boolean types, null for reference types

    // 4 - lambda sugar

    List(1,2,3,4,5).map(x => x*5)
    List(1,2,3,4,5).map(_ * 5) // identical

    val sumFuction: (Int, Int) => Int = _ + _

    // 5 - Eta-expansion

    def incrementer(x:Int) = x + 1
    val incrementerFunc = incrementer _

    // 6 - HKT Higher Kinded Types

    class MyHigherKindedJewels[M[_]]
    val myJewel = new MyHigherKindedJewels[List]

    // 7 - vararg methods

    def makeSentence(words: String*) = words.toSeq.mkString(" ")
    makeSentence("I", "Love", "Scala")
    val words = List("I", "Love", "Scala")
    val love = makeSentence(words: _*)

    def main(args: Array[String]): Unit = {
        println(love)
    }


}
