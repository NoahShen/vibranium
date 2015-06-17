package com.github.noahshen.vibranium.strategy

import java.util.concurrent.TimeUnit

import com.google.common.util.concurrent.RateLimiter

/**
 * Created by noahshen on 15/6/15.
 */
class FlowLimitStrategy (val permitsPerSecond: Double){

  val rateLimiter: RateLimiter = RateLimiter.create(permitsPerSecond)

  def tryAcquire(permits: Integer = 1, timeout: Long = Long.MaxValue, unit: TimeUnit = TimeUnit.MILLISECONDS): Boolean = {
    rateLimiter.tryAcquire(permits, timeout, unit)
  }

  def acquire(permits: Integer = 1): Option[Resource] = {
    val timeSlept = rateLimiter.acquire(permits)
    Some(new FlowResource(timeSlept))
  }
}

class FlowResource(val _timeSleptSecond: Double) extends Resource {
  def timeSleptSecond = _timeSleptSecond

  override def release: Unit = {
    // do nothing
  }
}

