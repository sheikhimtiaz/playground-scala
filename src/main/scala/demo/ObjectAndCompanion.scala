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

    def main(args: Array[String]): Unit = {

    }

}
