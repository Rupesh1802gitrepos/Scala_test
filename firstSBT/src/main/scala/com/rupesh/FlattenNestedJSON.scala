package com.rupesh

import org.apache.spark.sql.types.{ArrayType, StructType}
import org.apache.spark.sql._
import org.apache.spark.sql.functions._

object FlattenNestedJSON {
  def main (args:Array[String]):Unit = {
    val sparksession = SparkSession.builder().master("local[*]").appName("FlatNestedJSON").getOrCreate()
    sparksession.sparkContext.setLogLevel("ERROR")
    val jsondf = sparksession.read.json("C:\\workspace\\firstSBT\\src\\main\\resources\\JSONobj")
    jsondf.show(false)

//    def flattenDataframe(df: DataFrame): DataFrame = {
//      import sparksession.implicits._
//      val fields = df.schema.fields
//      val fieldNames = fields.map(x => x.name)
//      println(fieldNames)
//      val length = fields.length
//
//      for(i <- 0 to fields.length-1){
//        val field = fields(i)
//        val fieldtype = field.dataType
//        val fieldName = field.name
//        fieldtype match {
//          case arrayType: ArrayType =>
//            val fieldNamesExcludingArray = fieldNames.filter(_!=fieldName)
//            val fieldNamesAndExplode = fieldNamesExcludingArray ++ Array(s"explode_outer($fieldName) as $fieldName")
//          // val fieldNamesToSelect = (fieldNamesExcludingArray ++ Array(s"$fieldName.*"))
//          val explodedDf = df.selectExpr(fieldNamesAndExplode:_*)
//            return flattenDataframe(explodedDf)
//          case structType: StructType =>val childFieldnames = structType.fieldNames.map(childname => fieldName +"."+childname)
//            val newfieldNames = fieldNames.filter(_!= fieldName) ++ childFieldnames
//            val renamedcols = newfieldNames.map(x => (col(x.toString()).as(x.toString().replace(".", "_"))))
//            val explodedf = df.select(renamedcols:_*)
//            return flattenDataframe(explodedf)
//          case _ =>
//        }
//      }
//    }
//    print(flattenDataframe(jsondf))
  }

}
