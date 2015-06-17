package com.github.noahshen.vibranium.strategy

import java.util.concurrent.{TimeUnit, Semaphore}

/**
 * Created by noahshen on 15/6/16.
 */
class QuantityLimitStrategy (val permits: Int) {

  val availableResource: Semaphore = new Semaphore(permits, true)


  def tryAcquire(permits: Integer = 1, timeout: Long = Long.MaxValue, unit: TimeUnit = TimeUnit.MILLISECONDS): Boolean = {
    availableResource.tryAcquire(permits, timeout, unit)
  }

  def acquire(permits: Integer = 1): Option[Resource] = {
    availableResource.acquire(permits)
    Some(new QuantityResource(availableResource))
  }
}


class QuantityResource(val _availableResource: Semaphore) extends Resource {

  private val availableResource: Semaphore = _availableResource

  override def release: Unit = {
    availableResource.release()
  }
}
