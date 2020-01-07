package com.rupesh

import org.apache.spark.sql._
//import org.apache.spark.sql.functions._

object JoinTest {
  def main(args: Array[String]): Unit = {
    val sparksession = SparkSession.builder().master("local[*]").appName("FlatNestedJSON").getOrCreate()
    sparksession.sparkContext.setLogLevel("ERROR")

//      import sparksession.implicits._

    val ErrorLogDF = sparksession.read
      .option("header", "true")
      //      .option("delimiter", "/")
//      .option("inferSchema", "true")
      .format("csv")
      .option("encoding", "UTF-8")
      .load("C:\\workspace\\firstSBT\\src\\main\\resources\\ErrorLogData.csv")

    val ExpectedOutputDF = sparksession.read
        .option("header","true")
//        .option("inferSchema","true")
        .format("csv")
        .load("C:\\workspace\\firstSBT\\src\\main\\resources\\ExpectedOutput.csv")

    val joinExpectedOutputDF_to_ErrorLogDF = ExpectedOutputDF.join(ErrorLogDF,ExpectedOutputDF("Field") === ErrorLogDF("Campo_Registro"),"inner")
    val joinErrorLogDF_to_ExpectedOutputDF = ErrorLogDF.join(ExpectedOutputDF,ErrorLogDF("Campo_Registro") === ExpectedOutputDF("Field"),"inner")

    joinExpectedOutputDF_to_ErrorLogDF.printSchema()
    joinExpectedOutputDF_to_ErrorLogDF.show()
    ErrorLogDF.printSchema()
    ExpectedOutputDF.printSchema()

    ErrorLogDF.show(false)
    ExpectedOutputDF.show(false)


    joinExpectedOutputDF_to_ErrorLogDF.printSchema()
    joinExpectedOutputDF_to_ErrorLogDF.show(100,false)

    joinErrorLogDF_to_ExpectedOutputDF.printSchema()
    joinErrorLogDF_to_ExpectedOutputDF.show(100,false)

    val expectedOutputDF_only_porteguees = ExpectedOutputDF.select("Field") //.show(false)
    val errorLogDF_only_porteguesse = ErrorLogDF.select("Campo_Registro")    //.show(false)

    val DiffDF = expectedOutputDF_only_porteguees.except(errorLogDF_only_porteguesse) .show(false)
    val reverseDiffDF = errorLogDF_only_porteguesse.except(expectedOutputDF_only_porteguees).show(false)
   // reverseDiffDF.explain()

//    val accfilepath = "abc/bcd/efg.txt"
//    val rejfilepath = ""
//    val rejectfilepath = "mnb/bvc/cxz.txt"
//
//    val allPath = Seq(accfilepath,rejfilepath,rejectfilepath).filter(!_.isEmpty)
//    for(i<-allPath )
//      {
//        println(i)
//      }


//    joinExpectedOutputDF_to_ErrorLogDF.explain()


      // exceptAll(errorLogDF_only_porteguesse)



    sparksession.close()
  }

}
