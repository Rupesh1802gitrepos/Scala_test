package com.rupesh

import scala.collection.mutable

object Mapdiff {
  def main(args: Array[String]): Unit = {
    val x = Map(1 -> "a", 2 -> "b", 3 -> "c")
    val y = Map(1 -> "a", 2 -> "b", 4 -> "d")

    val xh = mutable.HashMap(1 -> "a", 2 -> "b", 3 -> "c")
    val yh = mutable.HashMap(1 -> "a", 2 -> "b", 4 -> "d")
    val diff : Map[Int, String] = x -- y.keySet

    val test1 = x.toSet diff y.toSet
    println(test1)
    val test:List[Map[Int,String]] = List(Map(1 -> "a", 2 -> "b", 3 -> "c"),Map(1 -> "a", 2 -> "b", 3 -> "c"))

    val test2 = test.distinct.length
    println(test2)
    val test3 = List(1, 2, 2, 1, 1,5,6,7).distinct.length
    println(test3)
    val test7 = List(1, 2, 2, 1, 1,5,6,7)

    val test4:List[mutable.HashMap[Int,String]] = List(mutable.HashMap(1 -> "a", 2 -> "b", 3 -> "c"),mutable.HashMap(1 -> "a", 2 -> "b", 4 -> "d"))

    val test5 = test4.distinct.length
    println(test5)
    val a = 2
    if (test7.contains(a)){
      print("yest it contains")
      


    }
  }

}
