package com.rupesh

object PatternProgramming8 {
  def main(args: Array[String]): Unit = {
    var a = 10
    for (i <- 1 to a){
      for (j <- i to 1 by -1){
        print(" ")
      }
      for (j<- i to a){
        print(j+" ")
      }
      println()
    }
  }
}
