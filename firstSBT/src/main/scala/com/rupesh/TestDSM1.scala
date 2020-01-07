package com.rupesh

import org.apache.spark.sql.{Row, SparkSession}

object TestDSM1 {
  def main(args: Array[String]): Unit = {
    val sparksession = SparkSession.builder().master("local[*]").appName("FlatNestedJSON").getOrCreate()
    sparksession.sparkContext.setLogLevel("ERROR")

    val Rdd = sparksession.sparkContext.textFile("C:\\workspace\\firstSBT\\src\\main\\resources\\Test_json.json")
    val rdd2 = Rdd.map(x => Row.fromSeq(x))


  }
}
