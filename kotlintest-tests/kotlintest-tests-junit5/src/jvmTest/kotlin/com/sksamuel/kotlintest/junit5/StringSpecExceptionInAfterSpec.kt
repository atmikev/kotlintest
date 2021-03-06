package com.sksamuel.kotlintest.junit5

import io.kotlintest.Spec
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class StringSpecExceptionInAfterSpec : StringSpec() {

  init {
    "a failing test" {
      1 shouldBe 2
    }

    "a passing test" {
      1 shouldBe 1
    }

  }

  override fun afterSpec(spec: Spec) {
    throw RuntimeException("splatt!!")
  }

}
