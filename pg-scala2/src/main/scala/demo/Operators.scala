package demo

object Operators extends App {

  // variables
  var a = 50
  var b = 40
  var c = 0


  // simple addition
  c = a + b
  println("simple addition: c= a + b = " + c)

  // Add AND assignment
  c += a
  println("Add and assignment of c += a = " + c)

  // Subtract AND assignment
  c -= a
  println("Subtract and assignment of c -= a = " + c)

  // Multiply AND assignment
  c *= a
  println("Multiplication and assignment of c *= a = " + c)

  // Divide AND assignment
  c /= a
  println("Division and assignment of c /= a = " + c)

  // Modulus AND assignment
  c %= a
  println("Modulus and assignment of c %= a = " + c)

  // Left shift AND assignment
  c <<= 3
  println("Left shift and assignment of c <<= 3 = " + c)

  // Right shift AND assignment
  c >>= 3
  println("Right shift and assignment of c >>= 3 = " + c)

  // Bitwise AND assignment
  c &= a
  println("Bitwise And assignment of c &= 3 = " + c)

  // Bitwise exclusive OR and assignment
  c ^= a
  println("Bitwise Xor and assignment of c ^= a = " + c)

  // Bitwise inclusive OR and assignment
  c |= a
  println("Bitwise Or and assignment of c |= a = " + c)

  // variables
  val aa = 20
  val bb = 18
  var cc = 0
  println(s"aa = $aa, bb = $bb, cc = $cc")

  // Bitwise AND operator
  cc = aa & bb
  println("Bitwise And of a & b = " + cc)

  // Bitwise OR operator
  cc = aa | bb
  println("Bitwise Or of a | b = " + cc)

  // Bitwise XOR operator
  cc = aa ^ bb
  println("Bitwise Xor of a ^ b = " + cc)

  // Bitwise once complement operator
  cc = ~aa
  println("Bitwise Ones Complement of ~a = " + cc)

  // Bitwise left shift operator
  cc = aa << 3
  println("Bitwise Left Shift of a << 3 = " + cc)

  // Bitwise right shift operator
  cc = aa >> 3
  println("Bitwise Right Shift of a >> 3 = " + cc)

  // Bitwise shift right zero fill operator
  cc = aa >>> 4
  println("Bitwise Shift Right a >>> 4 = " + cc)

}
