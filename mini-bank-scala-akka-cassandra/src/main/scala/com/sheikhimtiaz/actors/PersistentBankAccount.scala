package com.sheikhimtiaz.actors

import akka.actor.typed.{ActorRef, Behavior}
import akka.persistence.typed.PersistenceId
import akka.persistence.typed.scaladsl.{Effect, EventSourcedBehavior}

// a single bank account
class PersistentBankAccount {

    /*
      - fault tolerance
     */

    // commands = messages
    sealed trait Command
    case class CreateBankAccount(user: String, currency: String, initialBalance: Double, replyTo: ActorRef[Response]) extends Command
    case class UpdateBalance(id: String, currency:String, amount: Double, replyTo: ActorRef[Response]) extends Command
    case class GetBankBalance(id: String, replyTo: ActorRef[Response]) extends Command

    //events to persist to Cassandra
    trait Event
    case class BankAccountCreated(bankAccount: BankAccount) extends Event
    case class BalanceUpdated(amount: Double) extends Event


    //state
    case class BankAccount(id: String, user: String, currency: String, balance: Double)

    // responses
    sealed trait Response
    case class BankAccountCreatedResponse(id: String) extends Response
    case class BankAccountBalanceUpdatedResponse(maybeBankAccount: Option[BankAccount]) extends Response
    case class GetBankAccountResponse(maybeBankAccount: Option[BankAccount]) extends Response

    // command handler = message handler => persist an event
    // event handler = update state
    // state

    val commandHandler: (BankAccount, Command) => Effect[Event, BankAccount] = (state, command) =>
        command match {
            case CreateBankAccount(user, currency, initialBalance, replyTo) =>
                val id = state.id
                Effect
                    .persist(BankAccountCreated(BankAccount(id, user, currency, initialBalance)))
                    .thenReply(replyTo)(_ => BankAccountCreatedResponse(id))
        }
    val eventHandler: (BankAccount, Event) => BankAccount = ???

    def apply(id: String): Behavior[Command] = EventSourcedBehavior[Command, Event, BankAccount](
        persistenceId = PersistenceId.ofUniqueId(id),
        emptyState = BankAccount(id, "", "", 0.0), // unused
        commandHandler = commandHandler,
        eventHandler = eventHandler
    )

}
