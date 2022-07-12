package demo

object SelfTypeQuick {

    trait Edible
    trait Person{
        def hasAllergiesTO(thing: Edible): Boolean
    }
    trait Child extends Person
    trait Adult extends Person

    trait Diet{
        def eat(thing: Edible): Boolean
    }
    trait Carnivore extends Diet
    trait Vegetarian extends Diet

    // PROBLEM: Diet must be applicable to Persons only
    // class VegetarianAthlete extends Vegetarian with Adult // enforce at compile time

    // Option #3 -

//    trait Edible
//    trait Person{
//        def hasAllergiesTO(thing: Edible): Boolean
//    }
//    trait Child extends Person
//    trait Adult extends Person
//
//    trait Diet{ this: Person => // self-type: whoever extends Diet MUST ALSO extends Person
//        def eat(thing: Edible): Boolean =
//            if(this.hasAllergiesTO(thing)) false
//            else 45 > 32
//    }
//    trait Carnivore extends Diet with Person
//    trait Vegetarian extends Diet with Person
//
//    class VegetarianAthlete extends Vegetarian with Adult {
//        override def hasAllergiesTO(thing: Edible): Boolean = false
//    }


    // inheritance vs self-types
    trait Animal
    trait Dog extends Animal // a dog IS AN Animal

    trait Diet2 { self: Person => // a diet REQUIRES a Person
    }

    def main(args: Array[String]): Unit = {

    }
}
