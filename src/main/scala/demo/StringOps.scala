package demo

import scala.collection.mutable

object StringOps extends App {
    val sb = new StringBuilder("")
    sb.append("Something")
    val sth = sb.append(" is h..")
    println(sb)

    val sb2 = new StringBuilder(" kapjhap")
    sb.append(sb2)
    println(sb)
    println("stuff" + new StringBuilder(" works!"))
}
