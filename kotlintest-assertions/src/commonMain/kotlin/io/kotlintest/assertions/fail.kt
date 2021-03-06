package io.kotlintest.assertions

import io.kotlintest.shouldThrow
import io.kotlintest.shouldThrowAny
import io.kotlintest.shouldThrowExactly

/**
 * Verifies that [block] throws an [AssertionError]
 *
 * If [block] throws an [AssertionError], this method will pass. Otherwise, it will throw an error, as a failure was
 * expected.
 *
 * This should be used mainly to check that an assertion fails, for example:
 *
 * ```
 *     shouldFail {
 *        1 shouldBe 2  // This should fail
 *     }
 * ```
 *
 * @see shouldThrowAny
 * @see shouldThrow
 * @see shouldThrowExactly
 */
fun shouldFail(block: () -> Any?): AssertionError = shouldThrow(block)

fun fail(msg: String): Nothing = throw Failures.failure(msg)
