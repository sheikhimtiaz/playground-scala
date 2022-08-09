package demo

import scala.collection.immutable.Queue

object BFS {

    def breadth_first_traverse[Node](node: Node, f: Node => Queue[Node]): LazyList[Node] = {
        def recurse(q: Queue[Node]): LazyList[Node] = {
            if (q.isEmpty) {
                LazyList.empty
            } else {
                val (node, tail) = q.dequeue
                node #:: recurse(tail ++ f(node))
            }
        }

        node #:: recurse(Queue.empty ++ f(node))
    }

//    breadth_first_traverse(root, f) find (_ == 16)
}
