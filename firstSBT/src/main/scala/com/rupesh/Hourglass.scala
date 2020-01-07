package com.rupesh

object Hourglass {
  def main(args: Array[String]): Unit = {

    val arr = Array(Array(1, 2, 3, 1,5), Array(1, 2, 3, 1,5), Array(1, 2, 3, 1,5), Array(1, 2, 3, 1,5),Array(9,8,7,1,5))


//    def hourglassSum(arr: Array[Array[Int]]): Unit = {
      var l = arr.length
     var lx = (l-2)+1
//      println("value of l "+ l)
      var w = arr.length
    var wx=(w-2)+1
//      println(" value of w"+w)
//      var narr = new Array[Array[Int]](l-1)(w-1)
      for (i <- 0 until l - 2) {
        for (j <- 0 until w - 2) {
//          var sum = 0
          for (k <- i until i+lx) {
            for (y <- j until j+wx) {
              if(k != i+1){
//                sum = sum + arr(k)(y)
                print(arr(k)(y))
              }
              if ((k == i+1) && (y == j+1)){
//                sum = sum+arr(k)(y)
                print(" "+arr(k)(y)+" ")
              }
//              sum = sum + arr(k)(y)
//              print(arr(k)(y))
            }
            println()

          }
          println("--------------------------------")
        }
//        println()
      }
    }

//    hourglassSum(arr)


}
