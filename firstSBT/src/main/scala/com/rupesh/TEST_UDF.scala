package com.rupesh

import org.apache.spark.sql.{Column, Row, SparkSession}
import org.apache.spark.sql.functions._
import com.rupesh.ErrorMAP._
//import com.typesafe.config.ConfigFactory

object TEST_UDF {
  def main(args: Array[String]): Unit = {
    val sparksession = SparkSession.builder().master("local[*]").appName("FlatNestedJSON").getOrCreate()
    sparksession.sparkContext.setLogLevel("ERROR")
    import sparksession.implicits._
    val RECORD_TYPE = "RecordType"
    val sampleDf = sparksession.createDataFrame(
      List(("00", "DELHI", "111","222", "333"), ("00", "DELHI", "123123123", "231231231", "312312312")
      )).toDF("RecordType", "CITY", "key1", "key2", "key3")  //.printSchema() //.show(100,false)

    val lst = List("key1", "key2", "key3")
    val lst1 = lst.map(x => col(x)).toArray


//val xy = udf(getprimarykey1)
    val test2 = sampleDf.withColumn("primayKEY",getprimakey(aaa)(col("RecordType"),col("CITY"),struct("*"))).show()//.printSchema()//show(false)
//    val test3 = test2.withColumn("PRIMARY_KEY", concat_ws("-",col("primayKEY"))).show(false)
//    val test4 = sampleDf.withColumn("PK", concat(coalesce(lst1: _*))).show(false)
//    val test5 = sampleDf.withColumn("PRIM_KEY",concat(xy(aaa, ("RecordType"),("CITY"))).show()
//    val test3 = ConfigFactory.load("Errorfield.con").getObject("ErrorField.bbb").toConfig
//    val test4 = ConfigFactory.ParseResource()
  }

//  def getprimakey (mapconfig: Map[(String, String), (List[String], List[String])]) =  udf((rec:String ,layout:String) => {
//    println(rec+""+layout)
//    val s = mapconfig(rec,layout)._1.map(x =>col( x)).toArray//.map(x => col(x))
//    s
//  })
//def getprimakey (mapconfig: Map[(String, String), (List[String], List[String])]) =  udf((rec:String ,layout:String) => {
//  val s = mapconfig.get(rec,layout).map(_._1).getOrElse(Seq.empty).mkString("")
//  s
//})

  def getprimakey(mapconfig: Map[(String, String), (List[String], List[String])]) = udf((rec: String, layout: String, entireRow:Row) => {
    val a = mapconfig.get(rec,layout).map(_._1)
    println(a)
    val b = a.map(k => k.map(entireRow.getAs[String](_)))
    println(b)
      b.map(_.mkString)
  })


  //  def getprimarykey1 (mapconfig: Map[(String, String), (List[String], List[String])],record:String,layout:String):Array[Column] = {
//    val a = mapconfig(record,layout)._1.map(x => (x)).mkString("")
//    a
//  }

  def testmap (maptest:Map[String,String]) = udf ((record:String) =>{
     maptest(record)
  })

}
