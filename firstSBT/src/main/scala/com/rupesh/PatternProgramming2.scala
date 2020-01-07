package com.rupesh

object PatternProgramming2 {
  def main(args: Array[String]): Unit = {
    var a =10
    for (i <- 1 to a)
      {
        for (j <- a  to i by -1)
          {
            print(j)
          }
        println()
      }
  }

}
