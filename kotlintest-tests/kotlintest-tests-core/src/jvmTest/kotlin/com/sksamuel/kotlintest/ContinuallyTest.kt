package com.sksamuel.kotlintest

import io.kotlintest.continually
import io.kotlintest.matchers.ints.shouldBeLessThan
import io.kotlintest.matchers.string.shouldMatch
import io.kotlintest.shouldBe
import io.kotlintest.shouldThrowExactly
import io.kotlintest.specs.WordSpec
import java.time.Duration

class ContinuallyTest : WordSpec() {

  init {
    "continually" should {
      "pass working tests" {
        continually(Duration.ofMillis(500)) {
          3.shouldBeLessThan(4)
        }
      }
      "fail broken tests immediately"  {
        shouldThrowExactly<AssertionError> {
          continually(Duration.ofSeconds(3)) {
            5.shouldBeLessThan(4)
          }
        }.message shouldBe "5 should be < 4"
      }
      "fail tests start off as passing then fail within the period" {
        var n = 0
        val e = shouldThrowExactly<AssertionError> {
          continually(Duration.ofSeconds(3)) {
            Thread.sleep(10)
            n++ shouldBeLessThan 100
          }
        }
        e.message shouldMatch "Test failed after [\\d]+ms; expected to pass for 3000ms; attempted 100 times\nUnderlying failure was: 100 should be < 100".toRegex()
      }
    }
  }
}
