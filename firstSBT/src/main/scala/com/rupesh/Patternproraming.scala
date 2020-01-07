package com.rupesh

object Patternproraming {
  def main(args: Array[String]): Unit = {
      var a = 10
      for (i <- 1 to a)
        {
          for (j <- 1 to i)
            {
              print(i)
//              println("/n")
            }
          println()
        }
//    for (i <- a-1 to 1 by -1)
//      {
//        for (j <- 1 to i)
//          {
//            print(j)
//          }
//        println()
//      }
  }

}
