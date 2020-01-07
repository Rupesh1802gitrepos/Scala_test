package com.rupesh

import org.apache.spark.sql.SparkSession

object TestDSM {
  def main(args: Array[String]): Unit = {
    val sparksession = SparkSession.builder().master("local[*]").appName("FlatNestedJSON").getOrCreate()
    sparksession.sparkContext.setLogLevel("ERROR")

    val TestData = sparksession.read
      .option("header", "true")
      //      .option("delimiter", "/")
      //      .option("inferSchema", "true")
      .format("csv")
      .option("encoding", "UTF-8")
      .load("C:\\workspace\\firstSBT\\src\\main\\resources\\Test_json.json")

//    val Testdata1 = TestData.withColumn("col2",.
    TestData.show(false)

  }

}
