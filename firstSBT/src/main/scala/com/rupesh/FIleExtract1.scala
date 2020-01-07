package com.rupesh

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.regexp_extract

object FIleExtract1 {
  def main(args: Array[String]): Unit = {
    val sparksession= SparkSession.builder.master("local[*]").appName("firstSBT").getOrCreate()
    sparksession.sparkContext.setLogLevel("ERROR")
    import sparksession.implicits._

    val filDf1 = sparksession.read
      .option("header", "false")
      //      .option("delimiter", "/")
      .format("csv")
      .load("C:\\workspace\\firstSBT\\src\\main\\resources\\Scenario1.txt")

    val filDf2 = sparksession.read
      .option("header", "false")
      //      .option("delimiter", "/")
      .format("csv")
      .load("C:\\workspace\\firstSBT\\src\\main\\resources\\Scenario2.txt")

    val df2=filDf2.withColumn("filepath",regexp_extract(filDf2("_c0"),"[^/]*$",0)).show(false)
    var df1 = filDf1.withColumn("filepathbackslash",regexp_extract($"_c0","[^\\\\]*$",0)).show(false)
    sparksession.close()
  }

}
