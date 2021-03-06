package io.kotlintest.inspectors

import io.kotlintest.assertions.Failures
import io.kotlintest.assertions.exceptionToMessage
import io.kotlintest.assertions.show.show

fun <T> buildAssertionError(msg: String, results: List<ElementResult<T>>): String {

  val passed = results.filterIsInstance<ElementPass<T>>()
  val failed = results.filterIsInstance<ElementFail<T>>()

  val builder = StringBuilder(msg)
  builder.append("\n\nThe following elements passed:\n")
  if (passed.isEmpty()) {
    builder.append("--none--")
  } else {
    builder.append(passed.map { it.t }.joinToString("\n"))
  }
  builder.append("\n\nThe following elements failed:\n")
  if (failed.isEmpty()) {
    builder.append("--none--")
  } else {
    builder.append(failed.joinToString("\n") {
      it.t.show() + " => " + exceptionToMessage(it.throwable)
    })
  }
  throw Failures.failure(builder.toString())
}

