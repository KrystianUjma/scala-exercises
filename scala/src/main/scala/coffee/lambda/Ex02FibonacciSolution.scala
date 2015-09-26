package coffee.lambda

/* Problem 2: Tail-Recursion and Coinduction.
 * Implement two functions for computing the Fibonacci sequence.
 * First function should be tail-recursive.
 * Second should make use of infinite streams.
 */

object Ex02FibonacciSolution {

  def tf(n: Int, a: BigInt, b: BigInt): BigInt = n match {
    case 0 => a
    case _ => tf(n - 1, b, a + b)
  }

  def tailFibonacci(n: Int): BigInt = tf(n, 0, 1)

  val fibs: Stream[BigInt] = BigInt(0) #:: BigInt(1) #:: fibs.zip(fibs.tail).map({ case (x, y) => x + y })

  def streamFibonacci(n: Int): BigInt = fibs(n)
}
