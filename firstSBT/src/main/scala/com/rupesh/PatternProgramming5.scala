package com.rupesh

object PatternProgramming5 {
  def main(args: Array[String]): Unit = {
    var a =10
    for (i <- 1 to a){
      for( j <- 1 to i){
        print(" ")
      }
      for (j<- i to a){
        print(j)
      }
      println()
    }

    for (i <- a-1 to 1 by -1){
//      println("value"+i)
      for (j <- 1 to i ){
        print(" ")
      }
      for (j<- i to a){
        print(j)
      }
      println()
    }
  }

}
