package com.rupesh

import org.apache.spark.sql.{Column, SparkSession}

object PatternmatchDataframe {
  def main(args: Array[String]): Unit = {
    val sparksession = SparkSession.builder.master("local[*]").appName("Structtype").getOrCreate()
    sparksession.sparkContext.setLogLevel("ERROR")

    import sparksession.implicits._

    var df1 =List(9.8,7,6,3,1).toDF()
    df1.show()


//    def patterndataframe (col :Column):Unit = {
//      col match {
//        case 0 => println("this is 0")
//        case 1 => println("lets one")
//        case 2 => println("this is two")
//      }
    //}
  }

}
