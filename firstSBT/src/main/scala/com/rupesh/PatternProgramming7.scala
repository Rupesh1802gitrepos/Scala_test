package com.rupesh

object PatternProgramming7 {
  def main(args: Array[String]): Unit = {
    var a =10
    for (i<- 1 to a){
      for (j <- 1 to i){
        if (j%2==0){
          print(0)
        }
        else{
          print(1)
        }
      }
      println()
    }
  }

}
