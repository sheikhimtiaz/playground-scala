package demo

import scala.collection.mutable
import scala.collection.parallel.CollectionConverters._

object FoldingLists extends App {

    val list = List(1,2,3,4,5)
    val sum = list.fold(list(0))((x,y) => x+y)
    println(sum)

    case class Person(name: String, sex: String)

    val persons = List(Person("Thomas", "male"),
        Person("Andreas", "male"),
        Person("Torstein", "female"))

    val foldedList = persons.foldLeft(List[String]()){(accumulator, person) =>
        val title = person.sex match {
            case "male" => "Mr."
            case "female" => "Ms."
        }
        accumulator :+ s"$title ${person.name}"
    }
    println(foldedList)

    //  List(1,2,3).foldLeft(0)(f) = f(f(f(0,1),2),3)

    val foldedList2 = persons.foldRight(List[String]()){(person, accumulator) =>
        val title = person.sex match {
            case "male" => "Mr."
            case "female" => "Ms."
        }
        accumulator :+ s"$title ${person.name}"
    }
    println(foldedList2)

    //  List(1, 2, 3).foldRight(0)(f) = f(1, f(2, f(3, 0)))

    /**
     * Fold
     * foldLeft and foldRight are linear operations, while fold can be a tree operation, meaning there’s no guarantee
     * of the processing order. It can decompose a list into subsets in arbitrary order. These can then be evaluated
     * separately, and the results put together to give a final result.
     * The fold method primarily exists to support parallelism.
     */
    println(List(1, 2, 3, 4, 5).fold(0)(_ + _))
    println(List(1, 2, 3, 4, 5).foldLeft(0)(_ + _))
    println(List(1, 2, 3, 4, 5).foldRight(0)(_ + _))

    //  Without parallelizing, it will just work like foldLeft

    val parallelNumSeq = List(1, 2, 3, 4, 5).par

    val foldLeftResult = parallelNumSeq.foldLeft(0) { (acc, currNum) =>
        val sum = acc + currNum
        println(s"FoldLeft: acc($acc) + currNum($currNum) = $sum")
        sum
    }
    println(foldLeftResult)

    val foldRightResult = parallelNumSeq.foldRight(0) { (currNum, acc) =>
        val sum = acc + currNum
        println(s"FoldRight: acc($acc) + currNum($currNum) = $sum")
        sum
    }
    println(foldRightResult)

    val foldResult = parallelNumSeq.fold(0) { (acc1, acc2) =>
        val sum = acc1 + acc2
        println(s"Fold: acc1($acc1) + acc2($acc2) = $sum")
        sum
    }
    println(foldResult)

    println(List(1, 2, 3, 4, 5).foldLeft(5)(_ + _))
    println(List(1, 2, 3).fold(5)(_ + _))

    println("  ######   ")
    val sth = List().fold(new StringBuilder()){ (acc, item) =>
        println("acc => " + acc)
        acc.append(item)
    }
    println("sth => "+sth)
}
