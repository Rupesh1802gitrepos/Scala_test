package com.rupesh

import org.apache.spark.sql._
import org.apache.spark.sql.catalyst.plans.logical.Window
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._
//import org.spark_project.jetty.util.annotation.Name

object TESTQA {
  def main(args: Array[String]): Unit = {
    val sparksession = SparkSession.builder().master("local[*]").appName("Transpose").getOrCreate()
    sparksession.sparkContext.setLogLevel("ERROR")

    val df = sparksession.read.option("header",true)
      .option("delimiter",",")
      .format("csv")
    .load("C:\\workspace\\firstSBT\\src\\main\\resources\\groupby.txt")

    val df2 = df.select("recordType","Name","errors.errorCode","errors.errorName")


//df.show(false)
     df2.collect().foreach{

      row =>
        println(row)
    }
    val df3 = df.withColumn("concat1",(col("Name") + col("recordType"))).show(false)
    import sparksession.implicits._

//    val df2 = df1.groupBy(Name).as)


//    val goalsDF = Seq(
//      ("messi", 2),
//      ("messi", 1),
//      ("pele", 3),
//      ("pele", 1)
//    ).toDF("name", "goals")
//
//    goalsDF.show(false)
//    val df3 = goalsDF.groupBy("name").toDF.show()
//case class Product(Item: String, Shape: String, revenue: Int)
//
//    val productList = List(
//      ("Thin", "Cell phone", 6000),
//      ("Normal", "Tablet", 1500),
//      ("Mini", "Tablet", 5500),
//      ("Ultra Thin", "Cell phone", 5000),
//      ("Very Thin", "Cell phone", 6000),
//      ("Big", "Tablet", 2500),
//      ("Bendable", "Cell phone", 3000),
//      ("Foldable", "Cell phone", 3000),
//      ("Pro", "Tablet", 4500),
//      ("Pro2", "Tablet", 6500)
//    )
//    val products1 = sparksession.createDataFrame(productList)
//    products1.createOrReplaceTempView("products")
//    products1.printSchema()
//
//    val catRevenueWindowSpec = Window.partitionBy($"category")
//      .orderBy($"revenue")




    //val df2 = df.withColumn("primKey",concat(col("record Type")).show(false)

//                println(row(0)+row(1))
//        val x = row.toString()
////        println(x)
//        println(x(0))
//        val y = x(1)+x(2)



//

//    }



//    val rdd = sparksession.sparkContext.textFile("C:\\workspace\\firstSBT\\src\\main\\resources\\Sampledata\\KC_Extract_1_20171015.csv")
//   val rdd2 = rdd.map(x=>x.split("\\|",-1))
//    val dd1 = rdd2.map(x =>  (x(0)+(x(1)))).collect().foreach(println)
//rdd.collect().foreach(println)
//    val rdd = df.map(x => (x(0),x(1),x(2),x(3),(4)).toString())
//    rdd.collect(5)

    //val LayoutRecordKeyCOnfig = Map(("SP",01)->(List("R01_cardigoArquivo","R01_XXXXXX"),List("R01_A","R01_B","R01_c")))


  }

}
