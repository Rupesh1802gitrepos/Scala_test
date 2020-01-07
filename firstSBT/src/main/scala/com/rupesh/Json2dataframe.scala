package com.rupesh

import org.apache.spark.sql._
import org.apache.spark.sql.functions._


object Json2dataframe {
  def main(args: Array[String]): Unit = {
    val sparksession = SparkSession.builder.master("local[*]").appName("Structtype").getOrCreate()
    sparksession.sparkContext.setLogLevel("ERROR")

    import sparksession.implicits._
    val employeeDf = sparksession.read.json("C:\\workspace\\firstSBT\\src\\main\\resources\\TESTJSONADOBE")
    employeeDf.printSchema()
    employeeDf.show()

//    val order=sparksession.read.parquet("C:\\workspace\\firstSBT\\src\\main\\resources\\part-m-00000.avro")
//    order.show()
    sparksession.close()

  }

}
