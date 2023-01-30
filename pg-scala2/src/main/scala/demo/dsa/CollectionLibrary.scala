package demo.dsa

import scala.collection.immutable.Queue
import scala.collection.mutable.{PriorityQueue, Stack}

object CollectionLibrary {

    def main(args: Array[String]): Unit = {

        val numberArray: PriorityQueue[Int] = PriorityQueue(5, 2, 73, 7, 2, 4, 8, 0, 1)
        println(numberArray)
        val numberArrayReverse: PriorityQueue[Int] = PriorityQueue(5, 2, 73, 7, 2, 4, 8, 0, 1)(Ordering[Int].reverse)
        println(numberArrayReverse)

        //        You can also provide your own ordering when creating the queue:
        //        val pq = PriorityQueue.empty[(Int, String)](
        //            implicitly[Ordering[(Int, String)]].reverse
        //        )
        //        Or if you explicitly don't want the second element to be consulted:
        //        val pq = PriorityQueue.empty[(Int, String)](
        //            Ordering.by((_: (Int, String))._1).reverse
        //        )

        case class Donut(name: String, price: Double)
        val priorityQueue1: PriorityQueue[Donut] = PriorityQueue(
            Donut("Plain Donut", 1.50),
            Donut("Strawberry Donut", 2.0),
            Donut("Chocolate Donut", 2.50))(Ordering.by(_.price))
        println(s"Elements of priorityQueue1 = $priorityQueue1")

        priorityQueue1.enqueue(Donut("Vanilla Donut", 1.0))
        println(s"Elements of priorityQueue1 after enqueue function is called = $priorityQueue1")

        priorityQueue1 += (Donut("Krispy Kreme Donut", 1.0))
        println(s"Elements of priorityQueue1 after enqueue function is called = $priorityQueue1")

        val donutDequeued: Donut = priorityQueue1.dequeue()
        println(s"Donut element dequeued = $donutDequeued")
        println(s"Elements of priorityQueue1 after dequeued function is called = $priorityQueue1")

        val emptyPriorityQueue: PriorityQueue[String] = PriorityQueue.empty[String]
        println(s"Empty emptyPriorityQueue = $emptyPriorityQueue")


        var q1 = Queue(1, 2, 3, 4, 5)
        print("Queue Elements: ")
        q1.foreach((element: Int) => print(element + " "))
        var firstElement = q1.front
        println("\nFirst element in the queue: " + firstElement)
        print("Queue Elements after enqueue: ")
        q1.foreach((element: Int) => print(element + " "))
        var deq = q1.dequeue
        print("\nQueue Elements after dequeue: ")
        q1.foreach((element: Int) => print(element + " "))
        print("\nDequeued element: " + deq)
        println("\nQueue is empty: " + q1.isEmpty)


        var s = Stack[Int]()
        s.push(5)
        s.push(1)
        s.push(2)
        println("s:" + s)
        var s2 = Stack[Int]()
        s2.push(5, 1, 2)
        println("s2:" + s2)
        println("Popped:" + s.pop)
        println("Popped:" + s.pop)
        println("Popped:" + s.pop)


    }

}
