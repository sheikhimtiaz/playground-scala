package demo.rockthejvm

import akka.NotUsed
import akka.actor.typed.receptionist.{Receptionist, ServiceKey}
import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.{ActorRef, ActorSystem, Behavior}

import scala.util.Random

object AkkaActorDiscovery {

    case class SensorReading(id: String, value: Double)

    object DataAggregator {
        val serviceKey = ServiceKey[SensorReading]("dataAggregator")

        def apply(): Behavior[SensorReading] = active(Map())

        def active(latestReadings: Map[String, Double]): Behavior[SensorReading] = Behaviors.receive { (context, reading) =>
            val id = reading.id
            val value = reading.value
            // val SensorReading(id, value) = reading
            val newReadings = latestReadings + (id -> value)
            // "display" part
            println(s"[${context.self.path.name}] Latest readings: $newReadings")
            active(newReadings)
        }
    }

    // sensor section
    trait SensorCommand

    case object SensorHeartbeat extends SensorCommand

    case class ChangeDataAggregator(agg: Option[ActorRef[SensorReading]]) extends SensorCommand

    object Sensor {
        def apply(id: String): Behavior[SensorCommand] = Behaviors.setup { context =>
            // use a message adapter to turn a receptionist listing into a SensorCommand
            val receptionistSubscriber: ActorRef[Receptionist.Listing] = context.messageAdapter {
                case DataAggregator.serviceKey.Listing(set) => ChangeDataAggregator(set.headOption)
            }
            // subscribe to the receptionist using the service key
            context.system.receptionist ! Receptionist.Subscribe(DataAggregator.serviceKey, receptionistSubscriber)
            activeSensor(id, None)
        }

        def activeSensor(id: String, aggregator: Option[ActorRef[SensorReading]]): Behavior[SensorCommand] =
            Behaviors.receiveMessage {
                case SensorHeartbeat =>
                    aggregator.foreach(_ ! SensorReading(id, Random.nextDouble() * 40))
                    Behaviors.same
                case ChangeDataAggregator(newAgg) =>
                    activeSensor(id, newAgg)
            }

//        def controller(): Behavior[NotUsed] = Behaviors.setup { context =>
//            val sensors = (1 to 10).map(i => context.spawn(Sensor(s"sensor_$i"), s"sensor_$i"))
//            val logger = context.log
//            // send heartbeats every second
//            import context.executionContext
//            context.system.scheduler.scheduleAtFixedRate(1.second, 1.second) { () =>
//                logger.info("Heartbeat")
//                sensors.foreach(_ ! SensorHeartbeat)
//            }
//            Behaviors.empty
//        }
    }

//    val guardian: Behavior[NotUsed] = Behaviors.setup { context =>
//        // controller for the sensors
//        context.spawn(Sensor.controller(), "controller")
//        val dataAgg1 = context.spawn(DataAggregator(), "data_agg_1")
//        // "publish" dataAgg1 is available by associating it to a key (service key)
//        context.system.receptionist ! Receptionist.register(DataAggregator.serviceKey, dataAgg1)
//        // change data aggregator after 10s
//        Thread.sleep(10000)
//        println("[guardian] Changing data aggregator")
//        context.system.receptionist ! Receptionist.deregister(DataAggregator.serviceKey, dataAgg1)
//        val dataAgg2 = context.spawn(DataAggregator(), "data_agg_2")
//        context.system.receptionist ! Receptionist.register(DataAggregator.serviceKey, dataAgg2)
//        Behaviors.empty
//    }

//    def main(args: Array[String]): Unit = {
//        val system = ActorSystem(guardian, "ActorDiscovery")
//        import system.executionContext
//        system.scheduler.scheduleOnce(20.seconds, () => system.terminate())
//    }

}
