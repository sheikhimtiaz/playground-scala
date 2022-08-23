package demo

object GenericTypes {

    case class Apple(name: String)
    case class AppleMagicHat(magic: Apple)

//    val apple: Apple

    def run(): Unit = {
        val someHat = AppleMagicHat(Apple("gala"))
        val apple: Apple = someHat.magic
        println(apple.name)
    }

    def main(args: Array[String]): Unit = {
        run
        typeDisjunction
    }

    def totalSize(list1: List[_], list2: List[_]): Int = ???

    def typeDisjunction(): Unit = {

        println(isIntOrString(Left(55)))

        println(isIntOrStringOrBool(10)) // prints "10 is an Integer"
        println(isIntOrStringOrBool("hello")) // prints "hello is a String"
        println(isIntOrStringOrBool(true)) // prints "true is a Boolean"
        //    Either Approach
        def isIntOrString(t: Either[Int, String]): String ={
            t match {
                case Left(i) => "%d is an Integer".format(i)
                case Right(s) => "%s is a String".format(s)
            }
        }

        //    Arbitrary-arity Union Type
        sealed trait IntOrStringOrBool[T]
        object IntOrStringOrBool {
            implicit val intInstance: IntOrStringOrBool[Int] =
                new IntOrStringOrBool[Int] {}
            implicit val strInstance: IntOrStringOrBool[String] =
                new IntOrStringOrBool[String] {}
            implicit val boolInstance: IntOrStringOrBool[Boolean] =
                new IntOrStringOrBool[Boolean] {}
        }

        def isIntOrStringOrBool[T: IntOrStringOrBool](t: T): String = t match {
            case i: Int => "%d is an Integer".format(i)
            case s: String => "%s is a String".format(s)
            case b: Boolean => "%b a Boolean".format(b)
        }

        // further generalization
        sealed trait AOrB[A, B]
        object AOrB {
            implicit def aInstance[A,B](a: A) = new AOrB[A, B] {}
            implicit def bInstance[A,B](b: B) = new AOrB[A, B] {}
        }

        def isIntOrString_fg[T <% String AOrB Int](t: T): String = t match {
            case i: Int => "%d is an Integer".format(i)
            case s: String => "%s is a String".format(s)
        }


    }
}
