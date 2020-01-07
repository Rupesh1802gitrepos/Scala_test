package com.rupesh

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object SplitItStruct {

  case class S1(FIELD_1: String, FIELD_2: Long, FIELD_3: Int)
  case class S2(FIELD_4: String, FIELD_5: Long, FIELD_6: Int)
  case class S3(FIELD_7: String, FIELD_8: Long, FIELD_9: Int)
  case class S4(FIELD_10: Int, FIELD_11: Int)


  def main(args: Array[String]): Unit = {
    val sparksession=SparkSession.builder().master("local[*]").appName("SplitStructType").getOrCreate()
   import sparksession.implicits._
    val df = Seq(
      (S1("a1", 101, 11), S2("a2", 102, 12), S3("a3", 103, 13), Array(S4(1, 1), S4(3, 3))),
      (S1("b1", 201, 21), S2("b2", 202, 22), S3("b3", 203, 23), Array(S4(2, 2), S4(4, 4)))
    ).toDF("STRUCT1", "STRUCT2", "STRUCT3", "ARRAYSTRUCT4")

    df.printSchema()


    val arrayCols = df.dtypes.filter( t => t._2.startsWith("ArrayType(StructType") ).
      map(_._1)

    val expandedDF = arrayCols.foldLeft(df)((accDF, c) =>
      accDF.withColumn(c.replace("ARRAY", ""), explode(col(c))).drop(c)
    )
    val df2=df.withColumn("struct",$"STRUCT1.FIELD_1")
        .withColumn("structfield2",$"STRUCT1.FIELD_2")

    df2.show(false)
    val df1 = df.select($"STRUCT1.*").collectAsList()

//    df1.show(false)
//    for (i <- df1){
//      println(i)
//    }

//    val df3= df.select($"STRUCT1.*").show()
//    df.withColumn("STRUCT1", _1._1).show()










//    sparksession.close()


  }

}
