package io.kotest.plugin.pitest

import org.pitest.help.PitHelpError
import org.pitest.testapi.Configuration
import org.pitest.testapi.TestSuiteFinder
import org.pitest.testapi.TestUnitFinder
import java.util.Optional

class KotlinTestConfiguration : Configuration {

  override fun verifyEnvironment(): Optional<PitHelpError> = Optional.empty()

  override fun testUnitFinder(): TestUnitFinder = KotlinTestUnitFinder()

  override fun testSuiteFinder(): TestSuiteFinder = KotlinTestSuiteFinder()

}
