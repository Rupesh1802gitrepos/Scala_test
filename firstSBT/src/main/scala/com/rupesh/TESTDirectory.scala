package com.rupesh

import org.apache.spark.sql.SparkSession

object TESTDirectory {
  def main(args: Array[String]): Unit = {
    val sparksession = SparkSession.builder().master("local[*]").appName("testing JSON").getOrCreate()
    sparksession.sparkContext.setLogLevel("ERROR")

   // val inputpath:Seq[String]= Seq("C:\\workspace\\firstSBT\\src\\main\\resources\\rejected\\*\\*.txt")

   // val df = sparksession.read.load(inputpath:_*)
  //  df.show()
  val lst1 =  List("NDD.NEWDATA.PDATA.D180629.Hxxxx37.txt.errorlenFileName.6590xxxxxxxxx","NDD.NEWDATA.PDATA.D180629.Hxxxx39.txt.errorheadFileName.6590xxxxxxxx",
    "NDD.NEWDATA.PDATA.D180629.Hxxxx28.txt.errorlenFileName.6590xxxxxxxxxx","NDD.NEWDATA.PDATA.D180629.Hxxxx27.txt.errorheadFileName.6590xxxxxxxxxxx",
    "NDD.NEWDATA.PDATA.D180629.Hxxxx47.txt.errorheadFileName.6590xxxxxxxxx","NDD.NEWDATA.PDATA.D180629.Hxxxx48.txt.errorlenFileName.6590xxxxxxxxxx",
    "NDD.NEWDATA.PDATA.D180629.Hxxxx41.txt.errorlenFileName.6590xxxxxxxxx","NDD.NEWDATA.PDATA.D180629.Hxxxx26.txt.659428910")
    println(lst1)
val s= "abc/def/zkj"
    val errorpath = lst1.filter(x=> x.contains("error")).map(x=> s+x).toSeq
    println(errorpath)
    val nonerrorpath = lst1.filter(x=> !(x.contains("error"))).toSeq
    println(nonerrorpath)

    val lst2:Seq[String] = Seq("a","b")
    val lst3 = errorpath.flatMap(x => lst2 :+ x)
    println(lst3)
    println(lst2)
    val lst4 = lst2 ++ errorpath
    println(lst4)
    println(lst3.size)
    println(lst4.size)
//    val a = "09062019".formatted()
    val b = "18112018"


//    def appendpath (path1:Seq[String],path2:Seq[String]):Seq[String] = {
//      path1 match {
//        case Nil => path1
//        case h :: t => h :: appendpath(t,path2)
//      }
//    }

  }





}
