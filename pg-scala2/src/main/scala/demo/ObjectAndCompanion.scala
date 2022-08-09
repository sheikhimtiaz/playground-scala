package demo

object ObjectAndCompanion {

    //Object-orientation + functional programming

    class Person(firstName: String, lastName: String){
        // fields and methods
    }

    // OO Design Patterns
    // singleton = one instance of a type is present

    object MySingleton

    object ClusterSingleton {
        val MAX_NODES = 20
        def getNumberOfNodes(): Int = { 20 }
    }
    val maxNodes = ClusterSingleton.MAX_NODES

    // class + object = companion
    class Kid(name: String, age: Int) {
        def greet(): String = s"Hello, my name is $name and I'm $age years old. Do I like vegetables? ${Kid.LIKES_VEGETABLES}"
    }

    object Kid {
        private val LIKES_VEGETABLES: Boolean = false
        // preconception
    }

    // instance-independent = "static"
    // companion objects are for "static" field/methods

    def playGame(kid: Kid) = println("playing a game with a kid")
    val bobbie = new Kid("Bobbie", 9)
    playGame(bobbie)
//    playGame(Kid)
//    Found: demo.ObjectAndCompanion.Kid.type Required: demo.ObjectAndCompanion.Kid

    def superpower  = "sst"

    def main(args: Array[String]): Unit = {

        println("milan" ensuring(_.length>3))

        var sum =0
        for(i<-List(5,10,15)){
            sum+= i
        }
        println(sum)

        //        def triple(x:Int):Int = x*3
        //        val tripleCopy = triple _ println(tripleCopy(-3))

        var res = 1
        List(2,3,6).foreach((x:Int)=>res*=x)
        println(res)

        val x: Option[String] = Some("turing")
        println(x.get)
        //        val x =

        var aList = List(1)
        println(aList(0))
        //        println(aList[0])


        val turing = Map("x"->"xx","y"->"yy","x"->"zz")
        println(turing("x"))
        println (turing get "a")
        //        Left

        val candids = collection.mutable.Buffer("T")
        candids += "a"
        println(candids)


        //        var company = {
        //            var name = ="sfa"
        //            name
        //        }
        //        println(name)
    }

}
