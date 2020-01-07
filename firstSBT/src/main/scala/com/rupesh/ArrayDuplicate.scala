package com.rupesh

object ArrayDuplicate {
  def main(args: Array[String]): Unit = {

    val arr = Array(1, 4, 6, 9, 3, 7, 5, 2, 5)
    import java.util
    System.out.println(util.Arrays.toString(arr))
    val result = findMissingAndDuplicate(arr, 9)
    System.out.println("Duplicate Element : " + result(0))
    System.out.println("Missing Element : " + result(1))
//    val result = new Array[Int](2)
//    val  = Math.abs(arr(i))
//    arr(`val` - 1) = -1 * arr(`val` - 1)

  }

  def findMissingAndDuplicate(arr: Array[Int], n: Int): Array[Int] = {
    val result = new Array[Int](2)
    for (i <- 0 until arr.size-1) {
      println(i)
      println("arr(i)  = "+ arr(i))
      val value = Math.abs(arr(i))
      println("value  =  "+ value)
      if (arr(value - 1) < 0) {
        result(0) = value
      }
//      println(arr(value))
      arr(value - 1) = -1 * arr(value - 1)
      print("arr(value -1) = "+ arr(value - 1))
    }
      for (i <- 0 until arr.size -1 ) {
        if (arr(i)>0 && i != result(0)-1) {
          result(1) = i+ 1
        }
      }
result
    }
  }


