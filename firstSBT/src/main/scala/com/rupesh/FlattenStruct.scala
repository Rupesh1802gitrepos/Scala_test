package com.rupesh

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types._
import org.apache.spark.sql.functions._

object FlattenStruct {
  def main(args: Array[String]): Unit = {
    val sparksession = SparkSession.builder().master("local[*]").appName("testing JSON").getOrCreate()
    sparksession.sparkContext.setLogLevel("ERROR")
    val df1 = sparksession.read.option("multiline", true).json("C:\\workspace\\firstSBT\\src\\main\\resources\\JSONobj")

    def fullFlattenSchema(schema: StructType): Seq[String] = {
      def helper(schema: StructType, prefix: String): Seq[String]= {
        val fullName: String => String = name => if (prefix.isEmpty) name else s"$prefix.$name"
//        println(fullName)
        schema.fields.flatMap {
          case StructField(name, inner: StructType, _, _) => fullName(name) +: helper(inner, fullName(name))
          case StructField(name, _, _, _) => Seq(fullName(name))
        }
      }
      helper(schema, "")
    }

    print(fullFlattenSchema(df1.schema))
    import sparksession.implicits._

    val df_1 = fullFlattenSchema(df1.schema).toDF().show()
//    val df_2 = df_1.with

//    println(df_1)
  }
}
