package com.rupesh

object Patternprogramming3 {

  def main(args: Array[String]): Unit = {
//
//    var a =10
//    for (i <- a to 1 by -1){
//      for(j <- 1 to i){
//        print(j)
//      }
//      println()
//    }
    var b=10
    for(i<- b to 1 by -1){
//      print(i)
      for (j<- i to 1  by -1){
        print(j)
      }
      println()
    }


  }


}
