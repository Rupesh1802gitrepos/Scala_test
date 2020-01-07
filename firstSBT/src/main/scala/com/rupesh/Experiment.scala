package com.rupesh

object Experiment {
  def main(args: Array[String]): Unit = {
  var strings=Array("abcde","sdaklfj","asdjf","na","basdn","sdaklfj","asdjf","na","asdjf","na","basdn","sdaklfj","asdjf")
    var queries=Array("abcde","sdaklfj","asdjf","na","basdn")
//    println((matchingStrings(strings,queries)).toList)

    def matchingStrings(strings: Array[String], queries: Array[String]): Unit ={
      println("inside function")
      var count=0
      val j=queries.length
      var arr = new Array[Int](j)
      for (i <- 0 until queries.length ) {

        for (k <- 0 until strings.length ) {

//          println("before if")
          if (queries(i) == strings(k)) {
            count = count + 1

          }

        }
        println(count)
        for (z <- 0 until j ) {
          arr(z) = count
        }
        count = 0
      }
      for(i <- arr){
        print(arr(i))
      }

    }

    val res = matchingStrings(strings, queries)

  }

}
