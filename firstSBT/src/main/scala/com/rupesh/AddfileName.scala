package com.rupesh

import org.apache.spark.sql.SparkSession

object AddfileName {

  def main(args: Array[String]): Unit = {
    case class Person(inputPath: String, name: String, age: Int)
    val sparksession = SparkSession.builder().master("local[*]").appName("FlatNestedJSON").getOrCreate()
    val inputpath = "C:\\workspace\\firstSBT\\src\\main\\resources\\JSONobj"
    var rdd = sparksession.sparkContext.textFile(inputpath).map{
      l =>
    }
  }

}
