package demo

object EPSWeekTwo extends App{
  println("Week 2")

  /**
   * First Steps with Lists
   * @param contacts
   */
  case class AddressBook(contacts: List[Contact])
  case class Contact(
    name: String,
    email: String,
    phoneNumbers: List[String]
  )

  val alice = Contact("Alice", "alice@gmail.com", List())
  val bob = Contact("Bob", "bob@gmail.com", List("+417854845420"))

  val addressBook = AddressBook(List(alice, bob))
  println(addressBook)

  val numberOfContact: Int = addressBook.contacts.size
  println(numberOfContact)

  val isAliceInContacts = addressBook.contacts.contains(alice)
  println(isAliceInContacts)

  val contactNames: List[String] = addressBook.contacts.map(contact => contact.name)
  println(contactNames)

  val contactsWithPhone: List[Contact] = addressBook.contacts.filter(contact => contact.phoneNumbers.nonEmpty)
  println(contactsWithPhone)

  /**
   * Functions
   */

  val incrementTwo: Int => Int =
    x =>{
      val result = x + 1
      result
    }

  val increment: Int => Int = x => x + 1

  val add =
    (x: Int, y: Int) => x + y

  println(add(1, increment(2)))// 4



}
