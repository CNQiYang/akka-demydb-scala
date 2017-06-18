package com.akkademy

import akka.actor.ActorSystem
import akka.testkit.TestActorRef
import akka.util.Timeout
import com.akkademy.message.{ActordemyDB, SetRequest}
import org.scalatest.{FunSpecLike, Matchers}

import scala.concurrent.duration._

/**
  * Created by qiyang on 2017/6/19.
  */
class AkkademyDBSpec extends FunSpecLike with Matchers{
  implicit val system=ActorSystem()
  implicit val timeout=Timeout(5 seconds)

  describe("akkademyDB"){
    describe("given SetRequest"){
      it("should place key/value into map"){
        val actorRef= TestActorRef(new ActordemyDB)
        actorRef ! SetRequest("key","value")

        val akkademyDb=actorRef.underlyingActor
        akkademyDb.map.get("key") should equal (Some("value"))
      }
    }
  }

}
