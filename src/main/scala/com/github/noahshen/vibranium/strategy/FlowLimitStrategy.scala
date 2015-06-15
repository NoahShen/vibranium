package com.github.noahshen.vibranium.strategy

import java.util.concurrent.TimeUnit

import com.google.common.util.concurrent.RateLimiter

/**
 * Created by noahshen on 15/6/15.
 */
class FlowLimitStrategy (val permitsPerSecond: Double){

  val rateLimiter: RateLimiter = RateLimiter.create(permitsPerSecond)

  def acquire(permits: Integer = 1, timeout: Long = Long.MaxValue, unit: TimeUnit = TimeUnit.MILLISECONDS): Option[Resource] = {
    if (rateLimiter.tryAcquire(permits, timeout, unit)) {
      return Some(new FlowResource())
    }
    return None
  }
}

class FlowResource extends Resource {
  override def release: Unit = {
    // do nothing
  }
}

