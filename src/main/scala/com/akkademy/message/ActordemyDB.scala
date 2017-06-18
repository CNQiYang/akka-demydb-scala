package com.akkademy.message

import akka.actor.Actor
import akka.event.Logging
import scala.collection.mutable.{Map=>MMap}

/**
  * Created by qiyang on 2017/6/19.
  */

case class SetRequest(key:String,value:Object)

class ActordemyDB  extends Actor{
  val map: MMap[String, Object] = MMap()
  val log = Logging(context.system,this)


  override def preStart{
    println("start")
  }

  override def receive: Receive = {
    case SetRequest(key, value) => {
      log.info("received SetRequest- key:{} value:{}", key, value)
       map += (key->value)
    }
    case x=>log.info("received unknown message :{}",x)
  }
}
