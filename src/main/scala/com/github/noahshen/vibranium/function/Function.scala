package com.github.noahshen.vibranium.function

import com.github.noahshen.vibranium.strategy.Strategy

/**
  * Created by noahshen on 15/6/24.
  */
class Function (val _namespace: String, val _functionName: String, val _enable: Boolean, val _strategy: Strategy){
  val namespace = _namespace
  val functionName = _functionName

  def enable = _enable
  def strategy = _strategy

}
