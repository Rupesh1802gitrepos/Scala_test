package com.rupesh

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._

object JsonHeadache {
  def main(args: Array[String]): Unit = {
    val sparksession = SparkSession.builder().master("local[*]").appName("testing JSON").getOrCreate()
    sparksession.sparkContext.setLogLevel("ERROR")
    import sparksession.implicits._

//    schema = StructType([
//      StructField("name",StringType(),true),
//    StructField("address",StructType([
//      StructField("city",StringType(),true),
//      StructField("state",StringType(),true)])
//    ])
    val df1=sparksession.read.option("multiline",true).json("C:\\workspace\\firstSBT\\src\\main\\resources\\JSONobj")

//    val schema = schema_of_json(lit(df1.select($"address").as[String].first))
val selectColumns = df1.columns.toSeq
//    df1.registerTempTable("table1")

    println(selectColumns)
    df1.printSchema()
    df1.show(false)
//    val s =sparksession.sql("select * from table1").show(false)


    def findFields(df:DataFrame,dt: DataType) = {
      val fieldName = dt.asInstanceOf[StructType].fields
      for (value <- fieldName) {
        val colNames = value.productElement(1).asInstanceOf[StructType].fields
        for (f <- colNames) {
          println("Inner Columns of " + value.name + " -->>" + f.name)
        }
      }
    }

//    def findFields2(path: String, dt: DataType): Unit = dt match {
//      case s: StructType =>
//        s.fields.foreach(f => findFields( f.name, f.dataType))
//      case other =>
//        println(s"$path: $other")
//    }

//    val fieldname1 = df1.schema.fields
//    println(fieldname1)
//     for(i <- fieldname1){
//        println(i.toString())
//     }
//    print(fieldname1)

  //  val b = findFields(df1,df1.schema)

//    val c = println(findFields2("abc",df1.schema))


    def fullFlattenSchema(schema: StructType): Seq[String] = {
      def helper(schema: StructType, prefix: String): Seq[String] = {
        val fullName: String => String = name => if (prefix.isEmpty) name else s"$prefix.$name"
        schema.fields.flatMap {
          case StructField(name, inner: StructType, _, _) =>
            fullName(name) +: helper(inner, fullName(name))
          case StructField(name, _, _, _) => Seq(fullName(name))
        }
      }

      helper(schema, "")
    }

//    println(df1.)


    def removeEscapeCharacterFromString: String => String = (jsonStr: String) => jsonStr
      .replace("\"\\\"", "\"")
      .replace("\\\"\"", "\"")
      .replace("\\\"", "\"")
      .replace("\"{", "{")
      .replace("}\"", "}")



    val df2= fullFlattenSchema(df1.schema).toDF()
       df2.show()

    val columnname=fullFlattenSchema(df1.schema)
    for (i <- columnname){
      println(i)
    }

   val df5= df1.select($"address.*")
    df5.show(false)
 //   val df3= df2.withColumn("col3",substring($"city",0,2))
  //  df3.show(false)


    sparksession.close()
  }

}
