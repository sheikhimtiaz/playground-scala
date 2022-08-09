package demo

case class AFunCaseClass(name: String = "Default name"){
    def someMethod(): Unit = println("sth")
    def someMethodTwo(): Unit = ()
}

