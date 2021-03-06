//package com.sksamuel.kotlintest.tables
//
//import com.univocity.parsers.csv.CsvFormat
//import io.kotlintest.matchers.comparables.gt
//import io.kotlintest.specs.WordSpec
//import io.kotlintest.shouldBe
//import io.kotlintest.shouldNotBe
//import io.kotlintest.tables.CsvDataSource
//import io.kotlintest.tables.Headers3
//import io.kotlintest.tables.Row3
//import io.kotlintest.tables.forAll
//
//class CsvDataSourceTest : WordSpec() {
//  init {
//    "CsvDataSource" should {
//      "read data from csv file" {
//        val source = CsvDataSource(javaClass.getResourceAsStream("/user_data.csv"), CsvFormat())
//        val table = source.createTable<Long, String, String>(
//            { Row3(it.getLong("id"), it.getString("name"), it.getString("location")) },
//            { Headers3(it[0], it[1], it[2]) }
//        )
//        forAll(table) { a, b, c ->
//          a shouldBe gt(0)
//          b shouldNotBe null
//          c shouldNotBe null
//        }
//      }
//    }
//  }
//}
