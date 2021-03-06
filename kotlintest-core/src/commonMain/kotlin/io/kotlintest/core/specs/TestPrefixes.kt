package io.kotlintest.core.specs

fun createTestName(prefix: String, name: String): String {
  return when {
    name.startsWith("!") -> "!$prefix${name.drop(1)}"
    name.startsWith("f:") -> "f:$prefix${name.drop(2)}"
    else -> "$prefix$name"
  }
}
