package com.rupesh

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object ExtractfromJson {
  def main(args: Array[String]): Unit = {
    val sparksession = SparkSession.builder.master("local[*]").appName("Structtype").getOrCreate()
    sparksession.sparkContext.setLogLevel("ERROR")
    val df1=sparksession.read.option("multiline","true").json("C:\\workspace\\firstSBT\\src\\main\\resources\\Structjson")
    df1.printSchema()
    df1.show(false)

    def removeEscapeCharacterFromString: String => String = (jsonStr: String) => jsonStr
      .replace("\"\\\"", "\"")
      .replace("\\\"\"", "\"")
      .replace("\\\"", "\"")
      .replace("\"{", "{")
      .replace("}\"", "}")


    sparksession.close()
  }

}
