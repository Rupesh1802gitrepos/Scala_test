package com.rupesh

import org.apache.spark.sql.SparkSession

object TEST2 {
  def main(args: Array[String]): Unit = {
    val sparksession=SparkSession.builder().master("local[*]").appName("SplitStructType").getOrCreate()
  val data = sparksession.read.option("header",true).option("delimiter","|").csv("C:\\workspace\\firstSBT\\src\\main\\resources\\Sampledata\\jpdelta-sample.csv")
    data.show(false)
    val mapc = Map(("PC12532262","8gERPN4Y2T") -> "Rupesh",
      ("PC5019749","dm4F0J2umV") -> "R1",
      ("PC17820496","EOkW5lyKjn") -> "R2",
      ("PC16222241","EZB4bw0e6Q") -> "R3",
      ("PC7275578","fCLJzwlDxL") -> "R4",
      ("PC7167197","fxTStQuYOO") -> "R5")

//    data.coll
    data.collect().foreach{
      row =>
        val z = println(row(0))
        val a = row.toSeq

        val b = (a(0).toString,a(1).toString)
        val c = mapc(b).to

          println(c)
       // println(a)

    }
    sparksession.close()
  }

}
