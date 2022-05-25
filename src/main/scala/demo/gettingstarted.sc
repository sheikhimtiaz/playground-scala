print("welcome to scala")
print("Hello Alo")

5+5

2+9


object Demo extends App{
  println("Hello world!")

  var num: Int = 8
  val meaningOfLife: Int = 73

  num += 3

}

Demo.num

println("kapjhap")

5 + 5

var ans = "test"
ans = "change"

println(ans)

var res = 5

res = res + 4

res += 100

res

val languages = Vector("Java", "Scala", "Lisp", "Rust")

languages.map(lang => lang.toUpperCase)

languages.map(lang => lang.length)

languages.map(_.length)

val name = Seq("Alice", "Bob")

name.flatMap(_.toLowerCase())

val test = Seq(36,"3gag")

test.map(item=> item+"1")

test.flatMap(any=>any.toString)


val numList = List(1,2)
val strList = List("hi", "hello")

numList map {
  y => 2*y
}

strList map { x => numList map {
  y => x*y
}
}


strList flatMap { x => numList map {
  y => x*y
}
}

val stringMul = "test" * 2

strList.map(str => str*2)
