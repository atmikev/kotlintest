package io.kotlintest.core

actual fun sourceRef(): SourceRef {
  val stack = Throwable().stackTrace
  return stack.dropWhile {
    it.className.startsWith("io.kotlintest")
  }[0].run { SourceRef(lineNumber, fileName) }
}
