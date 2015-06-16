package com.github.noahshen.vibranium.strategy

import java.util.concurrent.{TimeUnit, Semaphore}

/**
 * Created by noahshen on 15/6/16.
 */
class ResourceLimitStrategy (val permits: Int) {

  val available: Semaphore = new Semaphore(permits, true)


  def acquire(permits: Integer = 1, timeout: Long = Long.MaxValue, unit: TimeUnit = TimeUnit.MILLISECONDS): Option[Resource] = {
    available.acquire()
    None
  }
}
