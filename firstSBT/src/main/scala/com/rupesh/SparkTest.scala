package com.rupesh
//import com.sun.org.apache.bcel.internal.Constants
import org.apache.spark.sql._
import sun.misc.ObjectInputFilter.Config
case class schema (a1:String,a2:String,a3:String,a4:String,a5:String,a6:String,a7:String)


object SparkTest {
//  import org.apache.spark.sql.SparkSession
  def main(args: Array[String]): Unit = {
  val sparksession= SparkSession.builder.master("local[*]").appName("firstSBT").getOrCreate()
    sparksession.sparkContext.setLogLevel("ERROR")


    val events = List(
      "Prime Sound,10000",
      "Prime Sound,5000",
      "Sportsorg,20000",
      "Sportsorg,5000",
      "Ultra Sound,30000",
      "Ultra Sound,5000"
    )
//    import sparksession.implicits._
//    val demographicsRDD = sparksession.sparkContext.textFile("C:\\workspace\\firstSBT\\src\\main\\resources\\test.txt")
////    demographicsRDD.collect.foreach(println)
//
//    val splitrdd=demographicsRDD.map(x=>x.split("\\|",-1)).toDF()
//    val splitrdd1=demographicsRDD.map(x=>x.split("\\|",-1)).map(x=>schema(x(0),x(1),x(2),x(3),x(4),x(5),x(6))).toDF()
//    val splitrdd2=splitrdd1.select("a1","a3","a5")
//
//    splitrdd1.show()
//    splitrdd2.show()

    val eventsRDD = sparksession.sparkContext.parallelize(events)
    eventsRDD.collect.foreach(println)
    sparksession.close()



  }
}
