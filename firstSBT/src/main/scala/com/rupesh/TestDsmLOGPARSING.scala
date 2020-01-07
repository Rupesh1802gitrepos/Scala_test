package com.rupesh

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Calendar

import org.apache.spark.sql.SparkSession

object TestDsmLOGPARSING {
  def main(args: Array[String]): Unit = {
    val sparksession = SparkSession.builder().master("local[*]").appName("FlatNestedJSON").getOrCreate()
    sparksession.sparkContext.setLogLevel("ERROR")

    var accessLogs = sparksession.sparkContext.textFile("C:\\workspace\\firstSBT\\src\\main\\resources\\fake_logs.txt")
   // accessLogs.collect().foreach(println)

    def containsIP(line:String):Boolean = return line matches "^([0-9\\.]+) .*$"

    var ipaccesslogs = accessLogs.filter(containsIP)

    ipaccesslogs.collect().foreach(println)


    def extractIP(line:String):(String) = {
      // Here we are using the regular expression for matching the strings with a certain pattern.
      val pattern = "^([0-9\\.]+) .*$".r

      val pattern(ip:String) = line
      return (ip.toString)
    }
    var ips = ipaccesslogs.map(line => (extractIP(line),1));

    ips.collect().foreach(println)
    val now = Calendar.getInstance().getTime.toString.replace(":","")
    println(now)

    val date1 = LocalDateTime.now()
    println(date1)
    val date2 = LocalDateTime.now.format(DateTimeFormatter.ofPattern("YYYYMMdd_HHmmss"))
    println(date2)




  }

}
