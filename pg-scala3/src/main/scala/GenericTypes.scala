object GenericTypes {

    def main(args: Array[String]): Unit = {
        typedisjunction
    }

    def typedisjunction: Unit = {
        def isIntOrString_scala3(t:Int | String | Boolean)=t match {
            case i: Int => "%d is an Integer".format(i)
            case s: String => "%s is a String".format(s)
            case b: Boolean => "%b is a Boolean".format(b)
        }

        println(isIntOrString_scala3(10))  //prints "10 is an Integer"
        println(isIntOrString_scala3("hello")) // prints "hello is a String"
        println(isIntOrString_scala3(true)) // prints "true is a Boolean"
    }

}
