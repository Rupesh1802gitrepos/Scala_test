package com.rupesh

import org.apache.spark.sql._
import org.apache.spark.sql.functions._

object Transpose {
  def main(args: Array[String]): Unit = {
    val sparksession = SparkSession.builder().master("local[*]").appName("Transpose").getOrCreate()
    sparksession.sparkContext.setLogLevel("ERROR")
    import sparksession.implicits._
    val df = Seq((1, 0.0, 0.6), (1, 0.6, 0.7)).toDF("A", "col_1", "col_2")
    df.show(false)

    def toLong(df: DataFrame, by: Seq[String]): DataFrame = {
      val (cols, types) = df.dtypes.filter { case (c, _) => !by.contains(c) }.unzip
      require(types.distinct.size == 1, s"${types.distinct.toString}.length != 1")

      val kvs = explode(array(
        cols.map(c => struct(lit(c).alias("key"), col(c).alias("val"))): _*
      ))

      val byExprs = by.map(col(_))
      df
        .select(byExprs :+ kvs.alias("_kvs"): _*)
        .select(byExprs ++ Seq($"_kvs.key", $"_kvs.val"): _*)

    }
    toLong(df, Seq("A")).show(false)

  }

}
