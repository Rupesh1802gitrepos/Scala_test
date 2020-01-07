package com.rupesh

object PatternProgramming4 {
  def main(args: Array[String]): Unit = {
    var b =10
    for (i <- 1 to b){
      for (j <- 1 to i){
        print(j)
      }
      for (k<- i-1 to 1 by -1){
        print(k)
      }
      println()
    }
  }

}
