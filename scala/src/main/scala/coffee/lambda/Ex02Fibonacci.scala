package coffee.lambda

/* Problem 2: Tail-Recursion and Coinduction.
 * Implement two functions for computing the Fibonacci sequence.
 * First function should be tail-recursive.
 * Second should make use of infinite streams.
 */

object Ex02Fibonacci {
  def tf (n: Int, a: BigInt, b: BigInt): BigInt = if (n == 0) b else tf(n-1, b, a + b )

  def tailFibonacci(n: Int): BigInt = tf(n, 0, 1)
  val fibs: Stream[BigInt] = 0 #:: 1 #:: fibs.zip(fibs.tail).map({case (x,y) => x + y})
  //val fibs: Stream[BigInt] = 0 #:: 1 #:: fibs.zip(fibs.tail).map({ y => y._1 + y._2 })
  def streamFibonacci(n: Int): BigInt = fibs(n)

//  def doNTimes(n: Int, fun: Unit => Unit):Unit = {
//    if(n > 0){
//      fun()
//      doNTimes(n-1, )
//    }
//  }
}
