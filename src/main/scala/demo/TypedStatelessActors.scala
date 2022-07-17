package demo

import akka.actor.typed.{ActorSystem, Behavior}
import akka.actor.typed.scaladsl.Behaviors

object TypedStatelessActors {

    trait SimpleThing
    case object EatChocolate extends SimpleThing
    case object WashDishes extends SimpleThing
    case object LearnAkka extends SimpleThing

    val emotionalMutableActor: Behavior[SimpleThing] = Behaviors.setup{ context =>
        // sping up the actor state
        var happiness = 0

        // behaviour of the actor
        Behaviors.receiveMessage{
            case EatChocolate =>
                println(s"($happiness) Eating chocolate, getting a shot of dopamine")
                happiness += 1
                Behaviors.same
            case WashDishes =>
                println(s"($happiness) Washing dishes, getting a shot of dopamine")
                happiness -= 2
                Behaviors.same
            case LearnAkka =>
                println(s"($happiness) Learning Akka, getting a shot of dopamine")
                happiness += 100
                Behaviors.same
            case _ =>
                println(s"($happiness) Received something I don't know")
                Behaviors.same
        }
    }

    def emotionalFunctionalActor(happiness: Int = 0): Behavior[SimpleThing] = Behaviors.receive{ (context, message) =>
        message match {
            case EatChocolate =>
                println(s"($happiness) Eating chocolate, getting a shot of dopamine")
                emotionalFunctionalActor(happiness + 1) // new behavior
            case WashDishes =>
                println(s"($happiness) Washing dishes, getting a shot of dopamine")
                emotionalFunctionalActor(happiness - 1)
            case LearnAkka =>
                println(s"($happiness) Learning Akka, getting a shot of dopamine")
                emotionalFunctionalActor(happiness + 100)
            case _ =>
                println(s"($happiness) Received something I don't know")
                Behaviors.same
        }
    }

    def main(args: Array[String]): Unit = {
        val emotionalActorSystem = ActorSystem(emotionalFunctionalActor(), "EmotionalSystem")

        emotionalActorSystem ! EatChocolate
        emotionalActorSystem ! EatChocolate
        emotionalActorSystem ! WashDishes
        emotionalActorSystem ! LearnAkka

        Thread.sleep(1000)
        emotionalActorSystem.terminate()

    }

}
