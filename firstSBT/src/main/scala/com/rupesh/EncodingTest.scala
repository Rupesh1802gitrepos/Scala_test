package com.rupesh

import org.apache.spark.sql.SparkSession

object EncodingTest {
  def main(args: Array[String]): Unit = {
    val sparksession = SparkSession.builder().master("local[*]").getOrCreate()
    sparksession.sparkContext.setLogLevel("ERROR")

    val ExpectedOutputDF = sparksession.read
      .option("header", "true")
      //        .option("inferSchema","true")
      .format("csv")
      .option("encoding", "ISO-8859-1")
      .load("C:\\workspace\\firstSBT\\src\\main\\resources\\ExpectedOutput.csv")

    val ErrorLogDF = sparksession.read
      .option("header", "true")
      //      .option("delimiter", "/")
      //      .option("inferSchema", "true")
      .format("csv")
      .option("encoding", "ISO-8859-1")
      .load("C:\\workspace\\firstSBT\\src\\main\\resources\\ErrorLogData.csv")

    ErrorLogDF.show(100, false)
//    import scala.jdk.CollectionConverters._

    import scala.collection.JavaConverters._
    val listrecord = ExpectedOutputDF.select("Test case number").distinct()
    val recordTypeList = listrecord.collect().map(row => row.getString(0)).toList
    for(i <- recordTypeList){
      println(i)
    }

//    for (i <- listrecord.asScala){
//      println(i)
//    }

    ExpectedOutputDF.show(100, false)
  }

}
