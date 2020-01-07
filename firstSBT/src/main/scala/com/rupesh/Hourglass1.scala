package com.rupesh

object Hourglass1 {
  def main(args: Array[String]): Unit = {
    val arr = Array(Array(1, 2, 3, 1), Array(1, 2, 3, 1), Array(1, 2, 3, 1), Array(1, 2, 3, 1))
    var l = arr.length
    var w = arr.length
    for (i <- 0 until l - 2) {
      for (j <- 0 until w - 2){
        print(arr(i)(j)+"  ")
      }
      println()
    }
  }

}
