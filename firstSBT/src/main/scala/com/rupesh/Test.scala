package com.rupesh

object Test {
  def main(args: Array[String]): Unit = {
    var a= 10
    for(i<- a to 1 by -1 ){
      //      print(i)
      for (j<- 1 to i    ){
        print(j)
      }
      println()
    }
    for (i <- 1 to a  ){
      for(j <- 1 to i){
        print(j)
      }
      println()
    }
  }

}
