package io.kotlintest.specs

import io.kotlintest.Matcher
import io.kotlintest.core.specs.AbstractDescribeSpec
import io.kotlintest.core.specs.AbstractExpectSpec
import io.kotlintest.core.specs.AbstractFeatureSpec
import io.kotlintest.core.specs.AbstractFreeSpec
import io.kotlintest.core.specs.AbstractShouldSpec
import io.kotlintest.core.specs.AbstractWordSpec
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.condition.EnabledIfSystemProperty
import io.kotlintest.should as shouldMatch

interface IntelliMarker {
  @EnabledIfSystemProperty(named = "wibble", matches = "wobble")
  @TestFactory
  fun primer() {
  }
}

abstract class AnnotationSpec(body: AbstractAnnotationSpec.() -> Unit = {}) : AbstractAnnotationSpec(body), IntelliMarker

abstract class DescribeSpec(body: AbstractDescribeSpec.() -> Unit = {}) : AbstractDescribeSpec(body), IntelliMarker
abstract class ExpectSpec(body: AbstractExpectSpec.() -> Unit = {}) : AbstractExpectSpec(body), IntelliMarker

abstract class FeatureSpec(body: AbstractFeatureSpec.() -> Unit = {}) : AbstractFeatureSpec(body), IntelliMarker

abstract class FreeSpec(body: AbstractFreeSpec.() -> Unit = {}) : AbstractFreeSpec(body), IntelliMarker


abstract class ShouldSpec(body: AbstractShouldSpec.() -> Unit = {}) : AbstractShouldSpec(body), IntelliMarker {
  // need to overload this so that when doing "string" should haveLength(5) in a word spec, we don't
  // clash with the other should method
  infix fun String.should(matcher: Matcher<String>) = this shouldMatch matcher
}

abstract class WordSpec(body: AbstractWordSpec.() -> Unit = {}) : AbstractWordSpec(body), IntelliMarker {
  // need to overload this so that when doing "string" should haveLength(5) in a word spec, we don't
  // clash with the other should method
  infix fun String?.should(matcher: Matcher<String?>) = this shouldMatch matcher
}
