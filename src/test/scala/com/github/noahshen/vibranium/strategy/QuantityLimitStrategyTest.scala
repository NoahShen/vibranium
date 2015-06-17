package com.github.noahshen.vibranium.strategy

import org.scalatest.{BeforeAndAfter, FunSuite}

/**
 * Created by noahshen on 15/6/17.
 */
class QuantityLimitStrategyTest extends FunSuite with BeforeAndAfter{

  var quantityLimitStrategy: QuantityLimitStrategy = _

  before {
    quantityLimitStrategy = new QuantityLimitStrategy(5)
  }

  test("quantity limit") {
    //    val trySuccess = flowLimitStrategy.tryAcquire()
    //    assert (trySuccess)

    val resOpt = quantityLimitStrategy.acquire()
    assert(resOpt.isDefined)
    resOpt match {
      case Some(res: QuantityResource) =>
        res.release
      case _ => fail()
    }
  }
}
