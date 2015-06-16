package com.github.noahshen.vibranium.strategy

import org.scalatest.{BeforeAndAfter, FunSuite}

/**
 * Created by noahshen on 15/6/15.
 */
class FlowLimitStrategyTest extends FunSuite with BeforeAndAfter{

  var flowLimitStrategy: FlowLimitStrategy = _

  before {
    flowLimitStrategy = new FlowLimitStrategy(5)
  }

  test("flow limit") {
    val resOpt = flowLimitStrategy.acquire()
    assert(resOpt.isDefined)
    resOpt match {
      case Some(res) => res.release
    }
  }
}
