package com.rupesh

import org.apache.spark.sql._
import org.apache.spark.sql.functions._

object Fileextract {
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
//    filDf2.registerTempTable("table2")

//    val fildf3=filDf2.select("regexp_extract($0,^\\(.+\\),0)")

    val df4=filDf2.withColumn("filepath",regexp_extract(filDf2("_c0"),"[^/]*$",0))
//    val dftxt=df4.withColumn("txt",lit(".txt"))
    df4.show(false)
//    val dfconcat=df4.withColumn("withtext",lit(concat($"filepath"+".txt")))
//     val dfconcat=dftxt.withColumn("withtext",concat($"filepath",$"txt"))
//    dfconcat.show(20,false)
    var dfbackslash = filDf1.withColumn("filepathbackslash",regexp_extract($"_c0","[^\\\\]*$",0)).show(false)
    var dfreplace = filDf1.withColumn("replced",regexp_replace($"_c0", "\\\\" , "/"))
     dfreplace.show(20,false)
    val df5=dfreplace.withColumn("filepath",regexp_extract($"replced","[^/]*$",0))
        .show(false)
//      df5.show(false)
//    val df6=df5.withColumn("withoutextension",regexp_extract($"filepath","s/\\.[^.]*$/\\./",0))
//    df6.show(20,false)
    //    val finDf2=finDf.select("_c3")
//    fildf3.show()
//    finDf.printSchema()
    sparksession.close()
  }

}
